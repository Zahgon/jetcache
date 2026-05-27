package com.alicp.jetcache.redis.lettuce;

import com.alicp.jetcache.CacheConfig;
import com.alicp.jetcache.CacheConfigException;
import com.alicp.jetcache.CacheGetResult;
import com.alicp.jetcache.CacheResult;
import com.alicp.jetcache.CacheResultCode;
import com.alicp.jetcache.CacheValueHolder;
import com.alicp.jetcache.MultiGetResult;
import com.alicp.jetcache.ResultData;
import com.alicp.jetcache.external.AbstractExternalCache;
import com.alicp.jetcache.support.JetCacheExecutor;
import io.lettuce.core.AbstractRedisClient;
import io.lettuce.core.KeyValue;
import io.lettuce.core.RedisFuture;
import io.lettuce.core.SetArgs;
import io.lettuce.core.api.async.RedisKeyAsyncCommands;
import io.lettuce.core.api.async.RedisStringAsyncCommands;
import io.lettuce.core.api.sync.RedisStringCommands;
import io.lettuce.core.cluster.api.async.RedisClusterAsyncCommands;
import io.lettuce.core.cluster.api.reactive.RedisClusterReactiveCommands;
import io.lettuce.core.cluster.api.sync.RedisClusterCommands;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

/**
 * Created on 2017/4/28.
 *
 * @author huangli
 */
public class RedisLettuceCache<K, V> extends AbstractExternalCache<K, V> {

    private final RedisLettuceCacheConfig<K, V> config;

    private final Function<Object, byte[]> valueEncoder;

    private final Function<byte[], Object> valueDecoder;

    private final AbstractRedisClient client;

    private final LettuceConnectionManager lettuceConnectionManager;

    private final RedisStringCommands<byte[], byte[]> stringCommands;

    private final RedisStringAsyncCommands<byte[], byte[]> stringAsyncCommands;

    private final RedisKeyAsyncCommands<byte[], byte[]> keyAsyncCommands;

    public RedisLettuceCache(RedisLettuceCacheConfig<K, V> config) {
        super(config);
        this.config = config;
        this.valueEncoder = config.getValueEncoder();
        this.valueDecoder = config.getValueDecoder();
        if (config.getRedisClient() == null) {
            throw new CacheConfigException("RedisClient is required");
        }
        if (config.isExpireAfterAccess()) {
            throw new CacheConfigException("expireAfterAccess is not supported");
        }
        client = config.getRedisClient();
        lettuceConnectionManager = config.getConnectionManager();
        lettuceConnectionManager.init(client, config.getConnection());
        stringCommands = (RedisStringCommands<byte[], byte[]>) lettuceConnectionManager.commands(client);
        stringAsyncCommands = (RedisStringAsyncCommands<byte[], byte[]>) lettuceConnectionManager.asyncCommands(client);
        keyAsyncCommands = (RedisKeyAsyncCommands<byte[], byte[]>) stringAsyncCommands;
    }

    @Override
    public <T> T unwrap(Class<T> clazz) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public CacheConfig<K, V> config() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private void setTimeout(CacheResult cr) {
        Duration d = Duration.ofMillis(config.getAsyncResultTimeoutInMillis());
        cr.setTimeout(d);
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
    protected CacheGetResult<V> do_GET(K key) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected MultiGetResult<K, V> do_GET_ALL(Set<? extends K> keys) {
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
}
