package com.alicp.jetcache.redis;

import com.alicp.jetcache.CacheConfigException;
import com.alicp.jetcache.CacheManager;
import com.alicp.jetcache.CacheResult;
import com.alicp.jetcache.support.BroadcastManager;
import com.alicp.jetcache.support.CacheMessage;
import com.alicp.jetcache.support.SquashedLogger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.BinaryJedisPubSub;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.UnifiedJedis;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created on 2022-05-03
 *
 * @author huangli
 */
public class RedisBroadcastManager extends BroadcastManager {

    private static final Logger logger = LoggerFactory.getLogger(RedisBroadcastManager.class);

    private final byte[] channel;

    private final String channelStr;

    private final RedisCacheConfig<Object, Object> config;

    private volatile CacheMessagePubSub cacheMessagePubSub;

    private volatile boolean closed;

    private volatile boolean subscribe;

    private boolean subscribeThreadStart;

    private final ReentrantLock reentrantLock = new ReentrantLock();

    public RedisBroadcastManager(CacheManager cacheManager, RedisCacheConfig<Object, Object> config) {
        super(cacheManager);
        this.channelStr = config.getBroadcastChannel();
        this.channel = channelStr.getBytes(StandardCharsets.UTF_8);
        this.config = config;
        checkConfig(config);
        if (config.getJedis() == null && config.getJedisPool() == null) {
            throw new CacheConfigException("no jedis");
        }
        if (config.getJedis() != null && config.getJedisPool() != null) {
            throw new CacheConfigException("'jedis' and 'jedisPool' can't set simultaneously");
        }
    }

    @Override
    public void startSubscribe() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private void runSubThread() {
        while (!closed) {
            runSubThread0();
        }
    }

    private void runSubThread0() {
        Object jedisObj = null;
        try {
            jedisObj = writeCommands();
            if (jedisObj instanceof Jedis) {
                subscribe = true;
                ((Jedis) jedisObj).subscribe(cacheMessagePubSub, channel);
            } else if (jedisObj instanceof UnifiedJedis) {
                subscribe = true;
                ((UnifiedJedis) jedisObj).subscribe(cacheMessagePubSub, channel);
            }
        } catch (Throwable e) {
            SquashedLogger.getLogger(logger).error("run jedis subscribe thread error: {}", e);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                // ignore
            }
        } finally {
            subscribe = false;
            RedisCache.closeJedis(jedisObj);
        }
    }

    Object writeCommands() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public CacheResult publish(CacheMessage message) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void close() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    class CacheMessagePubSub extends BinaryJedisPubSub {

        @Override
        public void onMessage(byte[] channel, byte[] message) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
