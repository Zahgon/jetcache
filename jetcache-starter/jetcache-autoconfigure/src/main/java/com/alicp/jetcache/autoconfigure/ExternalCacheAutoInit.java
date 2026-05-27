package com.alicp.jetcache.autoconfigure;

import com.alicp.jetcache.CacheBuilder;
import com.alicp.jetcache.anno.CacheConsts;
import com.alicp.jetcache.anno.support.ParserFunction;
import com.alicp.jetcache.external.ExternalCacheBuilder;

/**
 * Created on 2016/11/29.
 *
 * @author huangli
 */
public abstract class ExternalCacheAutoInit extends AbstractCacheAutoInit {

    public ExternalCacheAutoInit(String... cacheTypes) {
        super(cacheTypes);
    }

    @Override
    protected void parseGeneralConfig(CacheBuilder builder, ConfigTree ct) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected String parseBroadcastChannel(ConfigTree ct) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
