/**
 * Created on 2022/07/27.
 */
package com.alicp.jetcache.support;

import com.alicp.jetcache.CacheValueHolder;
import java.nio.charset.StandardCharsets;

/**
 * @author huangli
 */
public abstract class AbstractJsonEncoder extends AbstractValueEncoder {

    private final int identityNumber;

    public AbstractJsonEncoder(boolean useIdentityNumber, int identityNumber) {
        super(useIdentityNumber);
        this.identityNumber = identityNumber;
    }

    protected abstract byte[] encodeSingleValue(Object value);

    @Override
    public byte[] apply(Object value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private int len(JsonData[] data) {
        if (data == null) {
            return 2;
        }
        int x = 2;
        for (JsonData d : data) {
            if (d == null) {
                x += 2;
            } else {
                x += 2 + d.getClassName().length + 4 + d.getData().length;
            }
        }
        return x;
    }

    private int writeInt(byte[] buf, int index, int value) {
        buf[index] = (byte) (value >> 24 & 0xFF);
        buf[index + 1] = (byte) (value >> 16 & 0xFF);
        buf[index + 2] = (byte) (value >> 8 & 0xFF);
        buf[index + 3] = (byte) (value & 0xFF);
        return index + 4;
    }

    private int writeShort(byte[] buf, int index, int value) {
        buf[index] = (byte) (value >> 8 & 0xFF);
        buf[index + 1] = (byte) (value & 0xFF);
        return index + 2;
    }

    private int writeBytes(byte[] buf, int index, byte[] data) {
        System.arraycopy(data, 0, buf, index, data.length);
        return index + data.length;
    }

    private JsonData[] encode(Object value) {
        if (value == null) {
            return null;
        }
        if (value instanceof CacheValueHolder) {
            CacheValueHolder h = (CacheValueHolder) value;
            Object bizObject = h.getValue();
            h.setValue(null);
            JsonData[] result = new JsonData[2];
            result[0] = encodeJsonData(h);
            result[1] = encodeJsonData(bizObject);
            h.setValue(bizObject);
            return result;
        } else if (value instanceof CacheMessage) {
            CacheMessage cm = (CacheMessage) value;
            Object[] keys = cm.getKeys();
            cm.setKeys(null);
            JsonData[] result = keys == null ? new JsonData[1] : new JsonData[keys.length + 1];
            result[0] = encodeJsonData(cm);
            if (keys != null) {
                for (int i = 0; i < keys.length; i++) {
                    result[i + 1] = encodeJsonData(keys[i]);
                }
            }
            cm.setKeys(keys);
            return result;
        } else {
            return new JsonData[] { encodeJsonData(value) };
        }
    }

    private JsonData encodeJsonData(Object value) {
        if (value == null) {
            return null;
        }
        JsonData jsonData = new JsonData();
        jsonData.setClassName(value.getClass().getName().getBytes(StandardCharsets.UTF_8));
        jsonData.setData(encodeSingleValue(value));
        return jsonData;
    }

    private static class JsonData {

        private byte[] className;

        private byte[] data;

        public byte[] getClassName() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public void setClassName(byte[] className) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public byte[] getData() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public void setData(byte[] data) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
