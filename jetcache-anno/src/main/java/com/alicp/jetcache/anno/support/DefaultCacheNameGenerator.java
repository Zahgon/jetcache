/**
 * Created on 2018/3/22.
 */
package com.alicp.jetcache.anno.support;

import com.alicp.jetcache.anno.method.ClassUtil;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;

/**
 * @author huangli
 */
public class DefaultCacheNameGenerator implements CacheNameGenerator {

    protected final String[] hiddenPackages;

    protected final ConcurrentHashMap<Method, String> cacheNameMap = new ConcurrentHashMap();

    public DefaultCacheNameGenerator(String[] hiddenPackages) {
        this.hiddenPackages = hiddenPackages;
    }

    @Override
    public String generateCacheName(Method method, Object targetObject) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String generateCacheName(Field field) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @SuppressWarnings("PMD.AvoidPatternCompileInMethodRule")
    protected String removeHiddenPackage(String[] hiddenPackages, String packageOrFullClassName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected void getDescriptor(final StringBuilder sb, final Class<?> c, String[] hiddenPackages) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
