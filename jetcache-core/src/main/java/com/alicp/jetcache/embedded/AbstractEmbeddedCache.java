/**
 * Created on  13-10-17 23:01
 */
package com.alicp.jetcache.embedded;

import com.alicp.jetcache.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author huangli
 */
public abstract class AbstractEmbeddedCache<K, V> extends AbstractCache<K, V> {

    protected EmbeddedCacheConfig<K, V> config;

    protected InnerMap innerMap;

    protected abstract InnerMap createAreaCache();

    private final ReentrantLock lock = new ReentrantLock();

    public AbstractEmbeddedCache(EmbeddedCacheConfig<K, V> config) {
        this.config = config;
        innerMap = createAreaCache();
    }

    @Override
    public CacheConfig<K, V> config() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Object buildKey(K key) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected CacheGetResult<V> do_GET(K key) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected CacheGetResult<V> parseHolderResult(CacheValueHolder<V> holder) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected MultiGetResult<K, V> do_GET_ALL(Set<? extends K> keys) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected CacheResult do_PUT(K key, V value, long expireAfterWrite, TimeUnit timeUnit) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected CacheResult do_PUT_ALL(Map<? extends K, ? extends V> map, long expireAfterWrite, TimeUnit timeUnit) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected CacheResult do_REMOVE(K key) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected CacheResult do_REMOVE_ALL(Set<? extends K> keys) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // internal method
    public void __removeAll(Set<? extends K> keys) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected CacheResult do_PUT_IF_ABSENT(K key, V value, long expireAfterWrite, TimeUnit timeUnit) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
