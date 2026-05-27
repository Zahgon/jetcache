/**
 * Created on 2019/6/7.
 */
package com.alicp.jetcache.anno.support;

import com.alicp.jetcache.CacheConfigException;
import com.alicp.jetcache.anno.SerialPolicy;
import com.alicp.jetcache.support.*;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * @author huangli
 */
public class DefaultSpringEncoderParser extends DefaultEncoderParser implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    static String parseBeanName(String str) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Function<Object, byte[]> parseEncoder(String valueEncoder) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Function<byte[], Object> parseDecoder(String valueDecoder) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    JavaValueDecoder javaValueDecoder(boolean useIdentityNumber) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
