package com.alicp.jetcache.embedded;

import com.alicp.jetcache.support.JetCacheExecutor;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created on 2017/2/28.
 *
 * @author huangli
 */
class Cleaner {

    static ConcurrentLinkedQueue<WeakReference<LinkedHashMapCache>> linkedHashMapCaches = new ConcurrentLinkedQueue<>();

    static {
        ScheduledExecutorService executorService = JetCacheExecutor.defaultExecutor();
        executorService.scheduleWithFixedDelay(() -> run(), 60, 60, TimeUnit.SECONDS);
    }

    static void add(LinkedHashMapCache cache) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static void run() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
