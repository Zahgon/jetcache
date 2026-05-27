package com.alicp.jetcache.embedded;

/**
 * Created on 2016/11/29.
 *
 * @author huangli
 */
public class CaffeineCacheBuilder<T extends EmbeddedCacheBuilder<T>> extends EmbeddedCacheBuilder<T> {

    public static class CaffeineCacheBuilderImpl extends CaffeineCacheBuilder<CaffeineCacheBuilderImpl> {
    }

    public static CaffeineCacheBuilderImpl createCaffeineCacheBuilder() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected CaffeineCacheBuilder() {
        buildFunc((c) -> new CaffeineCache((EmbeddedCacheConfig) c));
    }
}
