package com.alicp.jetcache.autoconfigure;

import com.alicp.jetcache.CacheManager;
import com.alicp.jetcache.SimpleCacheManager;
import com.alicp.jetcache.anno.support.EncoderParser;
import com.alicp.jetcache.anno.support.GlobalCacheConfig;
import com.alicp.jetcache.anno.support.JetCacheBaseBeans;
import com.alicp.jetcache.anno.support.KeyConvertorParser;
import com.alicp.jetcache.anno.support.SpringConfigProvider;
import com.alicp.jetcache.support.StatInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import java.util.function.Consumer;

/**
 * Created on 2016/11/17.
 *
 * @author huangli
 */
@Configuration
@ConditionalOnClass(GlobalCacheConfig.class)
@ConditionalOnMissingBean(GlobalCacheConfig.class)
@EnableConfigurationProperties(JetCacheProperties.class)
@Import({ RedisAutoConfiguration.class, CaffeineAutoConfiguration.class, MockRemoteCacheAutoConfiguration.class, LinkedHashMapAutoConfiguration.class, RedisLettuceAutoConfiguration.class, RedisSpringDataAutoConfiguration.class, RedissonAutoConfiguration.class })
public class JetCacheAutoConfiguration {

    public static final String GLOBAL_CACHE_CONFIG_NAME = "globalCacheConfig";

    @Bean(destroyMethod = "shutdown")
    @ConditionalOnMissingBean
    public SpringConfigProvider springConfigProvider(@Autowired ApplicationContext applicationContext, @Autowired GlobalCacheConfig globalCacheConfig, @Autowired(required = false) EncoderParser encoderParser, @Autowired(required = false) KeyConvertorParser keyConvertorParser, @Autowired(required = false) Consumer<StatInfo> metricsCallback) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Bean(name = "jcCacheManager", destroyMethod = "close")
    @ConditionalOnMissingBean
    public SimpleCacheManager cacheManager(@Autowired SpringConfigProvider springConfigProvider) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Bean
    @ConditionalOnMissingBean
    public AutoConfigureBeans autoConfigureBeans() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Bean
    public static BeanDependencyManager beanDependencyManager() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Bean(name = GLOBAL_CACHE_CONFIG_NAME)
    public GlobalCacheConfig globalCacheConfig(AutoConfigureBeans autoConfigureBeans, JetCacheProperties props) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
