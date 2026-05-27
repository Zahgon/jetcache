/**
 * Created on  13-09-09 15:59
 */
package com.alicp.jetcache.anno.method;

import com.alicp.jetcache.AbstractCache;
import com.alicp.jetcache.Cache;
import com.alicp.jetcache.CacheInvokeException;
import com.alicp.jetcache.CacheLoader;
import com.alicp.jetcache.ProxyCache;
import com.alicp.jetcache.anno.support.CacheContext;
import com.alicp.jetcache.anno.support.CacheInvalidateAnnoConfig;
import com.alicp.jetcache.anno.support.CacheUpdateAnnoConfig;
import com.alicp.jetcache.anno.support.CachedAnnoConfig;
import com.alicp.jetcache.anno.support.ConfigMap;
import com.alicp.jetcache.event.CacheLoadEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Supplier;

/**
 * @author huangli
 */
public class CacheHandler implements InvocationHandler {

    private static Logger logger = LoggerFactory.getLogger(CacheHandler.class);

    private Object src;

    private Supplier<CacheInvokeContext> contextSupplier;

    private String[] hiddenPackages;

    private ConfigMap configMap;

    private static class CacheContextSupport extends CacheContext {

        public CacheContextSupport() {
            super(null, null, null);
        }

        static void _enable() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        static void _disable() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        static boolean _isEnabled() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    public CacheHandler(Object src, ConfigMap configMap, Supplier<CacheInvokeContext> contextSupplier, String[] hiddenPackages) {
        this.src = src;
        this.configMap = configMap;
        this.contextSupplier = contextSupplier;
        this.hiddenPackages = hiddenPackages;
    }

