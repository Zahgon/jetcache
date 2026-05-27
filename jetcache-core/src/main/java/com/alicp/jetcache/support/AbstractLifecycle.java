/**
 * Created on 2019/6/8.
 */
package com.alicp.jetcache.support;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author huangli
 */
public class AbstractLifecycle {

    private boolean init;

    private boolean shutdown;

    final ReentrantLock reentrantLock = new ReentrantLock();

    public final void init() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected void doInit() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public final void shutdown() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected void doShutdown() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
