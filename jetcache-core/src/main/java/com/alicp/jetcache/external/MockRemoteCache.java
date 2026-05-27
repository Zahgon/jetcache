/**
 * Created on  13-09-22 16:54
 */
package com.alicp.jetcache.external;

import com.alicp.jetcache.*;
import com.alicp.jetcache.embedded.LinkedHashMapCacheBuilder;
import com.alicp.jetcache.external.AbstractExternalCache;
import com.alicp.jetcache.external.ExternalCacheConfig;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @author huangli
 */
public class MockRemoteCache<K, V> extends AbstractExternalCache<K, V> {

    private Cache<ByteBuffer, byte[]> cache;

    private ExternalCacheConfig<K, V> config;

    public MockRemoteCache(MockRemoteCacheConfig<K, V> config) {
        super(config);
        this.config = config;
        cache = LinkedHashMapCacheBuilder.createLinkedHashMapCacheBuilder().limit(config.getLimit()).expireAfterWrite(config.getExpireAfterWriteInMillis(), TimeUnit.MILLISECONDS).buildCache();
    }

    @Override
    public CacheConfig<K, V> config() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private ByteBuffer genKey(K key) {
        return ByteBuffer.wrap(buildKey(key));
    }

    //-------------------------------
    @Override
    public <T> T unwrap(Class<T> clazz) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static Method getHolder;

    static {
        try {
            getHolder = CacheGetResult.class.getDeclaredMethod("getHolder");
            getHolder.setAccessible(true);
        } catch (NoSuchMethodException e) {
            throw new CacheException(e);
        }
    }

    private CacheGetResult convertCacheGetResult(CacheGetResult originResult) {
        try {
            CacheValueHolder originHolder = (CacheValueHolder) getHolder.invoke(originResult);
            LinkedList<CacheValueHolder> list = new LinkedList<>();
            while (originHolder != null) {
                CacheValueHolder h = new CacheValueHolder();
                if (list.size() > 0) {
                    list.getLast().setValue(h);
                }
                list.add(h);
                h.setAccessTime(originHolder.getAccessTime());
                h.setExpireTime(originHolder.getExpireTime());
                Object v = originHolder.getValue();
                if (v != null && !(v instanceof CacheValueHolder)) {
                    h.setValue(config.getValueDecoder().apply((byte[]) v));
                    break;
                } else if (originHolder.getValue() == null) {
                    originHolder = (CacheValueHolder) originHolder.getValue();
                }
            }
            return new CacheGetResult(originResult.getResultCode(), originResult.getMessage(), list.peekFirst());
        } catch (Exception e) {
            throw new CacheException(e);
        }
    }

    public CacheValueHolder getHolder(K key) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected CacheGetResult<V> do_GET(K key) {
        throw new UnsupportedOperationException("STUB: not implemented");
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

    @Override
    protected CacheResult do_REMOVE(K key) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected CacheResult do_REMOVE_ALL(Set<? extends K> keys) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected CacheResult do_PUT_IF_ABSENT(K key, V value, long expireAfterWrite, TimeUnit timeUnit) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
