package com.alicp.jetcache.autoconfigure;

import com.alicp.jetcache.CacheBuilder;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created on 2016/12/28.
 *
 * @author huangli
 */
public class AutoConfigureBeans {

    private Map<String, CacheBuilder> localCacheBuilders = new HashMap<>();

    private Map<String, CacheBuilder> remoteCacheBuilders = new HashMap<>();

    private Map<String, Object> customContainer = Collections.synchronizedMap(new HashMap<>());

    public Map<String, CacheBuilder> getLocalCacheBuilders() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setLocalCacheBuilders(Map<String, CacheBuilder> localCacheBuilders) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Map<String, CacheBuilder> getRemoteCacheBuilders() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setRemoteCacheBuilders(Map<String, CacheBuilder> remoteCacheBuilders) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Map<String, Object> getCustomContainer() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setCustomContainer(Map<String, Object> customContainer) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
