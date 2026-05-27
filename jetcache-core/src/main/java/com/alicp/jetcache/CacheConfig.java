package com.alicp.jetcache;

import com.alicp.jetcache.anno.CacheConsts;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * Created on 16/9/7.
 *
 * @author huangli
 */
public class CacheConfig<K, V> implements Cloneable {

    private long expireAfterWriteInMillis = CacheConsts.DEFAULT_EXPIRE * 1000L;

    private long expireAfterAccessInMillis = 0;

    private Function<K, Object> keyConvertor;

    private CacheLoader<K, V> loader;

    private List<CacheMonitor> monitors = new ArrayList<>();

    private boolean cacheNullValue = false;

    private RefreshPolicy refreshPolicy;

    private int tryLockUnlockCount = 2;

    private int tryLockInquiryCount = 1;

    private int tryLockLockCount = 2;

    private boolean cachePenetrationProtect = false;

    private Duration penetrationProtectTimeout = null;

    @Override
    public CacheConfig clone() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Function<K, Object> getKeyConvertor() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setKeyConvertor(Function<K, Object> keyConvertor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public boolean isExpireAfterAccess() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public boolean isExpireAfterWrite() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Deprecated
    public long getDefaultExpireInMillis() {
        return expireAfterWriteInMillis;
    }

    @Deprecated
    public void setDefaultExpireInMillis(long defaultExpireInMillis) {
        this.expireAfterWriteInMillis = defaultExpireInMillis;
    }

    public long getExpireAfterWriteInMillis() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setExpireAfterWriteInMillis(long expireAfterWriteInMillis) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public long getExpireAfterAccessInMillis() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setExpireAfterAccessInMillis(long expireAfterAccessInMillis) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public CacheLoader<K, V> getLoader() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setLoader(CacheLoader<K, V> loader) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public boolean isCacheNullValue() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setCacheNullValue(boolean cacheNullValue) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public List<CacheMonitor> getMonitors() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setMonitors(List<CacheMonitor> monitors) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public RefreshPolicy getRefreshPolicy() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setRefreshPolicy(RefreshPolicy refreshPolicy) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public int getTryLockUnlockCount() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setTryLockUnlockCount(int tryLockUnlockCount) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public int getTryLockInquiryCount() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setTryLockInquiryCount(int tryLockInquiryCount) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public int getTryLockLockCount() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setTryLockLockCount(int tryLockLockCount) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public boolean isCachePenetrationProtect() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setCachePenetrationProtect(boolean cachePenetrationProtect) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Duration getPenetrationProtectTimeout() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setPenetrationProtectTimeout(Duration penetrationProtectTimeout) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
