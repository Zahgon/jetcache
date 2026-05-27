package com.alicp.jetcache.support;

import com.alicp.jetcache.CacheException;
import java.io.Serializable;

/**
 * Created on 2016/10/27.
 *
 * @author huangli
 */
public class CacheStat implements Serializable, Cloneable {

    private static final long serialVersionUID = -8802969946750554026L;

    protected String cacheName;

    protected long statStartTime;

    protected long statEndTime;

    protected long getCount;

    protected long getHitCount;

    protected long getMissCount;

    protected long getFailCount;

    protected long getExpireCount;

    protected long getTimeSum;

    protected long minGetTime = Long.MAX_VALUE;

    protected long maxGetTime = 0;

    protected long putCount;

    protected long putSuccessCount;

    protected long putFailCount;

    protected long putTimeSum;

    protected long minPutTime = Long.MAX_VALUE;

    protected long maxPutTime = 0;

    protected long removeCount;

    protected long removeSuccessCount;

    protected long removeFailCount;

    protected long removeTimeSum;

    protected long minRemoveTime = Long.MAX_VALUE;

    protected long maxRemoveTime = 0;

    protected long loadCount;

    protected long loadSuccessCount;

    protected long loadFailCount;

    protected long loadTimeSum;

    protected long minLoadTime = Long.MAX_VALUE;

    protected long maxLoadTime = 0;

    @Override
    public CacheStat clone() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private double tps(long count) {
        long t = statEndTime;
        if (t == 0) {
            t = System.currentTimeMillis();
        }
        t = t - statStartTime;
        if (t == 0) {
            return 0;
        } else {
            return 1000.0 * count / t;
        }
    }

    public double qps() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public double putTps() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public double removeTps() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public double loadQps() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public double hitRate() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public double avgGetTime() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public double avgPutTime() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public double avgRemoveTime() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public double avgLoadTime() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    //---------------------------------------------------------------------
    public long getGetCount() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setGetCount(long getCount) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public long getGetHitCount() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setGetHitCount(long getHitCount) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public long getGetMissCount() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setGetMissCount(long getMissCount) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public long getGetFailCount() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setGetFailCount(long getFailCount) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public long getGetExpireCount() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setGetExpireCount(long getExpireCount) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public long getGetTimeSum() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setGetTimeSum(long getTimeSum) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public long getMinGetTime() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setMinGetTime(long minGetTime) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public long getMaxGetTime() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setMaxGetTime(long maxGetTime) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public long getPutCount() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setPutCount(long putCount) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public long getPutSuccessCount() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setPutSuccessCount(long putSuccessCount) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public long getPutFailCount() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setPutFailCount(long putFailCount) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public long getPutTimeSum() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setPutTimeSum(long putTimeSum) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public long getMinPutTime() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setMinPutTime(long minPutTime) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public long getMaxPutTime() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setMaxPutTime(long maxPutTime) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public long getRemoveCount() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setRemoveCount(long removeCount) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public long getRemoveSuccessCount() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setRemoveSuccessCount(long removeSuccessCount) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public long getRemoveFailCount() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setRemoveFailCount(long removeFailCount) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public long getRemoveTimeSum() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setRemoveTimeSum(long removeTimeSum) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public long getMinRemoveTime() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setMinRemoveTime(long minRemoveTime) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public long getMaxRemoveTime() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setMaxRemoveTime(long maxRemoveTime) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public long getLoadCount() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setLoadCount(long loadCount) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public long getLoadSuccessCount() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setLoadSuccessCount(long loadSuccessCount) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public long getLoadFailCount() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setLoadFailCount(long loadFailCount) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public long getLoadTimeSum() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setLoadTimeSum(long loadTimeSum) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public long getMinLoadTime() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setMinLoadTime(long minLoadTime) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public long getMaxLoadTime() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setMaxLoadTime(long maxLoadTime) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public long getStatStartTime() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setStatStartTime(long statStartTime) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public long getStatEndTime() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setStatEndTime(long statEndTime) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public String getCacheName() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setCacheName(String cacheName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
