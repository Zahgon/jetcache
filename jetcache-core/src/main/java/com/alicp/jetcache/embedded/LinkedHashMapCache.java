/**
 * Created on  13-09-12 19:02
 */
package com.alicp.jetcache.embedded;

import com.alicp.jetcache.CacheResultCode;
import com.alicp.jetcache.CacheValueHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.*;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author huangli
 */
public class LinkedHashMapCache<K, V> extends AbstractEmbeddedCache<K, V> {

    private static Logger logger = LoggerFactory.getLogger(LinkedHashMapCache.class);

    public LinkedHashMapCache(EmbeddedCacheConfig<K, V> config) {
        super(config);
        addToCleaner();
    }

    protected void addToCleaner() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected InnerMap createAreaCache() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <T> T unwrap(Class<T> clazz) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void cleanExpiredEntry() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    final class LRUMap extends LinkedHashMap implements InnerMap {

        private final int max;

        private final ReentrantLock lock = new ReentrantLock();

        public LRUMap(int max) {
            super((int) (max * 1.4f), 0.75f, true);
            this.max = max;
            //            this.lockObj = lockObj;
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry eldest) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        void cleanExpiredEntry() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public Object getValue(Object key) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public Map getAllValues(Collection keys) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void putValue(Object key, Object value) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void putAllValues(Map map) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public boolean removeValue(Object key) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void removeAllValues(Collection keys) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        @SuppressWarnings("unchecked")
        public boolean putIfAbsentValue(Object key, Object value) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
