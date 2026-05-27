/**
 * Created on 2022/7/6.
 */
package com.alicp.jetcache.support;

import org.slf4j.Logger;
import java.time.Duration;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author huangli
 */
public class SquashedLogger {

    private static final int DEFAULT_INTERVAL_SECONDS = 10;

    private static final ConcurrentHashMap<Logger, SquashedLogger> MAP = new ConcurrentHashMap<>();

    private final Logger logger;

    private final long interval;

    private final AtomicLong lastLogTime;

    private SquashedLogger(Logger logger, int intervalSeconds) {
        this.logger = logger;
        this.interval = Duration.ofSeconds(intervalSeconds).toNanos();
        this.lastLogTime = new AtomicLong(System.nanoTime() - interval);
    }

    public static SquashedLogger getLogger(Logger target, int intervalSeconds) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static SquashedLogger getLogger(Logger target) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private boolean shouldLogEx() {
        long now = System.nanoTime();
        long last = lastLogTime.get();
        if (Math.abs(now - last) >= interval) {
            return lastLogTime.compareAndSet(last, now);
        } else {
            return false;
        }
    }

    public void error(CharSequence msg, Throwable e) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
