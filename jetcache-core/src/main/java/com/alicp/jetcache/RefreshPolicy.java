package com.alicp.jetcache;

import java.util.concurrent.TimeUnit;

/**
 * Created on 2017/5/25.
 *
 * @author huangli
 */
public class RefreshPolicy implements Cloneable {

    private long refreshMillis;

    private long stopRefreshAfterLastAccessMillis;

    private long refreshLockTimeoutMillis = 60 * 1000;

    public RefreshPolicy() {
    }

    public static RefreshPolicy newPolicy(long time, TimeUnit timeUnit) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public RefreshPolicy stopRefreshAfterLastAccess(long time, TimeUnit timeUnit) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public RefreshPolicy refreshLockTimeout(long time, TimeUnit timeUnit) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public RefreshPolicy clone() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public long getRefreshMillis() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setRefreshMillis(long refreshMillis) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public long getStopRefreshAfterLastAccessMillis() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setStopRefreshAfterLastAccessMillis(long stopRefreshAfterLastAccessMillis) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public long getRefreshLockTimeoutMillis() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setRefreshLockTimeoutMillis(long refreshLockTimeoutMillis) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
