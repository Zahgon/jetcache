package com.alicp.jetcache.external;

import com.alicp.jetcache.AbstractCacheBuilder;
import com.alicp.jetcache.CacheManager;
import com.alicp.jetcache.support.BroadcastManager;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Created on 16/9/9.
 *
 * @author huangli
 */
public abstract class ExternalCacheBuilder<T extends ExternalCacheBuilder<T>> extends AbstractCacheBuilder<T> {

    @Override
    public ExternalCacheConfig getConfig() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public boolean supportBroadcast() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public BroadcastManager createBroadcastManager(CacheManager cacheManager) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public T broadcastChannel(String broadcastChannel) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setBroadcastChannel(String broadcastChannel) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public T keyPrefix(String keyPrefix) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public T keyPrefixSupplier(Supplier<String> keyPrefixSupplier) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public T valueEncoder(Function<Object, byte[]> valueEncoder) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public T valueDecoder(Function<byte[], Object> valueDecoder) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setKeyPrefix(String keyPrefix) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setKeyPrefixSupplier(Supplier<String> keyPrefixSupplier) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setValueEncoder(Function<Object, byte[]> valueEncoder) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setValueDecoder(Function<byte[], Object> valueDecoder) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
