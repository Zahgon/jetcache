package com.alicp.jetcache.external;

import com.alicp.jetcache.CacheManager;
import com.alicp.jetcache.CacheResult;
import com.alicp.jetcache.support.BroadcastManager;
import com.alicp.jetcache.support.CacheMessage;

/**
 * Created on 2016/10/20.
 *
 * @author huangli
 */
public class MockRemoteCacheBuilder<T extends ExternalCacheBuilder<T>> extends ExternalCacheBuilder<T> {

    private static volatile boolean subscribeStart;

    private static volatile CacheMessage lastPublishMessage;

    public static class MockRemoteCacheBuilderImpl extends MockRemoteCacheBuilder<MockRemoteCacheBuilderImpl> {
    }

    public static MockRemoteCacheBuilderImpl createMockRemoteCacheBuilder() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public MockRemoteCacheConfig getConfig() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean supportBroadcast() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public BroadcastManager createBroadcastManager(CacheManager cacheManager) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public MockRemoteCacheBuilder() {
        this.setKeyPrefix("DEFAULT_PREFIX");
        buildFunc((c) -> new MockRemoteCache((MockRemoteCacheConfig) c));
    }

    public T limit(int limit) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setLimit(int limit) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static boolean isSubscribeStart() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static CacheMessage getLastPublishMessage() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static void reset() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
