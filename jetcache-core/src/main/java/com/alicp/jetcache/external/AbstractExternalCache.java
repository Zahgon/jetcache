package com.alicp.jetcache.external;

import com.alicp.jetcache.AbstractCache;
import com.alicp.jetcache.CacheConfigException;
import com.alicp.jetcache.CacheException;
import com.alicp.jetcache.RefreshCache;
import com.alicp.jetcache.anno.KeyConvertor;
import java.io.IOException;

/**
 * Created on 2016/10/8.
 *
 * @author huangli
 */
public abstract class AbstractExternalCache<K, V> extends AbstractCache<K, V> {

    private ExternalCacheConfig<K, V> config;

    public AbstractExternalCache(ExternalCacheConfig<K, V> config) {
        this.config = config;
        checkConfig();
    }

    protected void checkConfig() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public byte[] buildKey(K key) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private boolean isPreservedKey(Object key) {
        if (key instanceof byte[]) {
            byte[] keyBytes = (byte[]) key;
            return endWith(keyBytes, RefreshCache.LOCK_KEY_SUFFIX) || endWith(keyBytes, RefreshCache.TIMESTAMP_KEY_SUFFIX);
        }
        return false;
    }

    private boolean endWith(byte[] key, byte[] suffix) {
        int len = suffix.length;
        if (key.length < len) {
            return false;
        }
        int startPos = key.length - len;
        for (int i = 0; i < len; i++) {
            if (key[startPos + i] != suffix[i]) {
                return false;
            }
        }
        return true;
    }
}
