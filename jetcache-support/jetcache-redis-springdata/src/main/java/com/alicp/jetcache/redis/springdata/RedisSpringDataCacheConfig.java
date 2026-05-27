package com.alicp.jetcache.redis.springdata;

import com.alicp.jetcache.external.ExternalCacheConfig;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;

/**
 * Created on 2019/4/4.
 *
 * @author huangli
 */
public class RedisSpringDataCacheConfig<K, V> extends ExternalCacheConfig<K, V> {

    private RedisConnectionFactory connectionFactory;

    /**
     * optional.
     */
    private RedisMessageListenerContainer listenerContainer;

    public RedisConnectionFactory getConnectionFactory() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setConnectionFactory(RedisConnectionFactory connectionFactory) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public RedisMessageListenerContainer getListenerContainer() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setListenerContainer(RedisMessageListenerContainer listenerContainer) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
