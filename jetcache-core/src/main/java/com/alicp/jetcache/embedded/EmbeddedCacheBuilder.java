package com.alicp.jetcache.embedded;

import com.alicp.jetcache.AbstractCacheBuilder;

/**
 * Created on 16/9/7.
 *
 * @author huangli
 */
public class EmbeddedCacheBuilder<T extends EmbeddedCacheBuilder<T>> extends AbstractCacheBuilder<T> {

    public EmbeddedCacheBuilder() {
    }

    public static class EmbeddedCacheBuilderImpl extends EmbeddedCacheBuilder<EmbeddedCacheBuilderImpl> {
    }

    public static EmbeddedCacheBuilderImpl createEmbeddedCacheBuilder() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public EmbeddedCacheConfig getConfig() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public T limit(int limit) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setLimit(int limit) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
