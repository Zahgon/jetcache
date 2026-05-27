/**
 * Created on  13-09-09 17:29
 */
package com.alicp.jetcache.anno.support;

import com.alicp.jetcache.CacheBuilder;
import java.util.List;
import java.util.Map;

/**
 * @author huangli
 */
public class GlobalCacheConfig {

    private String[] hiddenPackages;

    protected int statIntervalMinutes;

    /**
     * for compatible reason. This property controls whether add area as remote cache key prefix.
     * version<=2.4.3: add cache area in prefix, no config.
     * version>2.4.3 and version <2.7: default value is true, keep same as 2.4.3 if not set.
     * version>=2.7.0.RC: default value is false.
     *
     * remove in the future.
     */
    @Deprecated
    private boolean areaInCacheName = false;

    private boolean penetrationProtect = false;

    private boolean enableMethodCache = true;

    private boolean useDefaultLocalExpireInMultiLevelCache = false;

    private boolean decodeFilterEnabled = true;

    private List<String> decodeFilterAllowPatterns;

    private List<String> decodeFilterDenyPatterns;

    private Map<String, CacheBuilder> localCacheBuilders;

    private Map<String, CacheBuilder> remoteCacheBuilders;

    public GlobalCacheConfig() {
    }

    public String[] getHiddenPackages() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setHiddenPackages(String[] hiddenPackages) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

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

    public int getStatIntervalMinutes() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setStatIntervalMinutes(int statIntervalMinutes) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * for compatible reason. This property controls whether add area as remote cache key prefix.
     * version<=2.4.3: add cache area in prefix, no config.
     * version>2.4.3 and version <2.7: default value is true, keep same as 2.4.3 if not set.
     * version>=2.7.0.RC: default value is false.
     *
     * remove in the future.
     */
    @Deprecated
    public boolean isAreaInCacheName() {
        return areaInCacheName;
    }

    /**
     * for compatible reason. This property controls whether add area as remote cache key prefix.
     * version<=2.4.3: add cache area in prefix, no config.
     * version>2.4.3 and version <2.7: default value is true, keep same as 2.4.3 if not set.
     * version>=2.7.0.RC: default value is false.
     *
     * remove in the future.
     */
    @Deprecated
    public void setAreaInCacheName(boolean areaInCacheName) {
        this.areaInCacheName = areaInCacheName;
    }

    public boolean isPenetrationProtect() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setPenetrationProtect(boolean penetrationProtect) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public boolean isEnableMethodCache() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setEnableMethodCache(boolean enableMethodCache) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public boolean isUseDefaultLocalExpireInMultiLevelCache() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setUseDefaultLocalExpireInMultiLevelCache(boolean useDefaultLocalExpireInMultiLevelCache) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public boolean isDecodeFilterEnabled() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setDecodeFilterEnabled(boolean decodeFilterEnabled) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public List<String> getDecodeFilterAllowPatterns() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setDecodeFilterAllowPatterns(List<String> decodeFilterAllowPatterns) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public List<String> getDecodeFilterDenyPatterns() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setDecodeFilterDenyPatterns(List<String> decodeFilterDenyPatterns) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
