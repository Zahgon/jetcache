package com.alicp.jetcache.redis.lettuce;

import com.alicp.jetcache.CacheConfigException;
import com.alicp.jetcache.CacheException;
import io.lettuce.core.AbstractRedisClient;
import io.lettuce.core.RedisClient;
import io.lettuce.core.api.StatefulConnection;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.cluster.RedisClusterClient;
import io.lettuce.core.cluster.api.StatefulRedisClusterConnection;
import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;

/**
 * Created on 2017/4/28.
 *
 * @author huangli
 */
public class LettuceConnectionManager {

    private static class LettuceObjects {

        private StatefulConnection connection;

        private Object commands;

        private Object asyncCommands;

        private Object reactiveCommands;
    }

    private static final LettuceConnectionManager defaultManager = new LettuceConnectionManager();

    private final Map<AbstractRedisClient, LettuceObjects> map = Collections.synchronizedMap(new WeakHashMap());

    private LettuceConnectionManager() {
    }

    public static LettuceConnectionManager defaultManager() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private LettuceObjects getLettuceObjectsFromMap(AbstractRedisClient redisClient) {
        LettuceObjects lo = map.get(redisClient);
        if (lo == null) {
            throw new CacheException("LettuceObjects is not initialized");
        }
        return lo;
    }

    public void init(AbstractRedisClient redisClient, StatefulConnection connection) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public StatefulConnection connection(AbstractRedisClient redisClient) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Object commands(AbstractRedisClient redisClient) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Object asyncCommands(AbstractRedisClient redisClient) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Object reactiveCommands(AbstractRedisClient redisClient) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void removeAndClose(AbstractRedisClient redisClient) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
