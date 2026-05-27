/**
 * Created on  13-09-21 23:04
 */
package com.alicp.jetcache.anno.method;

import com.alicp.jetcache.anno.support.CacheInvalidateAnnoConfig;
import com.alicp.jetcache.anno.support.CacheUpdateAnnoConfig;
import com.alicp.jetcache.anno.support.CachedAnnoConfig;
import java.util.List;

/**
 * @author huangli
 */
public class CacheInvokeConfig {

    private CachedAnnoConfig cachedAnnoConfig;

    private List<CacheInvalidateAnnoConfig> invalidateAnnoConfigs;

    private CacheUpdateAnnoConfig updateAnnoConfig;

    private boolean enableCacheContext;

    private static final CacheInvokeConfig noCacheInvokeConfigInstance = new CacheInvokeConfig();

    public static CacheInvokeConfig getNoCacheInvokeConfigInstance() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public CachedAnnoConfig getCachedAnnoConfig() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setCachedAnnoConfig(CachedAnnoConfig cachedAnnoConfig) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public boolean isEnableCacheContext() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setEnableCacheContext(boolean enableCacheContext) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public List<CacheInvalidateAnnoConfig> getInvalidateAnnoConfigs() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setInvalidateAnnoConfigs(List<CacheInvalidateAnnoConfig> invalidateAnnoConfigs) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public CacheUpdateAnnoConfig getUpdateAnnoConfig() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setUpdateAnnoConfig(CacheUpdateAnnoConfig updateAnnoConfig) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
