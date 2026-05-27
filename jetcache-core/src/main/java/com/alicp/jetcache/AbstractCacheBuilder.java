package com.alicp.jetcache;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

/**
 * Created on 16/9/7.
 *
 * @author huangli
 */
public abstract class AbstractCacheBuilder<T extends AbstractCacheBuilder<T>> implements CacheBuilder, Cloneable {

    protected CacheConfig config;

    private Function<CacheConfig, Cache> buildFunc;

    public abstract CacheConfig getConfig();

    protected T self() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public T buildFunc(Function<CacheConfig, Cache> buildFunc) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected void beforeBuild() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Deprecated
    public final <K, V> Cache<K, V> build() {
        return buildCache();
    }

    @Override
    public final <K, V> Cache<K, V> buildCache() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Object clone() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public T keyConvertor(Function<Object, Object> keyConvertor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setKeyConvertor(Function<Object, Object> keyConvertor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public T expireAfterAccess(long defaultExpire, TimeUnit timeUnit) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setExpireAfterAccessInMillis(long expireAfterAccessInMillis) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public T expireAfterWrite(long defaultExpire, TimeUnit timeUnit) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setExpireAfterWriteInMillis(long expireAfterWriteInMillis) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public T addMonitor(CacheMonitor monitor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setMonitors(List<CacheMonitor> monitors) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public T cacheNullValue(boolean cacheNullValue) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setCacheNullValue(boolean cacheNullValue) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public <K, V> T loader(CacheLoader<K, V> loader) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public <K, V> void setLoader(CacheLoader<K, V> loader) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public T refreshPolicy(RefreshPolicy refreshPolicy) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setRefreshPolicy(RefreshPolicy refreshPolicy) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public T cachePenetrateProtect(boolean cachePenetrateProtect) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setCachePenetrateProtect(boolean cachePenetrateProtect) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
