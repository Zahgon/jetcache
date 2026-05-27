/**
 * Created on  13-09-10 10:33
 */
package com.alicp.jetcache.anno.support;

import com.alicp.jetcache.RefreshPolicy;
import com.alicp.jetcache.anno.CacheType;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

/**
 * @author huangli
 */
public class CachedAnnoConfig extends CacheAnnoConfig {

    private boolean enabled;

    private TimeUnit timeUnit;

    private long expire;

    private long localExpire;

    private CacheType cacheType;

    private boolean syncLocal;

    private int localLimit;

    private boolean cacheNullValue;

    private String serialPolicy;

    private String keyConvertor;

    private String postCondition;

    private Function<Object, Boolean> postConditionEvaluator;

    private RefreshPolicy refreshPolicy;

    private PenetrationProtectConfig penetrationProtectConfig;

    public boolean isEnabled() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public long getExpire() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public CacheType getCacheType() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public int getLocalLimit() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setEnabled(boolean enabled) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setExpire(long expire) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setCacheType(CacheType cacheType) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setLocalLimit(int localLimit) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public boolean isCacheNullValue() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setCacheNullValue(boolean cacheNullValue) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public String getSerialPolicy() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setSerialPolicy(String serialPolicy) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public String getKeyConvertor() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setKeyConvertor(String keyConvertor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public TimeUnit getTimeUnit() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setTimeUnit(TimeUnit timeUnit) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public String getPostCondition() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setPostCondition(String postCondition) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Function<Object, Boolean> getPostConditionEvaluator() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setPostConditionEvaluator(Function<Object, Boolean> postConditionEvaluator) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public RefreshPolicy getRefreshPolicy() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setRefreshPolicy(RefreshPolicy refreshPolicy) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public PenetrationProtectConfig getPenetrationProtectConfig() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setPenetrationProtectConfig(PenetrationProtectConfig penetrationProtectConfig) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public long getLocalExpire() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setLocalExpire(long localExpire) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public boolean isSyncLocal() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setSyncLocal(boolean syncLocal) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
