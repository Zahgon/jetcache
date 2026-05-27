package com.alicp.jetcache.autoconfigure;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.UnifiedJedis;

/**
 * Created on 2016/12/28.
 *
 * @author huangli
 */
public class JedisFactory implements FactoryBean<UnifiedJedis> {

    private String key;

    private Class<?> poolClass;

    @Autowired
    private AutoConfigureBeans autoConfigureBeans;

    private boolean inited;

    private UnifiedJedis unifiedJedis;

    public JedisFactory(String key, Class<? extends UnifiedJedis> poolClass) {
        this.key = key;
        this.poolClass = poolClass;
    }

    public String getKey() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public UnifiedJedis getObject() throws Exception {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Class<?> getObjectType() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean isSingleton() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
