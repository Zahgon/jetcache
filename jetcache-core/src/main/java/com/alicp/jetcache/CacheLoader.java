package com.alicp.jetcache;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

/**
 * Created on 2017/5/27.
 *
 * @author huangli
 */
@FunctionalInterface
public interface CacheLoader<K, V> extends Function<K, V> {

    V load(K key) throws Throwable;

    default Map<K, V> loadAll(Set<K> keys) throws Throwable {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    default V apply(K key) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    default boolean vetoCacheUpdate() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
