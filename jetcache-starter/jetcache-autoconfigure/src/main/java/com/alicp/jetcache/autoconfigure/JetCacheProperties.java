package com.alicp.jetcache.autoconfigure;

import org.springframework.boot.context.properties.ConfigurationProperties;
import java.util.List;

/**
 * Created on 2016/11/23.
 *
 * @author huangli
 */
@ConfigurationProperties(prefix = "jetcache")
public class JetCacheProperties {

    private String[] hiddenPackages;

    private int statIntervalMinutes;

    private boolean areaInCacheName = false;

    private boolean penetrationProtect = false;

    private boolean enableMethodCache = true;

    private boolean useDefaultLocalExpireInMultiLevelCache = false;

    private boolean decodeFilterEnabled = true;

    private List<String> decodeFilterAllowPatterns;

    private List<String> decodeFilterDenyPatterns;

    public JetCacheProperties() {
    }

    public String[] getHiddenPackages() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setHiddenPackages(String[] hiddenPackages) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setHidePackages(String[] hidePackages) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public int getStatIntervalMinutes() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setStatIntervalMinutes(int statIntervalMinutes) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public boolean isAreaInCacheName() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setAreaInCacheName(boolean areaInCacheName) {
        throw new UnsupportedOperationException("STUB: not implemented");
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
