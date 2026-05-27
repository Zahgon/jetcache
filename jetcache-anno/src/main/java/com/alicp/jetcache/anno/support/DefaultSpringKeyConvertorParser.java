/**
 * Created on 2019/6/7.
 */
package com.alicp.jetcache.anno.support;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import java.util.function.Function;

/**
 * @author huangli
 */
public class DefaultSpringKeyConvertorParser extends DefaultKeyConvertorParser implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public Function<Object, Object> parseKeyConvertor(String convertor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
