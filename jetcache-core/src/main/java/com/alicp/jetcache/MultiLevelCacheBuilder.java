package com.alicp.jetcache;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

/**
 * Created on 2017/5/24.
 *
 * @author huangli
 */
public class MultiLevelCacheBuilder<T extends MultiLevelCacheBuilder<T>> extends AbstractCacheBuilder<T> {

    public static class MultiLevelCacheBuilderImpl extends MultiLevelCacheBuilder<MultiLevelCacheBuilderImpl> {
    }

    public static MultiLevelCacheBuilderImpl createMultiLevelCacheBuilder() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected MultiLevelCacheBuilder() {
        buildFunc(config -> new MultiLevelCache((MultiLevelCacheConfig) config));
    }

    @Override
    public MultiLevelCacheConfig getConfig() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public T addCache(Cache... caches) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setCaches(List<Cache> caches) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public T useExpireOfSubCache(boolean useExpireOfSubCache) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setUseExpireOfSubCache(boolean useExpireOfSubCache) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public T keyConvertor(Function<Object, Object> keyConvertor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void setKeyConvertor(Function<Object, Object> keyConvertor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public T expireAfterAccess(long defaultExpire, TimeUnit timeUnit) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void setExpireAfterAccessInMillis(long expireAfterAccessInMillis) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
