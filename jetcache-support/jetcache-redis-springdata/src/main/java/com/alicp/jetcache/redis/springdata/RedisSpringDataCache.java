package com.alicp.jetcache.redis.springdata;

import com.alicp.jetcache.CacheConfigException;
import com.alicp.jetcache.CacheGetResult;
import com.alicp.jetcache.CacheResult;
import com.alicp.jetcache.CacheResultCode;
import com.alicp.jetcache.CacheValueHolder;
import com.alicp.jetcache.MultiGetResult;
import com.alicp.jetcache.external.AbstractExternalCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStringCommands;
import org.springframework.data.redis.core.types.Expiration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

/**
 * Created on 2019/4/4.
 *
 * @author huangli
 */
public class RedisSpringDataCache<K, V> extends AbstractExternalCache<K, V> {

    private Logger logger = LoggerFactory.getLogger(RedisSpringDataCache.class);

    private RedisConnectionFactory connectionFactory;

    private RedisSpringDataCacheConfig<K, V> config;

    private Function<Object, byte[]> valueEncoder;

    private Function<byte[], Object> valueDecoder;

    public RedisSpringDataCache(RedisSpringDataCacheConfig<K, V> config) {
        super(config);
        this.connectionFactory = config.getConnectionFactory();
        if (connectionFactory == null) {
            throw new CacheConfigException("connectionFactory is required");
        }
        this.config = config;
        this.valueEncoder = config.getValueEncoder();
        this.valueDecoder = config.getValueDecoder();
    }

    private void closeConnection(RedisConnection connection) {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (Exception ex) {
            logger.error("RedisConnection close fail: {}, {}", ex.getMessage(), ex.getClass().getName());
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

    @Override
    protected CacheResult do_REMOVE_ALL(Set<? extends K> keys) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected CacheResult do_PUT_IF_ABSENT(K key, V value, long expireAfterWrite, TimeUnit timeUnit) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <T> T unwrap(Class<T> clazz) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public RedisSpringDataCacheConfig<K, V> config() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
