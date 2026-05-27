/**
 * Created on 2019/2/1.
 */
package com.alicp.jetcache;

import com.alicp.jetcache.anno.CacheConsts;
import com.alicp.jetcache.support.BroadcastManager;
import com.alicp.jetcache.template.QuickConfig;

/**
 * @author huangli
 */
public interface CacheManager {

    <K, V> Cache<K, V> getCache(String area, String cacheName);

    void putCache(String area, String cacheName, Cache cache);

    BroadcastManager getBroadcastManager(String area);

    void putBroadcastManager(String area, BroadcastManager broadcastManager);

    default <K, V> Cache<K, V> getCache(String cacheName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    default void putCache(String cacheName, Cache cache) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * create or get Cache instance.
     * @see QuickConfig#newBuilder(String)
     */
    <K, V> Cache<K, V> getOrCreateCache(QuickConfig config);

    default void putBroadcastManager(BroadcastManager broadcastManager) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
