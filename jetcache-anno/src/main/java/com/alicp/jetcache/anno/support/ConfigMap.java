/**
 * Created on 2018/1/22.
 */
package com.alicp.jetcache.anno.support;

import com.alicp.jetcache.anno.CacheConsts;
import com.alicp.jetcache.anno.method.CacheInvokeConfig;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author huangli
 */
public class ConfigMap {

    private ConcurrentHashMap<String, CacheInvokeConfig> methodInfoMap = new ConcurrentHashMap<>();

    private ConcurrentHashMap<String, CachedAnnoConfig> cacheNameMap = new ConcurrentHashMap<>();

    public void putByMethodInfo(String key, CacheInvokeConfig config) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public CacheInvokeConfig getByMethodInfo(String key) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public CachedAnnoConfig getByCacheName(String area, String cacheName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
