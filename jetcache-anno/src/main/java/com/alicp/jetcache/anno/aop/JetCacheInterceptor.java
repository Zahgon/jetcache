/**
 * Created on  13-09-18 20:33
 */
package com.alicp.jetcache.anno.aop;

import com.alicp.jetcache.CacheManager;
import com.alicp.jetcache.anno.method.CacheHandler;
import com.alicp.jetcache.anno.method.CacheInvokeConfig;
import com.alicp.jetcache.anno.method.CacheInvokeContext;
import com.alicp.jetcache.anno.support.ConfigMap;
import com.alicp.jetcache.anno.support.ConfigProvider;
import com.alicp.jetcache.anno.support.GlobalCacheConfig;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import java.lang.reflect.Method;

/**
 * @author huangli
 */
public class JetCacheInterceptor implements MethodInterceptor, ApplicationContextAware {

    private static final Logger logger = LoggerFactory.getLogger(JetCacheInterceptor.class);

    @Autowired
    private ConfigMap cacheConfigMap;

    private ApplicationContext applicationContext;

    private GlobalCacheConfig globalCacheConfig;

    ConfigProvider configProvider;

    CacheManager cacheManager;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Object invoke(final MethodInvocation invocation) throws Throwable {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setCacheConfigMap(ConfigMap cacheConfigMap) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
