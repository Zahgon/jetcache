package com.alicp.jetcache.support;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * Created on 2016/10/31.
 *
 * @author huangli
 */
public class DefaultMetricsManager {

    private static final Logger logger = LoggerFactory.getLogger(DefaultMetricsManager.class);

    protected final CopyOnWriteArrayList<DefaultCacheMonitor> monitorList = new CopyOnWriteArrayList();

    private ScheduledFuture<?> future;

    private final int resetTime;

    private final TimeUnit resetTimeUnit;

    private final Consumer<StatInfo> metricsCallback;

    private final ReentrantLock reentrantLock = new ReentrantLock();

    public DefaultMetricsManager(int resetTime, TimeUnit resetTimeUnit, Consumer<StatInfo> metricsCallback) {
        this.resetTime = resetTime;
        this.resetTimeUnit = resetTimeUnit;
        this.metricsCallback = metricsCallback;
    }

    public DefaultMetricsManager(int resetTime, TimeUnit resetTimeUnit) {
        this(resetTime, resetTimeUnit, false);
    }

    public DefaultMetricsManager(int resetTime, TimeUnit resetTimeUnit, boolean verboseLog) {
        this.resetTime = resetTime;
        this.resetTimeUnit = resetTimeUnit;
        this.metricsCallback = new StatInfoLogger(verboseLog);
    }

    final Runnable cmd = new Runnable() {

        private long time = System.currentTimeMillis();

        @Override
        public void run() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    };

    public void start() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void stop() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void add(DefaultCacheMonitor... monitors) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void clear() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected static long firstDelay(int resetTime, TimeUnit resetTimeUnit) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected static LocalDateTime computeFirstResetTime(LocalDateTime baseTime, int time, TimeUnit unit) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
