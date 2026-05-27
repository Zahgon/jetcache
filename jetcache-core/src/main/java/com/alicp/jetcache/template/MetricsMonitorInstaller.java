/**
 * Created on 2022/08/01.
 */
package com.alicp.jetcache.template;

import com.alicp.jetcache.Cache;
import com.alicp.jetcache.CacheManager;
import com.alicp.jetcache.CacheUtil;
import com.alicp.jetcache.MultiLevelCache;
import com.alicp.jetcache.support.AbstractLifecycle;
import com.alicp.jetcache.support.DefaultCacheMonitor;
import com.alicp.jetcache.support.DefaultMetricsManager;
import com.alicp.jetcache.support.StatInfo;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

/**
 * @author huangli
 */
public class MetricsMonitorInstaller extends AbstractLifecycle implements CacheMonitorInstaller {

    private final Consumer<StatInfo> metricsCallback;

    private final Duration interval;

    private DefaultMetricsManager metricsManager;

    public MetricsMonitorInstaller(Consumer<StatInfo> metricsCallback, Duration interval) {
        this.metricsCallback = metricsCallback;
        this.interval = interval;
    }

    @Override
    protected void doInit() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected void doShutdown() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void addMonitors(CacheManager cacheManager, Cache cache, QuickConfig quickConfig) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
