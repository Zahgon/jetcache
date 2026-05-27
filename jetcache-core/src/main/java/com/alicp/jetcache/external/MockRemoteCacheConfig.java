package com.alicp.jetcache.external;

import com.alicp.jetcache.anno.CacheConsts;

public class MockRemoteCacheConfig<K, V> extends ExternalCacheConfig<K, V> {

    private int limit = CacheConsts.DEFAULT_LOCAL_LIMIT;

    public int getLimit() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setLimit(int limit) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
