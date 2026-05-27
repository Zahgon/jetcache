package com.alicp.jetcache.event;

import com.alicp.jetcache.Cache;
import com.alicp.jetcache.CacheResult;

/**
 * Created on 2017/2/22.
 *
 * @author huangli
 */
public class CachePutEvent extends CacheEvent {

    private long millis;

    private Object key;

    private Object value;

    private CacheResult result;

    public CachePutEvent(Cache cache, long millis, Object key, Object value, CacheResult result) {
        super(cache);
        this.millis = millis;
        this.key = key;
        this.value = value;
        this.result = result;
    }

    public long getMillis() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Object getKey() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public CacheResult getResult() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Object getValue() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
