/**
 * Created on 2019/6/22.
 */
package com.alicp.jetcache.support;

import java.io.Serializable;

/**
 * The CacheMessage is used for distributed message while CacheEvent used in single JVM.
 * @author huangli
 */
public class CacheMessage implements Serializable {

    private static final long serialVersionUID = -462475561129953207L;

    public static final int TYPE_PUT = 1;

    public static final int TYPE_PUT_ALL = 2;

    public static final int TYPE_REMOVE = 3;

    public static final int TYPE_REMOVE_ALL = 4;

    private String sourceId;

    private String area;

    private String cacheName;

    private int type;

    private Object[] keys;

    /**
     * this field is reserved.
     */
    private Object[] values;

    public int getType() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setType(int type) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Object[] getKeys() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setKeys(Object[] keys) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Object[] getValues() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setValues(Object[] values) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public String getArea() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setArea(String area) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public String getCacheName() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setCacheName(String cacheName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public String getSourceId() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setSourceId(String sourceId) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
