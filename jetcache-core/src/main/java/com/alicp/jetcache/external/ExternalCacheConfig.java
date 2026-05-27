package com.alicp.jetcache.external;

import com.alicp.jetcache.CacheConfig;
import com.alicp.jetcache.support.DecoderMap;
import com.alicp.jetcache.support.JavaValueEncoder;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Created on 16/9/9.
 *
 * @author huangli
 */
public class ExternalCacheConfig<K, V> extends CacheConfig<K, V> {

    private Supplier<String> keyPrefixSupplier;

    private Function<Object, byte[]> valueEncoder = JavaValueEncoder.INSTANCE;

    private Function<byte[], Object> valueDecoder = DecoderMap.defaultJavaValueDecoder();

    private String broadcastChannel;

    public String getKeyPrefix() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setKeyPrefix(String keyPrefix) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Supplier<String> getKeyPrefixSupplier() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setKeyPrefixSupplier(Supplier<String> keyPrefixSupplier) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Function<Object, byte[]> getValueEncoder() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setValueEncoder(Function<Object, byte[]> valueEncoder) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Function<byte[], Object> getValueDecoder() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setValueDecoder(Function<byte[], Object> valueDecoder) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public String getBroadcastChannel() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setBroadcastChannel(String broadcastChannel) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
