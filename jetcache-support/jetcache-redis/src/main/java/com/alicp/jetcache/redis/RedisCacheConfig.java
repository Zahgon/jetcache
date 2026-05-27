package com.alicp.jetcache.redis;

import com.alicp.jetcache.external.ExternalCacheConfig;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.UnifiedJedis;
import redis.clients.jedis.util.Pool;

/**
 * Created on 2016/10/7.
 *
 * @author huangli
 */
public class RedisCacheConfig<K, V> extends ExternalCacheConfig<K, V> {

    private Pool<Jedis> jedisPool;

    private Pool<Jedis>[] jedisSlavePools;

    private UnifiedJedis jedis;

    private UnifiedJedis[] slaves;

    private boolean readFromSlave;

    private int[] slaveReadWeights;

    public Pool<Jedis> getJedisPool() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setJedisPool(Pool<Jedis> jedisPool) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Pool<Jedis>[] getJedisSlavePools() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setJedisSlavePools(Pool<Jedis>... jedisSlavePools) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public UnifiedJedis getJedis() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setJedis(UnifiedJedis jedis) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public UnifiedJedis[] getSlaves() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setSlaves(UnifiedJedis[] slaves) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public boolean isReadFromSlave() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setReadFromSlave(boolean readFromSlave) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public int[] getSlaveReadWeights() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setSlaveReadWeights(int... slaveReadWeights) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
