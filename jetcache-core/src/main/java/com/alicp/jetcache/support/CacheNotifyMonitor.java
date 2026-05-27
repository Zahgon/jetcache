/**
 * Created on 2022-05-04.
 */
package com.alicp.jetcache.support;

import com.alicp.jetcache.AbstractCache;
import com.alicp.jetcache.Cache;
import com.alicp.jetcache.CacheManager;
import com.alicp.jetcache.CacheMonitor;
import com.alicp.jetcache.CacheUtil;
import com.alicp.jetcache.MultiLevelCache;
import com.alicp.jetcache.anno.CacheConsts;
import com.alicp.jetcache.embedded.AbstractEmbeddedCache;
import com.alicp.jetcache.event.CacheEvent;
import com.alicp.jetcache.event.CachePutAllEvent;
import com.alicp.jetcache.event.CachePutEvent;
import com.alicp.jetcache.event.CacheRemoveAllEvent;
import com.alicp.jetcache.event.CacheRemoveEvent;
import java.util.function.Function;

/**
 * @author huangli
 */
public class CacheNotifyMonitor implements CacheMonitor {

    private final BroadcastManager broadcastManager;

    private final String area;

    private final String cacheName;

    private final String sourceId;

    public CacheNotifyMonitor(CacheManager cacheManager, String area, String cacheName) {
        this.broadcastManager = cacheManager.getBroadcastManager(area);
        this.area = area;
        this.cacheName = cacheName;
        if (broadcastManager != null) {
            this.sourceId = broadcastManager.getSourceId();
        } else {
            this.sourceId = null;
        }
    }

    public CacheNotifyMonitor(CacheManager cacheManager, String cacheName) {
        this(cacheManager, CacheConsts.DEFAULT_AREA, cacheName);
    }

    private Object convertKey(Object key, AbstractEmbeddedCache localCache) {
        Function keyConvertor = localCache.config().getKeyConvertor();
        if (keyConvertor == null) {
            return key;
        } else {
            return keyConvertor.apply(key);
        }
    }

    private AbstractEmbeddedCache getLocalCache(AbstractCache absCache) {
        if (!(absCache instanceof MultiLevelCache)) {
            return null;
        }
        for (Cache c : ((MultiLevelCache) absCache).caches()) {
            if (c instanceof AbstractEmbeddedCache) {
                return (AbstractEmbeddedCache) c;
            }
        }
        return null;
    }

    @Override
    public void afterOperation(CacheEvent event) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
