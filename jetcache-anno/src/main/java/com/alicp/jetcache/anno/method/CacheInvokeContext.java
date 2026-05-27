/**
 * Created on  13-10-02 16:10
 */
package com.alicp.jetcache.anno.method;

import com.alicp.jetcache.Cache;
import com.alicp.jetcache.anno.support.CacheAnnoConfig;
import java.lang.reflect.Method;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * @author huangli
 */
public class CacheInvokeContext {

    private Invoker invoker;

    private Method method;

    private Object[] args;

    private CacheInvokeConfig cacheInvokeConfig;

    private Object targetObject;

    private Object result;

    private BiFunction<CacheInvokeContext, CacheAnnoConfig, Cache> cacheFunction;

    private String[] hiddenPackages;

    public CacheInvokeContext() {
    }

    public void setInvoker(Invoker invoker) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Invoker getInvoker() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Method getMethod() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setMethod(Method method) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setArgs(Object[] args) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setCacheInvokeConfig(CacheInvokeConfig cacheInvokeConfig) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public CacheInvokeConfig getCacheInvokeConfig() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setHiddenPackages(String[] hiddenPackages) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public String[] getHiddenPackages() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setCacheFunction(BiFunction<CacheInvokeContext, CacheAnnoConfig, Cache> cacheFunction) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public BiFunction<CacheInvokeContext, CacheAnnoConfig, Cache> getCacheFunction() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Object[] getArgs() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Object getTargetObject() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setTargetObject(Object targetObject) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Object getResult() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setResult(Object result) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
