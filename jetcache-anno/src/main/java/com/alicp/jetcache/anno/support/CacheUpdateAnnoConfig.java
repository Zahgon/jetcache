/**
 * Created on 2018/1/23.
 */
package com.alicp.jetcache.anno.support;

import java.util.function.Function;

/**
 * @author huangli
 */
public class CacheUpdateAnnoConfig extends CacheAnnoConfig {

    private String value;

    private boolean multi;

    private Function<Object, Object> valueEvaluator;

    public String getValue() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setValue(String value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Function<Object, Object> getValueEvaluator() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setValueEvaluator(Function<Object, Object> valueEvaluator) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public boolean isMulti() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setMulti(boolean multi) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
