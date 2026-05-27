/**
 * Created on 2022/08/01.
 */
package com.alicp.jetcache.template;

import com.alicp.jetcache.Cache;
import com.alicp.jetcache.CacheBuilder;
import com.alicp.jetcache.CacheManager;
import com.alicp.jetcache.CacheMonitor;
import com.alicp.jetcache.CacheUtil;
import com.alicp.jetcache.MultiLevelCache;
import com.alicp.jetcache.external.ExternalCacheBuilder;
import com.alicp.jetcache.support.BroadcastManager;
import com.alicp.jetcache.support.CacheNotifyMonitor;
import java.util.function.Function;

/**
 * @author huangli
 */
public class NotifyMonitorInstaller implements CacheMonitorInstaller {

    private final Function<String, CacheBuilder> remoteBuilderTemplate;

    public NotifyMonitorInstaller(Function<String, CacheBuilder> remoteBuilderTemplate) {
        this.remoteBuilderTemplate = remoteBuilderTemplate;
    }

    @Override
    public void addMonitors(CacheManager cacheManager, Cache cache, QuickConfig quickConfig) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected CacheMonitor createMonitor(CacheManager cacheManager, QuickConfig quickConfig, String area) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
