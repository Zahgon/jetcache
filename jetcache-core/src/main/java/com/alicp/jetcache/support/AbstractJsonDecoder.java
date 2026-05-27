/**
 * Created on 2022/07/27.
 */
package com.alicp.jetcache.support;

import com.alicp.jetcache.CacheValueHolder;
import java.nio.charset.StandardCharsets;

/**
 * @author huangli
 */
public abstract class AbstractJsonDecoder extends AbstractValueDecoder {

    public AbstractJsonDecoder(boolean useIdentityNumber) {
        super(useIdentityNumber);
    }

    @Override
    protected Object doApply(byte[] buffer) throws Exception {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private int readInt(byte[] buf, int index) {
        int x = buf[index] & 0xFF;
        x = (x << 8) | (buf[index + 1] & 0xFF);
        x = (x << 8) | (buf[index + 2] & 0xFF);
        x = (x << 8) | (buf[index + 3] & 0xFF);
        return x;
    }

    private short readShort(byte[] buf, int index) {
        int x = buf[index] & 0xFF;
        x = (x << 8) | (buf[index + 1] & 0xFF);
        return (short) x;
    }

    private Object readObject(byte[] buf, int[] indexHolder) throws Exception {
        int index = indexHolder[0];
        short classNameLen = readShort(buf, index);
        index += 2;
        if (classNameLen < 0) {
            indexHolder[0] = index;
            return null;
        } else {
            String className = new String(buf, index, classNameLen, StandardCharsets.UTF_8);
            index += classNameLen;
            if (!DecodeFilter.getDefault().isAllowed(className)) {
                throw new DecodeFilterException(className);
            }
            Class<?> clazz = Class.forName(className);
            int size = readInt(buf, index);
            index += 4;
            Object obj = parseObject(buf, index, size, clazz);
            index += size;
            indexHolder[0] = index;
            return obj;
        }
    }

    protected abstract Object parseObject(byte[] buffer, int index, int len, Class clazz);
}
