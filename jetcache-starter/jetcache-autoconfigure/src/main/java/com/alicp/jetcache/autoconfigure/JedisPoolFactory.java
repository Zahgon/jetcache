package com.alicp.jetcache.autoconfigure;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.util.Pool;

/**
 * Created on 2016/12/28.
 *
 * @author huangli
 */
public class JedisPoolFactory implements FactoryBean<Pool<Jedis>> {

    private String key;

    private Class<?> poolClass;

    @Autowired
    private AutoConfigureBeans autoConfigureBeans;

    private boolean inited;

    private Pool<Jedis> jedisPool;

    public JedisPoolFactory(String key, Class<? extends Pool<Jedis>> poolClass) {
        this.key = key;
        this.poolClass = poolClass;
    }

    public String getKey() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Pool<Jedis> getObject() throws Exception {
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
