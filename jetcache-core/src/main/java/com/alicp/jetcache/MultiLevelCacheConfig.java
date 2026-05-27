package com.alicp.jetcache;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 2017/5/24.
 *
 * @author huangli
 */
public class MultiLevelCacheConfig<K, V> extends CacheConfig<K, V> {

    private List<Cache<K, V>> caches = new ArrayList<>();

    private boolean useExpireOfSubCache;

    @Override
    public MultiLevelCacheConfig clone() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public List<Cache<K, V>> getCaches() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setCaches(List<Cache<K, V>> caches) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public boolean isUseExpireOfSubCache() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setUseExpireOfSubCache(boolean useExpireOfSubCache) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
