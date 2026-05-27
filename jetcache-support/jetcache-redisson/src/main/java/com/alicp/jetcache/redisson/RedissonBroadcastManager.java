package com.alicp.jetcache.redisson;

import com.alicp.jetcache.CacheConfigException;
import com.alicp.jetcache.CacheManager;
import com.alicp.jetcache.CacheResult;
import com.alicp.jetcache.support.BroadcastManager;
import com.alicp.jetcache.support.CacheMessage;
import com.alicp.jetcache.support.SquashedLogger;
import org.redisson.api.RedissonClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Objects;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created on 2022/7/12.
 *
 * @author <a href="mailto:jeason1914@qq.com">yangyong</a>
 */
public class RedissonBroadcastManager extends BroadcastManager {

    private static final Logger logger = LoggerFactory.getLogger(RedissonBroadcastManager.class);

    private final RedissonCacheConfig<?, ?> config;

    private final String channel;

    private final RedissonClient client;

    private volatile int subscribeId;

    private final ReentrantLock reentrantLock = new ReentrantLock();

    public RedissonBroadcastManager(final CacheManager cacheManager, final RedissonCacheConfig<?, ?> config) {
        super(cacheManager);
        checkConfig(config);
        this.config = config;
        this.channel = config.getBroadcastChannel();
        this.client = config.getRedissonClient();
    }

    @Override
    public void startSubscribe() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void close() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public CacheResult publish(final CacheMessage cacheMessage) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
