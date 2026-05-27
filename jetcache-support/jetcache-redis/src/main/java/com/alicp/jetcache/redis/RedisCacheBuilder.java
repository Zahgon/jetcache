package com.alicp.jetcache.redis;

import com.alicp.jetcache.CacheConfig;
import com.alicp.jetcache.CacheManager;
import com.alicp.jetcache.external.ExternalCacheBuilder;
import com.alicp.jetcache.support.BroadcastManager;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.UnifiedJedis;
import redis.clients.jedis.util.Pool;

/**
 * Created on 2016/10/7.
 *
 * @author huangli
 */
public class RedisCacheBuilder<T extends ExternalCacheBuilder<T>> extends ExternalCacheBuilder<T> {

    public static class RedisCacheBuilderImpl extends RedisCacheBuilder<RedisCacheBuilderImpl> {
    }

    public static RedisCacheBuilderImpl createRedisCacheBuilder() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected RedisCacheBuilder() {
        buildFunc(config -> new RedisCache((RedisCacheConfig) config));
    }

    @Override
    public RedisCacheConfig getConfig() {
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

    public T jedisPool(Pool<Jedis> pool) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setJedisPool(Pool<Jedis> jedisPool) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public T jedis(UnifiedJedis jedis) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setJedis(UnifiedJedis jedis) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public T readFromSlave(boolean readFromSlave) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setReadFromSlave(boolean readFromSlave) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public T jedisSlavePools(Pool<Jedis>... jedisSlavePools) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setJedisSlavePools(Pool<Jedis>... jedisSlavePools) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public T slaves(UnifiedJedis... slaves) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setSlaves(UnifiedJedis... slaves) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public T slaveReadWeights(int... slaveReadWeights) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setSlaveReadWeights(int... slaveReadWeights) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
