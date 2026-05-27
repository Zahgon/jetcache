/**
 * Created on 2018/1/22.
 */
package com.alicp.jetcache.anno.support;

import com.alicp.jetcache.Cache;
import java.lang.reflect.Method;
import java.util.function.Function;

/**
 * @author huangli
 */
public class CacheAnnoConfig {

    private String area;

    private String name;

    private String key;

    private String condition;

    private Function<Object, Boolean> conditionEvaluator;

    private Function<Object, Object> keyEvaluator;

    private Cache<?, ?> cache;

    private Method defineMethod;

    public String getArea() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setArea(String area) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public String getName() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setName(String name) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public String getKey() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setKey(String key) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public String getCondition() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setCondition(String condition) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Function<Object, Boolean> getConditionEvaluator() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setConditionEvaluator(Function<Object, Boolean> conditionEvaluator) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Function<Object, Object> getKeyEvaluator() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setKeyEvaluator(Function<Object, Object> keyEvaluator) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Cache<?, ?> getCache() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setCache(Cache<?, ?> cache) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Method getDefineMethod() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setDefineMethod(Method defineMethod) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
