package com.alicp.jetcache.redisson;

import com.alicp.jetcache.external.ExternalCacheConfig;
import org.redisson.api.RedissonClient;

/**
 * Created on 2022/7/12.
 *
 * @author <a href="mailto:jeason1914@qq.com">yangyong</a>
 */
public class RedissonCacheConfig<K, V> extends ExternalCacheConfig<K, V> {

    private RedissonClient redissonClient;

    public RedissonClient getRedissonClient() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setRedissonClient(final RedissonClient redissonClient) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
