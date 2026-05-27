package com.alicp.jetcache.redis.springdata;

import com.alicp.jetcache.CacheManager;
import com.alicp.jetcache.external.ExternalCacheBuilder;
import com.alicp.jetcache.support.BroadcastManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;

/**
 * Created on 2019/4/21.
 *
 * @author huangli
 */
public class RedisSpringDataCacheBuilder<T extends ExternalCacheBuilder<T>> extends ExternalCacheBuilder<T> {

    public static class RedisSpringDataCacheBuilderImpl extends RedisSpringDataCacheBuilder<RedisSpringDataCacheBuilderImpl> {
    }

    public static RedisSpringDataCacheBuilderImpl createBuilder() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected RedisSpringDataCacheBuilder() {
        buildFunc(config -> new RedisSpringDataCache((RedisSpringDataCacheConfig) config));
    }

    @Override
    public RedisSpringDataCacheConfig getConfig() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean supportBroadcast() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public BroadcastManager createBroadcastManager(CacheManager cacheManager) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public T connectionFactory(RedisConnectionFactory connectionFactory) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setConnectionFactory(RedisConnectionFactory connectionFactory) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public T listenerContainer(RedisMessageListenerContainer listenerContainer) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setListenerContainer(RedisMessageListenerContainer listenerContainer) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
