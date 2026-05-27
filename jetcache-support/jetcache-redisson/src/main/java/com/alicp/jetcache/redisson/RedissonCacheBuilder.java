package com.alicp.jetcache.redisson;

import com.alicp.jetcache.CacheManager;
import com.alicp.jetcache.external.ExternalCacheBuilder;
import com.alicp.jetcache.support.BroadcastManager;
import org.redisson.api.RedissonClient;

/**
 * Created on 2022/7/12.
 *
 * @author <a href="mailto:jeason1914@qq.com">yangyong</a>
 */
public class RedissonCacheBuilder<T extends ExternalCacheBuilder<T>> extends ExternalCacheBuilder<T> {

    public static class RedissonDataCacheBuilderImpl extends RedissonCacheBuilder<RedissonDataCacheBuilderImpl> {
    }

    public static RedissonDataCacheBuilderImpl createBuilder() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @SuppressWarnings({ "all" })
    protected RedissonCacheBuilder() {
        buildFunc(config -> new RedissonCache((RedissonCacheConfig) config));
    }

    @Override
    @SuppressWarnings({ "all" })
    public RedissonCacheConfig getConfig() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public T redissonClient(final RedissonClient client) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean supportBroadcast() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public BroadcastManager createBroadcastManager(final CacheManager cacheManager) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
