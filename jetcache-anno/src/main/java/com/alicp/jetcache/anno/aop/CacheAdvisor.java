/**
 * Created on  13-09-19 20:40
 */
package com.alicp.jetcache.anno.aop;

import com.alicp.jetcache.anno.support.ConfigMap;
import org.springframework.aop.Pointcut;
import org.springframework.aop.support.AbstractBeanFactoryPointcutAdvisor;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author huangli
 */
public class CacheAdvisor extends AbstractBeanFactoryPointcutAdvisor {

    public static final String CACHE_ADVISOR_BEAN_NAME = "jetcache2.internalCacheAdvisor";

    @Autowired
    private ConfigMap cacheConfigMap;

    private String[] basePackages;

    @Override
    public Pointcut getPointcut() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setCacheConfigMap(ConfigMap cacheConfigMap) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setBasePackages(String[] basePackages) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
