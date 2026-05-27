package com.alicp.jetcache;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

/**
 * Created on 2017/5/17.
 *
 * @author huangli
 */
public class SimpleProxyCache<K, V> implements ProxyCache<K, V> {

    protected Cache<K, V> cache;

    public SimpleProxyCache(Cache<K, V> cache) {
        this.cache = cache;
    }

    @Override
    public CacheConfig<K, V> config() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Cache<K, V> getTargetCache() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public V get(K key) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Map<K, V> getAll(Set<? extends K> keys) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void put(K key, V value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> map) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean putIfAbsent(K key, V value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean remove(K key) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void removeAll(Set<? extends K> keys) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <T> T unwrap(Class<T> clazz) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public AutoReleaseLock tryLock(K key, long expire, TimeUnit timeUnit) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean tryLockAndRun(K key, long expire, TimeUnit timeUnit, Runnable action) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public CacheGetResult<V> GET(K key) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public MultiGetResult<K, V> GET_ALL(Set<? extends K> keys) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public V computeIfAbsent(K key, Function<K, V> loader) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public V computeIfAbsent(K key, Function<K, V> loader, boolean cacheNullWhenLoaderReturnNull) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public V computeIfAbsent(K key, Function<K, V> loader, boolean cacheNullWhenLoaderReturnNull, long expireAfterWrite, TimeUnit timeUnit) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void put(K key, V value, long expireAfterWrite, TimeUnit timeUnit) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public CacheResult PUT(K key, V value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public CacheResult PUT(K key, V value, long expireAfterWrite, TimeUnit timeUnit) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> map, long expireAfterWrite, TimeUnit timeUnit) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public CacheResult PUT_ALL(Map<? extends K, ? extends V> map) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public CacheResult PUT_ALL(Map<? extends K, ? extends V> map, long expireAfterWrite, TimeUnit timeUnit) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public CacheResult REMOVE(K key) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public CacheResult REMOVE_ALL(Set<? extends K> keys) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public CacheResult PUT_IF_ABSENT(K key, V value, long expireAfterWrite, TimeUnit timeUnit) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void close() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
