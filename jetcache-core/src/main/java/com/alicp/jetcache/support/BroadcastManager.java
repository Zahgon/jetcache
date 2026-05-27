/**
 * Created on 2019/6/10.
 */
package com.alicp.jetcache.support;

import com.alicp.jetcache.Cache;
import com.alicp.jetcache.CacheManager;
import com.alicp.jetcache.CacheResult;
import com.alicp.jetcache.CacheUtil;
import com.alicp.jetcache.MultiLevelCache;
import com.alicp.jetcache.embedded.AbstractEmbeddedCache;
import com.alicp.jetcache.external.ExternalCacheConfig;
import com.alicp.jetcache.CacheConfigException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Set;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author huangli
 */
public abstract class BroadcastManager implements AutoCloseable {

    private static Logger logger = LoggerFactory.getLogger(BroadcastManager.class);

    private final String sourceId = UUID.randomUUID().toString();

    private final CacheManager cacheManager;

    public BroadcastManager(CacheManager cacheManager) {
        this.cacheManager = cacheManager;
    }

    protected void checkConfig(ExternalCacheConfig config) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public abstract CacheResult publish(CacheMessage cacheMessage);

    public abstract void startSubscribe();

    @Override
    public void close() throws Exception {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public String getSourceId() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public CacheManager getCacheManager() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected void processNotification(byte[] message, Function<byte[], Object> decoder) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private void processCacheMessage(CacheMessage cacheMessage) {
        if (sourceId.equals(cacheMessage.getSourceId())) {
            return;
        }
        Cache cache = cacheManager.getCache(cacheMessage.getArea(), cacheMessage.getCacheName());
        if (cache == null) {
            logger.warn("Cache instance not exists: {},{}", cacheMessage.getArea(), cacheMessage.getCacheName());
            return;
        }
        Cache absCache = CacheUtil.getAbstractCache(cache);
        if (!(absCache instanceof MultiLevelCache)) {
            logger.warn("Cache instance is not MultiLevelCache: {},{}", cacheMessage.getArea(), cacheMessage.getCacheName());
            return;
        }
        Cache[] caches = ((MultiLevelCache) absCache).caches();
        Set<Object> keys = Stream.of(cacheMessage.getKeys()).collect(Collectors.toSet());
        for (Cache c : caches) {
            Cache localCache = CacheUtil.getAbstractCache(c);
            if (localCache instanceof AbstractEmbeddedCache) {
                ((AbstractEmbeddedCache) localCache).__removeAll(keys);
            } else {
                break;
            }
        }
    }
}
