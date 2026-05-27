package com.alicp.jetcache;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * Created on 16/9/13.
 *
 * @author huangli
 */
public class MultiLevelCache<K, V> extends AbstractCache<K, V> {

    private Cache[] caches;

    private MultiLevelCacheConfig<K, V> config;

    @SuppressWarnings("unchecked")
    @Deprecated
    public MultiLevelCache(Cache... caches) throws CacheConfigException {
        this.caches = caches;
        checkCaches();
        CacheConfig lastConfig = caches[caches.length - 1].config();
        config = new MultiLevelCacheConfig<>();
        config.setCaches(Arrays.asList(caches));
        config.setExpireAfterWriteInMillis(lastConfig.getExpireAfterWriteInMillis());
        config.setCacheNullValue(lastConfig.isCacheNullValue());
    }

    @SuppressWarnings("unchecked")
    public MultiLevelCache(MultiLevelCacheConfig<K, V> cacheConfig) throws CacheConfigException {
        this.config = cacheConfig;
        this.caches = cacheConfig.getCaches().toArray(new Cache[] {});
        checkCaches();
    }

    private void checkCaches() {
        if (caches == null || caches.length == 0) {
            throw new IllegalArgumentException();
        }
        for (Cache c : caches) {
            if (c.config().getLoader() != null) {
                throw new CacheConfigException("Loader on sub cache is not allowed, set the loader into MultiLevelCache.");
            }
        }
    }

    public Cache[] caches() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public MultiLevelCacheConfig<K, V> config() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public CacheResult PUT(K key, V value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public CacheResult PUT_ALL(Map<? extends K, ? extends V> map) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected CacheGetResult<V> do_GET(K key) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private CacheValueHolder<V> unwrapHolder(CacheValueHolder<V> h) {
        // if @Cached or @CacheCache change type from REMOTE to BOTH (or from BOTH to REMOTE),
        // during the dev/publish process, the value type which different application server put into cache server will be different
        // (CacheValueHolder<V> and CacheValueHolder<CacheValueHolder<V>>, respectively).
        // So we need correct the problem at here and in CacheGetResult.
        Objects.requireNonNull(h);
        if (h.getValue() instanceof CacheValueHolder) {
            return (CacheValueHolder<V>) h.getValue();
        } else {
            return h;
        }
    }

    private void checkResultAndFillUpperCache(K key, int i, CacheValueHolder<V> h) {
        Objects.requireNonNull(h);
        long currentExpire = h.getExpireTime();
        long now = System.currentTimeMillis();
        if (now <= currentExpire) {
            if (config.isUseExpireOfSubCache()) {
                PUT_caches(i, key, h.getValue(), 0, null);
            } else {
                long restTtl = currentExpire - now;
                if (restTtl > 0) {
                    PUT_caches(i, key, h.getValue(), restTtl, TimeUnit.MILLISECONDS);
                }
            }
        }
    }

    @Override
    protected MultiGetResult<K, V> do_GET_ALL(Set<? extends K> keys) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected CacheResult do_PUT(K key, V value, long expireAfterWrite, TimeUnit timeUnit) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected CacheResult do_PUT_ALL(Map<? extends K, ? extends V> map, long expireAfterWrite, TimeUnit timeUnit) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private CacheResult PUT_caches(int lastIndex, K key, V value, long expire, TimeUnit timeUnit) {
        CompletableFuture<ResultData> future = CompletableFuture.completedFuture(null);
        for (int i = 0; i < lastIndex; i++) {
            Cache cache = caches[i];
            CacheResult r;
            if (timeUnit == null) {
                r = cache.PUT(key, value);
            } else {
                r = cache.PUT(key, value, expire, timeUnit);
            }
            future = combine(future, r);
        }
        return new CacheResult(future);
    }

    private CompletableFuture<ResultData> combine(CompletableFuture<ResultData> future, CacheResult result) {
        return future.thenCombine(result.future(), (d1, d2) -> {
            if (d1 == null) {
                return d2;
            }
            if (d1.getResultCode() != d2.getResultCode()) {
                return new ResultData(CacheResultCode.PART_SUCCESS, null, null);
            }
            return d1;
        });
    }

    @Override
    protected CacheResult do_REMOVE(K key) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected CacheResult do_REMOVE_ALL(Set<? extends K> keys) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <T> T unwrap(Class<T> clazz) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public AutoReleaseLock tryLock(K key, long expire, TimeUnit timeUnit) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean putIfAbsent(K key, V value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected CacheResult do_PUT_IF_ABSENT(K key, V value, long expireAfterWrite, TimeUnit timeUnit) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void close() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
