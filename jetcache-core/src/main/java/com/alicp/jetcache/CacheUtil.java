package com.alicp.jetcache;

import com.alicp.jetcache.event.CacheEvent;
import com.alicp.jetcache.event.CacheLoadAllEvent;
import com.alicp.jetcache.event.CacheLoadEvent;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Created on 2017/5/22.
 *
 * @author huangli
 */
public class CacheUtil {

    private interface ProxyLoader<K, V> extends CacheLoader<K, V> {
    }

    public static <K, V> ProxyLoader<K, V> createProxyLoader(Cache<K, V> cache, CacheLoader<K, V> loader, Consumer<CacheEvent> eventConsumer) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static <K, V> ProxyLoader<K, V> createProxyLoader(Cache<K, V> cache, Function<K, V> loader, Consumer<CacheEvent> eventConsumer) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static <K, V> AbstractCache<K, V> getAbstractCache(Cache<K, V> c) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
