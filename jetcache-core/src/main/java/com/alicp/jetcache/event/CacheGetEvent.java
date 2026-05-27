package com.alicp.jetcache.event;

import com.alicp.jetcache.Cache;
import com.alicp.jetcache.CacheGetResult;

/**
 * Created on 2017/2/22.
 *
 * @author huangli
 */
public class CacheGetEvent extends CacheEvent {

    private long millis;

    private Object key;

    private CacheGetResult result;

    public CacheGetEvent(Cache cache, long millis, Object key, CacheGetResult result) {
        super(cache);
        this.millis = millis;
        this.key = key;
        this.result = result;
    }

    public long getMillis() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Object getKey() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public CacheGetResult getResult() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