    @Override
    public Object invoke(Object proxy, final Method method, final Object[] args) throws Throwable {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static Object invoke(CacheInvokeContext context) throws Throwable {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static Object doInvoke(CacheInvokeContext context) throws Throwable {
        CacheInvokeConfig cic = context.getCacheInvokeConfig();
        CachedAnnoConfig cachedConfig = cic.getCachedAnnoConfig();
        if (cachedConfig != null && (cachedConfig.isEnabled() || CacheContextSupport._isEnabled())) {
            return invokeWithCached(context);
        } else if (cic.getInvalidateAnnoConfigs() != null || cic.getUpdateAnnoConfig() != null) {
            return invokeWithInvalidateOrUpdate(context);
        } else {
            return invokeOrigin(context);
        }
    }

    private static Object invokeWithInvalidateOrUpdate(CacheInvokeContext context) throws Throwable {
        Object originResult = invokeOrigin(context);
        context.setResult(originResult);
        CacheInvokeConfig cic = context.getCacheInvokeConfig();
        if (cic.getInvalidateAnnoConfigs() != null) {
            doInvalidate(context, cic.getInvalidateAnnoConfigs());
        }
        CacheUpdateAnnoConfig updateAnnoConfig = cic.getUpdateAnnoConfig();
        if (updateAnnoConfig != null) {
            doUpdate(context, updateAnnoConfig);
        }
        return originResult;
    }

    private static Iterable toIterable(Object obj) {
        if (obj.getClass().isArray()) {
            if (obj instanceof Object[]) {
                return Arrays.asList((Object[]) obj);
            } else {
                List list = new ArrayList();
                int len = Array.getLength(obj);
                for (int i = 0; i < len; i++) {
                    list.add(Array.get(obj, i));
                }
                return list;
            }
        } else if (obj instanceof Iterable) {
            return (Iterable) obj;
        } else {
            return null;
        }
    }

    private static void doInvalidate(CacheInvokeContext context, List<CacheInvalidateAnnoConfig> annoConfig) {
        for (CacheInvalidateAnnoConfig config : annoConfig) {
            doInvalidate(context, config);
        }
    }

    private static void doInvalidate(CacheInvokeContext context, CacheInvalidateAnnoConfig annoConfig) {
        Cache cache = context.getCacheFunction().apply(context, annoConfig);
        if (cache == null) {
            return;
        }
        boolean condition = ExpressionUtil.evalCondition(context, annoConfig);
        if (!condition) {
            return;
        }
        Object key = ExpressionUtil.evalKey(context, annoConfig);
        if (key == null) {
            return;
        }
        if (annoConfig.isMulti()) {
            Iterable it = toIterable(key);
            if (it == null) {
                logger.error("jetcache @CacheInvalidate key is not instance of Iterable or array: " + annoConfig.getDefineMethod());
                return;
            }
            Set keys = new HashSet();
            it.forEach(k -> keys.add(k));
            cache.removeAll(keys);
        } else {
            cache.remove(key);
        }
    }

    private static void doUpdate(CacheInvokeContext context, CacheUpdateAnnoConfig updateAnnoConfig) {
        Cache cache = context.getCacheFunction().apply(context, updateAnnoConfig);
        if (cache == null) {
            return;
        }
        boolean condition = ExpressionUtil.evalCondition(context, updateAnnoConfig);
        if (!condition) {
            return;
        }
        Object key = ExpressionUtil.evalKey(context, updateAnnoConfig);
        Object value = ExpressionUtil.evalValue(context, updateAnnoConfig);
        if (key == null || value == ExpressionUtil.EVAL_FAILED) {
            return;
        }
        if (updateAnnoConfig.isMulti()) {
            if (value == null) {
                return;
            }
            Iterable keyIt = toIterable(key);
            Iterable valueIt = toIterable(value);
            if (keyIt == null) {
                logger.error("jetcache @CacheUpdate key is not instance of Iterable or array: " + updateAnnoConfig.getDefineMethod());
                return;
            }
            if (valueIt == null) {
                logger.error("jetcache @CacheUpdate value is not instance of Iterable or array: " + updateAnnoConfig.getDefineMethod());
                return;
            }
            List keyList = new ArrayList();
            List valueList = new ArrayList();
            keyIt.forEach(o -> keyList.add(o));
            valueIt.forEach(o -> valueList.add(o));
            if (keyList.size() != valueList.size()) {
                logger.error("jetcache @CacheUpdate key size not equals with value size: " + updateAnnoConfig.getDefineMethod());
                return;
            } else {
                Map m = new HashMap();
                for (int i = 0; i < valueList.size(); i++) {
                    m.put(keyList.get(i), valueList.get(i));
                }
                cache.putAll(m);
            }
        } else {
            cache.put(key, value);
        }
    }

    private static Object invokeWithCached(CacheInvokeContext context) throws Throwable {
        CacheInvokeConfig cic = context.getCacheInvokeConfig();
        CachedAnnoConfig cac = cic.getCachedAnnoConfig();
        Cache cache = context.getCacheFunction().apply(context, cac);
        if (cache == null) {
            logger.error("no cache with name: " + context.getMethod());
            return invokeOrigin(context);
        }
        Object key = ExpressionUtil.evalKey(context, cic.getCachedAnnoConfig());
        if (key == null) {
            return loadAndCount(context, cache, key);
        }
        if (!ExpressionUtil.evalCondition(context, cic.getCachedAnnoConfig())) {
            return loadAndCount(context, cache, key);
        }
        try {
            CacheLoader loader = new CacheLoader() {

                @Override
                public Object load(Object k) throws Throwable {
                    throw new UnsupportedOperationException("STUB: not implemented");
                }

                @Override
                public boolean vetoCacheUpdate() {
                    throw new UnsupportedOperationException("STUB: not implemented");
                }
            };
            Object result = cache.computeIfAbsent(key, loader);
            return result;
        } catch (CacheInvokeException e) {
            throw e.getCause();
        }
    }

    private static Object loadAndCount(CacheInvokeContext context, Cache cache, Object key) throws Throwable {
        long t = System.currentTimeMillis();
        Object v = null;
        boolean success = false;
        try {
            v = invokeOrigin(context);
            success = true;
        } finally {
            t = System.currentTimeMillis() - t;
            CacheLoadEvent event = new CacheLoadEvent(cache, t, key, v, success);
            while (cache instanceof ProxyCache) {
                cache = ((ProxyCache) cache).getTargetCache();
            }
            if (cache instanceof AbstractCache) {
                ((AbstractCache) cache).notify(event);
            }
        }
        return v;
    }

    private static Object invokeOrigin(CacheInvokeContext context) throws Throwable {
        return context.getInvoker().invoke();
    }
}
