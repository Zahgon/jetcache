package com.alicp.jetcache.anno.support;

import com.alicp.jetcache.CacheManager;
import com.alicp.jetcache.anno.method.SpringCacheContext;
import com.alicp.jetcache.support.StatInfo;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import java.util.function.Consumer;

/**
 * Created on 2016/12/1.
 *
 * @author huangli
 */
public class SpringConfigProvider extends ConfigProvider implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    public SpringConfigProvider() {
        super();
        encoderParser = new DefaultSpringEncoderParser();
        keyConvertorParser = new DefaultSpringKeyConvertorParser();
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected void doInit() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public CacheContext newContext(CacheManager cacheManager) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Autowired(required = false)
    @Override
    public void setEncoderParser(EncoderParser encoderParser) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Autowired(required = false)
    @Override
    public void setKeyConvertorParser(KeyConvertorParser keyConvertorParser) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Autowired(required = false)
    @Override
    public void setMetricsCallback(Consumer<StatInfo> metricsCallback) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
