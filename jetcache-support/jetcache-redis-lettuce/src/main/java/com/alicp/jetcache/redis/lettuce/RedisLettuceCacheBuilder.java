package com.alicp.jetcache.redis.lettuce;

import com.alicp.jetcache.CacheManager;
import com.alicp.jetcache.external.ExternalCacheBuilder;
import com.alicp.jetcache.support.BroadcastManager;
import io.lettuce.core.AbstractRedisClient;
import io.lettuce.core.api.StatefulConnection;
import io.lettuce.core.pubsub.StatefulRedisPubSubConnection;

/**
 * Created on 2017/4/28.
 *
 * @author huangli
 */
public class RedisLettuceCacheBuilder<T extends ExternalCacheBuilder<T>> extends ExternalCacheBuilder<T> {

    public static class RedisLettuceCacheBuilderImpl extends RedisLettuceCacheBuilder<RedisLettuceCacheBuilderImpl> {
    }

    public static RedisLettuceCacheBuilderImpl createRedisLettuceCacheBuilder() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected RedisLettuceCacheBuilder() {
        buildFunc(config -> new RedisLettuceCache((RedisLettuceCacheConfig) config));
    }

    @Override
    public RedisLettuceCacheConfig getConfig() {
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

    public T redisClient(AbstractRedisClient redisClient) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setRedisClient(AbstractRedisClient redisClient) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public T connection(StatefulConnection connection) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setConnection(StatefulConnection connection) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public T pubSubConnection(StatefulRedisPubSubConnection pubSubConnection) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setPubSubConnection(StatefulRedisPubSubConnection pubSubConnection) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public T connectionManager(LettuceConnectionManager connectionManager) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setConnectionManager(LettuceConnectionManager connectionManager) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public T asyncResultTimeoutInMillis(long asyncResultTimeoutInMillis) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setAsyncResultTimeoutInMillis(long asyncResultTimeoutInMillis) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
