package com.alicp.jetcache.redis;

import com.alicp.jetcache.CacheConfig;
import com.alicp.jetcache.CacheConfigException;
import com.alicp.jetcache.CacheException;
import com.alicp.jetcache.CacheGetResult;
import com.alicp.jetcache.CacheResult;
import com.alicp.jetcache.CacheResultCode;
import com.alicp.jetcache.CacheValueHolder;
import com.alicp.jetcache.MultiGetResult;
import com.alicp.jetcache.external.AbstractExternalCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.ClusterPipeline;
import redis.clients.jedis.Connection;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPooled;
import redis.clients.jedis.Pipeline;
import redis.clients.jedis.Response;
import redis.clients.jedis.UnifiedJedis;
import redis.clients.jedis.commands.KeyBinaryCommands;
import redis.clients.jedis.commands.KeyPipelineBinaryCommands;
import redis.clients.jedis.commands.StringBinaryCommands;
import redis.clients.jedis.commands.StringPipelineBinaryCommands;
import redis.clients.jedis.params.SetParams;
import redis.clients.jedis.providers.ClusterConnectionProvider;
import redis.clients.jedis.util.Pool;
import java.io.Closeable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created on 2016/10/7.
 *
 * @author huangli
 */
public class RedisCache<K, V> extends AbstractExternalCache<K, V> {

    private static Logger logger = LoggerFactory.getLogger(RedisCache.class);

    protected RedisCacheConfig<K, V> config;

    Function<Object, byte[]> valueEncoder;

    Function<byte[], Object> valueDecoder;

    ClusterConnectionProvider provider = null;

    private static ThreadLocalRandom random = ThreadLocalRandom.current();

    public RedisCache(RedisCacheConfig<K, V> config) {
        super(config);
        this.config = config;
        this.valueEncoder = config.getValueEncoder();
        this.valueDecoder = config.getValueDecoder();
        if (config.getJedis() == null && config.getJedisPool() == null) {
            throw new CacheConfigException("no jedis");
        }
        if (config.getJedis() != null && config.getJedisPool() != null) {
            throw new CacheConfigException("'jedis' and 'jedisPool' can't set simultaneously");
        }
        if (config.getJedis() != null && config.getJedisSlavePools() != null) {
            throw new CacheConfigException("'jedisSlavePools' should work with 'jedisPool' in RedisCacheConfig");
        }
        if (config.getJedisPool() != null && config.getSlaves() != null) {
            throw new CacheConfigException("'slaves' should work with 'jedis' in RedisCacheConfig");
        }
        if (config.isReadFromSlave()) {
            if (slaveCount() == 0) {
                throw new CacheConfigException("slaves not config");
            }
            if (config.getSlaveReadWeights() == null) {
                initDefaultWeights();
            } else if (config.getSlaveReadWeights().length != slaveCount()) {
                logger.error("length of slaveReadWeights and jedisSlavePools not equals, using default weights");
                initDefaultWeights();
            }
        }
        if (config.isExpireAfterAccess()) {
            throw new CacheConfigException("expireAfterAccess is not supported");
        }
        UnifiedJedis jedis = config.getJedis();
        if (jedis != null && jedis instanceof JedisCluster) {
            try {
                Field field = UnifiedJedis.class.getDeclaredField("provider");
                boolean accessible = field.isAccessible();
                field.setAccessible(true);
                provider = (ClusterConnectionProvider) field.get(jedis);
                field.setAccessible(accessible);
            } catch (Exception ex) {
                throw new IllegalStateException("can not get ConnectionProvider from JedisClient", ex);
            }
        }
    }

    private int slaveCount() {
        if (config.getSlaves() != null) {
            return config.getSlaves().length;
        }
        if (config.getJedisSlavePools() != null) {
            return config.getJedisSlavePools().length;
        }
        return 0;
    }

    private void initDefaultWeights() {
        int len = slaveCount();
        int[] weights = new int[len];
        Arrays.fill(weights, 100);
        config.setSlaveReadWeights(weights);
    }

