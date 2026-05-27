package com.alicp.jetcache;

import com.alicp.jetcache.event.CacheEvent;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * Created on 2017/5/17.
 *
 * @author huangli
 */
public class LoadingCache<K, V> extends SimpleProxyCache<K, V> {

    protected Consumer<CacheEvent> eventConsumer;

    protected CacheConfig<K, V> config;

    public LoadingCache(Cache<K, V> cache) {
        super(cache);
        this.config = config();
        eventConsumer = CacheUtil.getAbstractCache(cache)::notify;
    }

    @Override
    public V get(K key) throws CacheInvokeException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected boolean needUpdate(V loadedValue, CacheLoader<K, V> loader) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Map<K, V> getAll(Set<? extends K> keys) throws CacheInvokeException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
