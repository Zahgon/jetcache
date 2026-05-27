package com.alicp.jetcache;

import com.alicp.jetcache.embedded.AbstractEmbeddedCache;
import com.alicp.jetcache.event.CacheEvent;
import com.alicp.jetcache.event.CacheGetAllEvent;
import com.alicp.jetcache.event.CacheGetEvent;
import com.alicp.jetcache.event.CachePutAllEvent;
import com.alicp.jetcache.event.CachePutEvent;
import com.alicp.jetcache.event.CacheRemoveAllEvent;
import com.alicp.jetcache.event.CacheRemoveEvent;
import com.alicp.jetcache.external.AbstractExternalCache;
import com.alicp.jetcache.support.JetCacheExecutor;
import com.alicp.jetcache.support.SquashedLogger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.nio.ByteBuffer;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Created on 2016/10/7.
 *
 * @author huangli
 */
public abstract class AbstractCache<K, V> implements Cache<K, V> {

    private static Logger logger = LoggerFactory.getLogger(AbstractCache.class);

    private volatile ConcurrentHashMap<Object, LoaderLock> loaderMap;

    protected volatile boolean closed;

    private static final ReentrantLock reentrantLock = new ReentrantLock();

    ConcurrentHashMap<Object, LoaderLock> initOrGetLoaderMap() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected void logError(String oper, Object key, Throwable e) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void notify(CacheEvent e) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private void notify(CacheResult r, CacheEvent e) {
        CompletionStage<?> f = r.future();
        if (f.toCompletableFuture().isDone()) {
            notify0(e);
        } else {
            f.thenRunAsync(() -> notify0(e), JetCacheExecutor.defaultExecutor());
        }
    }

    private void notify0(CacheEvent e) {
        List<CacheMonitor> monitors = config().getMonitors();
        for (CacheMonitor m : monitors) {
            m.afterOperation(e);
        }
    }

    @Override
    public final CacheGetResult<V> GET(K key) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected abstract CacheGetResult<V> do_GET(K key);

    @Override
    public final MultiGetResult<K, V> GET_ALL(Set<? extends K> keys) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected abstract MultiGetResult<K, V> do_GET_ALL(Set<? extends K> keys);

    @Override
    public final V computeIfAbsent(K key, Function<K, V> loader, boolean cacheNullWhenLoaderReturnNull) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public final V computeIfAbsent(K key, Function<K, V> loader, boolean cacheNullWhenLoaderReturnNull, long expireAfterWrite, TimeUnit timeUnit) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static <K, V> boolean needUpdate(V loadedValue, boolean cacheNullWhenLoaderReturnNull, Function<K, V> loader) {
        if (loadedValue == null && !cacheNullWhenLoaderReturnNull) {
            return false;
        }
        if (loader instanceof CacheLoader && ((CacheLoader<K, V>) loader).vetoCacheUpdate()) {
            return false;
        }
        return true;
    }

    static <K, V> V computeIfAbsentImpl(K key, Function<K, V> loader, boolean cacheNullWhenLoaderReturnNull, long expireAfterWrite, TimeUnit timeUnit, Cache<K, V> cache) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static <K, V> V synchronizedLoad(CacheConfig config, AbstractCache<K, V> abstractCache, K key, Function<K, V> newLoader, Consumer<V> cacheUpdater) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static Object buildLoaderLockKey(Cache c, Object key) {
        if (c instanceof AbstractEmbeddedCache) {
            return ((AbstractEmbeddedCache) c).buildKey(key);
        } else if (c instanceof AbstractExternalCache) {
            byte[] bytes = ((AbstractExternalCache) c).buildKey(key);
            return ByteBuffer.wrap(bytes);
        } else if (c instanceof MultiLevelCache) {
            c = ((MultiLevelCache) c).caches()[0];
            return buildLoaderLockKey(c, key);
        } else if (c instanceof ProxyCache) {
            c = ((ProxyCache) c).getTargetCache();
            return buildLoaderLockKey(c, key);
        } else {
            throw new CacheException("impossible");
        }
    }

    @Override
    public final CacheResult PUT(K key, V value, long expireAfterWrite, TimeUnit timeUnit) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected abstract CacheResult do_PUT(K key, V value, long expireAfterWrite, TimeUnit timeUnit);

    @Override
    public final CacheResult PUT_ALL(Map<? extends K, ? extends V> map, long expireAfterWrite, TimeUnit timeUnit) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected abstract CacheResult do_PUT_ALL(Map<? extends K, ? extends V> map, long expireAfterWrite, TimeUnit timeUnit);

    @Override
    public final CacheResult REMOVE(K key) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected abstract CacheResult do_REMOVE(K key);

    @Override
    public final CacheResult REMOVE_ALL(Set<? extends K> keys) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected abstract CacheResult do_REMOVE_ALL(Set<? extends K> keys);

    @Override
    public final CacheResult PUT_IF_ABSENT(K key, V value, long expireAfterWrite, TimeUnit timeUnit) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected abstract CacheResult do_PUT_IF_ABSENT(K key, V value, long expireAfterWrite, TimeUnit timeUnit);

    @Override
    public void close() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public boolean isClosed() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static class LoaderLock {

        CountDownLatch signal;

        Thread loaderThread;

        volatile boolean success;

        volatile Object value;
    }
}