    @Override
    public CacheConfig<K, V> config() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <T> T unwrap(Class<T> clazz) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    Object writeCommands() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    Object readCommands() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static int randomIndex(int[] weights) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static void closeJedis(Object maybeJedis) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static void close(Closeable closeable) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (Exception e) {
            logger.warn("close jedis resource error: {}", e.toString());
        }
    }

    @Override
    protected CacheGetResult<V> do_GET(K key) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected MultiGetResult<K, V> do_GET_ALL(Set<? extends K> keys) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected CacheResult do_PUT(K key, V value, long expireAfterWrite, TimeUnit timeUnit) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected CacheResult do_PUT_ALL(Map<? extends K, ? extends V> map, long expireAfterWrite, TimeUnit timeUnit) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected CacheResult do_REMOVE(K key) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private CacheResult REMOVE_impl(Object key, byte[] newKey) {
        KeyBinaryCommands commands = null;
        try {
            commands = (KeyBinaryCommands) writeCommands();
            Long rt = commands.del(newKey);
            if (rt == null) {
                return CacheResult.FAIL_WITHOUT_MSG;
            } else if (rt == 1) {
                return CacheResult.SUCCESS_WITHOUT_MSG;
            } else if (rt == 0) {
                return new CacheResult(CacheResultCode.NOT_EXISTS, null);
            } else {
                return CacheResult.FAIL_WITHOUT_MSG;
            }
        } catch (Exception ex) {
            logError("REMOVE", key, ex);
            return new CacheResult(ex);
        } finally {
            closeJedis(commands);
        }
    }

    @Override
    protected CacheResult do_REMOVE_ALL(Set<? extends K> keys) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected CacheResult do_PUT_IF_ABSENT(K key, V value, long expireAfterWrite, TimeUnit timeUnit) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Useful function for redis interaction via Pipeline mode. Resources will be auto close. <br/>
     * For batch command, such as {@link StringBinaryCommands#mget(byte[]...)}, {@link KeyBinaryCommands#del(byte[]...)}, the performance of pipeline will be worse,
     * so choose them instead of pipeline as much as possible in non-cluster clients, See:
     * - https://medium.com/@jychen7/redis-get-pipeline-vs-mget-6e41aeaecef
     * - https://stackoverflow.com/questions/73992769/redis-del-many-keys-vs-pipeline-are-both-non-blocking
     *
     * @param client        redisClient
     * @param pipelineFirst set as false when only want to use the pipeline on cluster clients.
     * @param function      operator function
     * @param <C>           client type
     * @param <P>           pipeline type
     * @param <R>           result type
     * @return result
     */
    @SuppressWarnings("unchecked")
    private <C, P, R> R doWithPipeline(C client, boolean pipelineFirst, Function<P, R> function) {
        C commands = null;
        Closeable closeable = null;
        try {
            commands = client;
            P pipeline = null;
            // The connection from JedisPooled or JedisCluster needs to be returned to the pool.
            if (commands instanceof JedisCluster) {
                ClusterPipeline clusterPipeline = new ClusterPipeline(provider);
                closeable = clusterPipeline;
                pipeline = (P) clusterPipeline;
            } else if (pipelineFirst) {
                if (commands instanceof JedisPooled) {
                    Connection connection = ((JedisPooled) commands).getPool().getResource();
                    closeable = connection;
                    pipeline = (P) new Pipeline(connection);
                } else if (commands instanceof Jedis) {
                    pipeline = (P) new Pipeline((Jedis) commands);
                }
            }
            return function.apply(pipeline);
        } finally {
            closeJedis(commands);
            close(closeable);
        }
    }

    private <T> void sync(T pipeline) {
        if (pipeline instanceof Pipeline) {
            ((Pipeline) pipeline).sync();
        } else if (pipeline instanceof ClusterPipeline) {
            ((ClusterPipeline) pipeline).sync();
        } else {
            throw new UnsupportedOperationException("unrecognized pipeline type");
        }
    }
}
