/**
 * Created on 2022/07/30.
 */
package com.alicp.jetcache.template;

import com.alicp.jetcache.CacheLoader;
import com.alicp.jetcache.RefreshPolicy;
import com.alicp.jetcache.anno.CacheConsts;
import com.alicp.jetcache.anno.CacheType;
import java.time.Duration;
import java.util.Objects;
import java.util.function.Function;

/**
 * @author huangli
 */
public class QuickConfig {

    private String area = CacheConsts.DEFAULT_AREA;

    private String name;

    private Duration expire;

    private Duration localExpire;

    private Integer localLimit;

    private CacheType cacheType;

    private Boolean syncLocal;

    private Function<Object, Object> keyConvertor;

    private Function<Object, byte[]> valueEncoder;

    private Function<byte[], Object> valueDecoder;

    private Boolean cacheNullValue;

    private Boolean useAreaInPrefix;

    private Boolean penetrationProtect;

    private Duration penetrationProtectTimeout;

    private RefreshPolicy refreshPolicy;

    private CacheLoader<? extends Object, ? extends Object> loader;

    private QuickConfig() {
    }

    public static Builder newBuilder(String name) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static Builder newBuilder(String area, String name) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static class Builder {

        private String area = CacheConsts.DEFAULT_AREA;

        private final String name;

        private Duration expire;

        private Duration localExpire;

        private Integer localLimit;

        private CacheType cacheType;

        private Boolean syncLocal;

        private Function<Object, Object> keyConvertor;

        private Function<Object, byte[]> valueEncoder;

        private Function<byte[], Object> valueDecoder;

        private Boolean cacheNullValue;

        private Boolean useAreaInPrefix;

        private Boolean penetrationProtect;

        private Duration penetrationProtectTimeout;

        private RefreshPolicy refreshPolicy;

        private CacheLoader<? extends Object, ? extends Object> loader;

        Builder(String name) {
            Objects.requireNonNull(name);
            this.name = name;
        }

        Builder(String area, String name) {
            Objects.requireNonNull(area);
            Objects.requireNonNull(name);
            this.area = area;
            this.name = name;
        }

        public QuickConfig build() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public Builder expire(Duration expire) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public Builder localExpire(Duration localExpire) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public Builder localLimit(Integer localLimit) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public Builder cacheType(CacheType cacheType) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public Builder syncLocal(Boolean syncLocal) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public Builder keyConvertor(Function<Object, Object> keyConvertor) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public Builder valueEncoder(Function<Object, byte[]> valueEncoder) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public Builder valueDecoder(Function<byte[], Object> valueDecoder) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public Builder cacheNullValue(Boolean cacheNullValue) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public Builder useAreaInPrefix(Boolean useAreaInPrefix) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public Builder penetrationProtect(Boolean penetrationProtect) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public Builder penetrationProtectTimeout(Duration penetrationProtectTimeout) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public Builder refreshPolicy(RefreshPolicy refreshPolicy) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public <K, V> Builder loader(CacheLoader<K, V> loader) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    public String getArea() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public String getName() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Duration getExpire() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Duration getLocalExpire() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public CacheType getCacheType() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Integer getLocalLimit() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Boolean getSyncLocal() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Function<Object, Object> getKeyConvertor() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Function<Object, byte[]> getValueEncoder() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Function<byte[], Object> getValueDecoder() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Boolean getCacheNullValue() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Boolean getUseAreaInPrefix() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Boolean getPenetrationProtect() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Duration getPenetrationProtectTimeout() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public RefreshPolicy getRefreshPolicy() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public <K, V> CacheLoader<K, V> getLoader() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
