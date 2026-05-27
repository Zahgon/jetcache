package com.alicp.jetcache;

import java.io.Serializable;

/**
 * Created on 16/9/13.
 * This class is not thread safe.
 * @author huangli
 */
public final class CacheValueHolder<V> implements Serializable {

    private static final long serialVersionUID = -7973743507831565203L;

    private V value;

    private long expireTime;

    private long accessTime;

    /**
     * used by kyro
     */
    public CacheValueHolder() {
    }

    public CacheValueHolder(V value, long expireAfterWrite) {
        this.value = value;
        this.accessTime = System.currentTimeMillis();
        this.expireTime = accessTime + expireAfterWrite;
    }

    public V getValue() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setValue(V value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public long getExpireTime() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setExpireTime(long expireTime) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public long getAccessTime() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setAccessTime(long accessTime) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
