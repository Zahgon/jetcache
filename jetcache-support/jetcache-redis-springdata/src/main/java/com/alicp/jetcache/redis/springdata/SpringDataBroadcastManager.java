/**
 * Created on 2022/07/15.
 */
package com.alicp.jetcache.redis.springdata;

import com.alicp.jetcache.CacheConfigException;
import com.alicp.jetcache.CacheManager;
import com.alicp.jetcache.CacheResult;
import com.alicp.jetcache.support.BroadcastManager;
import com.alicp.jetcache.support.CacheMessage;
import com.alicp.jetcache.support.SquashedLogger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.Topic;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author huangli
 */
public class SpringDataBroadcastManager extends BroadcastManager {

    private static final Logger logger = LoggerFactory.getLogger(SpringDataBroadcastManager.class);

    private final RedisSpringDataCacheConfig config;

    private final MessageListener listener = this::onMessage;

    private final byte[] channel;

    private volatile RedisMessageListenerContainer listenerContainer;

    private final ReentrantLock reentrantLock = new ReentrantLock();

    public SpringDataBroadcastManager(CacheManager cacheManager, RedisSpringDataCacheConfig config) {
        super(cacheManager);
        this.config = config;
        checkConfig(config);
        if (config.getConnectionFactory() == null) {
            throw new CacheConfigException("connectionFactory is required");
        }
        this.channel = config.getBroadcastChannel().getBytes(StandardCharsets.UTF_8);
    }

    @Override
    public CacheResult publish(CacheMessage cacheMessage) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void startSubscribe() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private void onMessage(Message message, byte[] pattern) {
        processNotification(message.getBody(), config.getValueDecoder());
    }

    @Override
    public void close() throws Exception {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
