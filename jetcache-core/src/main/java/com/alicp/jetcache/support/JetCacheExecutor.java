package com.alicp.jetcache.support;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created on 2017/5/3.
 *
 * @author huangli
 */
public class JetCacheExecutor {

    protected volatile static ScheduledExecutorService defaultExecutor;

    protected volatile static ScheduledExecutorService heavyIOExecutor;

    private static final ReentrantLock reentrantLock = new ReentrantLock();

    private static final AtomicInteger threadCount = new AtomicInteger(0);

    static {
        Runtime.getRuntime().addShutdownHook(new Thread() {

            @Override
            public void run() {
                throw new UnsupportedOperationException("STUB: not implemented");
            }
        });
    }

    public static ScheduledExecutorService defaultExecutor() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static ScheduledExecutorService heavyIOExecutor() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static void setDefaultExecutor(ScheduledExecutorService executor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static void setHeavyIOExecutor(ScheduledExecutorService heavyIOExecutor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
