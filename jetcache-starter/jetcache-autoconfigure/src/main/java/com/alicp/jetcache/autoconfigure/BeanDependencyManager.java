package com.alicp.jetcache.autoconfigure;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import java.util.Arrays;

/**
 * Created on 2017/5/5.
 *
 * @author huangli
 */
public class BeanDependencyManager implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
