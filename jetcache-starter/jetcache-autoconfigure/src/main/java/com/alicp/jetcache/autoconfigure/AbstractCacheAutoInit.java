package com.alicp.jetcache.autoconfigure;

import com.alicp.jetcache.AbstractCacheBuilder;
import com.alicp.jetcache.CacheBuilder;
import com.alicp.jetcache.anno.KeyConvertor;
import com.alicp.jetcache.anno.support.ParserFunction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.util.Assert;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created on 2016/11/29.
 *
 * @author huangli
 */
public abstract class AbstractCacheAutoInit implements InitializingBean {

    private static Logger logger = LoggerFactory.getLogger(AbstractCacheAutoInit.class);

    @Autowired
    protected ConfigurableEnvironment environment;

    @Autowired
    protected AutoConfigureBeans autoConfigureBeans;

    private final ReentrantLock reentrantLock = new ReentrantLock();

    protected String[] typeNames;

    private volatile boolean inited = false;

    public AbstractCacheAutoInit(String... cacheTypes) {
        Objects.requireNonNull(cacheTypes, "cacheTypes can't be null");
        Assert.isTrue(cacheTypes.length > 0, "cacheTypes length is 0");
        this.typeNames = cacheTypes;
    }

    @Override
    public void afterPropertiesSet() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private void process(String prefix, Map cacheBuilders, boolean local) {
        ConfigTree resolver = new ConfigTree(environment, prefix);
        Map<String, Object> m = resolver.getProperties();
        Set<String> cacheAreaNames = resolver.directChildrenKeys();
        for (String cacheArea : cacheAreaNames) {
            final Object configType = m.get(cacheArea + ".type");
            boolean match = Arrays.stream(typeNames).anyMatch((tn) -> tn.equals(configType));
            if (!match) {
                continue;
            }
            ConfigTree ct = resolver.subTree(cacheArea + ".");
            logger.info("init cache area {} , type= {}", cacheArea, typeNames[0]);
            CacheBuilder c = initCache(ct, local ? "local." + cacheArea : "remote." + cacheArea);
            cacheBuilders.put(cacheArea, c);
        }
    }

    protected void parseGeneralConfig(CacheBuilder builder, ConfigTree ct) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected abstract CacheBuilder initCache(ConfigTree ct, String cacheAreaWithPrefix);
}
