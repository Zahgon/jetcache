package com.alicp.jetcache.redis.lettuce;

import com.alicp.jetcache.anno.CacheConsts;
import com.alicp.jetcache.external.ExternalCacheConfig;
import io.lettuce.core.AbstractRedisClient;
import io.lettuce.core.api.StatefulConnection;
import io.lettuce.core.pubsub.StatefulRedisPubSubConnection;

/**
 * Created on 2017/4/28.
 *
 * @author huangli
 */
public class RedisLettuceCacheConfig<K, V> extends ExternalCacheConfig<K, V> {

    private AbstractRedisClient redisClient;

    private StatefulConnection<byte[], byte[]> connection;

    private StatefulRedisPubSubConnection<byte[], byte[]> pubSubConnection;

    private LettuceConnectionManager connectionManager = LettuceConnectionManager.defaultManager();

    private long asyncResultTimeoutInMillis = CacheConsts.ASYNC_RESULT_TIMEOUT.toMillis();

    public AbstractRedisClient getRedisClient() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setRedisClient(AbstractRedisClient redisClient) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public StatefulConnection<byte[], byte[]> getConnection() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setConnection(StatefulConnection<byte[], byte[]> connection) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public long getAsyncResultTimeoutInMillis() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setAsyncResultTimeoutInMillis(long asyncResultTimeoutInMillis) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public StatefulRedisPubSubConnection<byte[], byte[]> getPubSubConnection() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setPubSubConnection(StatefulRedisPubSubConnection<byte[], byte[]> pubSubConnection) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public LettuceConnectionManager getConnectionManager() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setConnectionManager(LettuceConnectionManager connectionManager) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
