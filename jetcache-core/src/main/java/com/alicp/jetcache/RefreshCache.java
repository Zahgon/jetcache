package com.alicp.jetcache;

import com.alicp.jetcache.embedded.AbstractEmbeddedCache;
import com.alicp.jetcache.external.AbstractExternalCache;
import com.alicp.jetcache.support.JetCacheExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

/**
 * Created on 2017/5/25.
 *
 * @author huangli
 */
public class RefreshCache<K, V> extends LoadingCache<K, V> {

    private static final Logger logger = LoggerFactory.getLogger(RefreshCache.class);

    public static final byte[] LOCK_KEY_SUFFIX = "_#RL#".getBytes();

    public static final byte[] TIMESTAMP_KEY_SUFFIX = "_#TS#".getBytes();

    private ConcurrentHashMap<Object, RefreshTask> taskMap = new ConcurrentHashMap<>();

    private boolean multiLevelCache;

    public RefreshCache(Cache cache) {
        super(cache);
        multiLevelCache = isMultiLevelCache();
    }

    protected void stopRefresh() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void close() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private boolean hasLoader() {
        return config.getLoader() != null;
    }

    @Override
    public V computeIfAbsent(K key, Function<K, V> loader) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public V computeIfAbsent(K key, Function<K, V> loader, boolean cacheNullWhenLoaderReturnNull) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public V computeIfAbsent(K key, Function<K, V> loader, boolean cacheNullWhenLoaderReturnNull, long expireAfterWrite, TimeUnit timeUnit) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected Cache concreteCache() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private boolean isMultiLevelCache() {
        Cache c = getTargetCache();
        while (c instanceof ProxyCache) {
            c = ((ProxyCache) c).getTargetCache();
        }
        return c instanceof MultiLevelCache;
    }

    private Object getTaskId(K key) {
        Cache c = concreteCache();
        if (c instanceof AbstractEmbeddedCache) {
            return ((AbstractEmbeddedCache) c).buildKey(key);
        } else if (c instanceof AbstractExternalCache) {
            byte[] bs = ((AbstractExternalCache) c).buildKey(key);
            return ByteBuffer.wrap(bs);
        } else {
            logger.error("can't getTaskId from " + c.getClass());
            return null;
        }
    }

    protected void addOrUpdateRefreshTask(K key, CacheLoader<K, V> loader) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public V get(K key) throws CacheInvokeException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Map<K, V> getAll(Set<? extends K> keys) throws CacheInvokeException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    class RefreshTask implements Runnable {

        private Object taskId;

        private K key;

        private CacheLoader<K, V> loader;

        private long lastAccessTime;

        private ScheduledFuture future;

        RefreshTask(Object taskId, K key, CacheLoader<K, V> loader) {
            this.taskId = taskId;
            this.key = key;
            this.loader = loader;
        }

        private void cancel() {
            logger.debug("cancel refresh: {}", key);
            future.cancel(false);
            taskMap.remove(taskId);
        }

        private void load() throws Throwable {
            CacheLoader<K, V> l = loader == null ? config.getLoader() : loader;
            if (l != null) {
                l = CacheUtil.createProxyLoader(cache, l, eventConsumer);
                V v = l.load(key);
                if (needUpdate(v, l)) {
                    cache.PUT(key, v);
                }
            }
        }

        private void externalLoad(final Cache concreteCache, final long currentTime) throws Throwable {
            byte[] newKey = ((AbstractExternalCache) concreteCache).buildKey(key);
            byte[] lockKey = combine(newKey, LOCK_KEY_SUFFIX);
            long loadTimeOut = RefreshCache.this.config.getRefreshPolicy().getRefreshLockTimeoutMillis();
            long refreshMillis = config.getRefreshPolicy().getRefreshMillis();
            byte[] timestampKey = combine(newKey, TIMESTAMP_KEY_SUFFIX);
            // AbstractExternalCache buildKey method will not convert byte[]
            CacheGetResult refreshTimeResult = concreteCache.GET(timestampKey);
            boolean shouldLoad = false;
            if (refreshTimeResult.isSuccess()) {
                shouldLoad = currentTime >= Long.parseLong(refreshTimeResult.getValue().toString()) + refreshMillis;
            } else if (refreshTimeResult.getResultCode() == CacheResultCode.NOT_EXISTS) {
                shouldLoad = true;
            }
            if (!shouldLoad) {
                if (multiLevelCache) {
                    refreshUpperCaches(key);
                }
                return;
            }
            Runnable r = () -> {
                try {
                    load();
                    // AbstractExternalCache buildKey method will not convert byte[]
                    concreteCache.put(timestampKey, String.valueOf(System.currentTimeMillis()));
                } catch (Throwable e) {
                    throw new CacheException("refresh error", e);
                }
            };
            // AbstractExternalCache buildKey method will not convert byte[]
            boolean lockSuccess = concreteCache.tryLockAndRun(lockKey, loadTimeOut, TimeUnit.MILLISECONDS, r);
            if (!lockSuccess && multiLevelCache) {
                JetCacheExecutor.heavyIOExecutor().schedule(() -> refreshUpperCaches(key), (long) (0.2 * refreshMillis), TimeUnit.MILLISECONDS);
            }
        }

        private void refreshUpperCaches(K key) {
            MultiLevelCache<K, V> targetCache = (MultiLevelCache<K, V>) getTargetCache();
            Cache[] caches = targetCache.caches();
            int len = caches.length;
            CacheGetResult cacheGetResult = caches[len - 1].GET(key);
            if (!cacheGetResult.isSuccess()) {
                return;
            }
            for (int i = 0; i < len - 1; i++) {
                caches[i].PUT(key, cacheGetResult.getValue());
            }
        }

        @Override
        public void run() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    private byte[] combine(byte[] bs1, byte[] bs2) {
        byte[] newArray = Arrays.copyOf(bs1, bs1.length + bs2.length);
        System.arraycopy(bs2, 0, newArray, bs1.length, bs2.length);
        return newArray;
    }
}
