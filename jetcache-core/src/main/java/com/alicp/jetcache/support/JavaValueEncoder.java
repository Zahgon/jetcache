package com.alicp.jetcache.support;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Created on 2016/10/4.
 *
 * @author huangli
 */
public class JavaValueEncoder extends AbstractValueEncoder {

    public static final JavaValueEncoder INSTANCE = new JavaValueEncoder(true);

    private static final int INIT_BUF_SIZE = 2048;

    public JavaValueEncoder(boolean useIdentityNumber) {
        super(useIdentityNumber);
    }

    static ObjectPool<ByteArrayOutputStream> bosPool = new ObjectPool<>(16, new ObjectPool.ObjectFactory<ByteArrayOutputStream>() {

        @Override
        public ByteArrayOutputStream create() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void reset(ByteArrayOutputStream obj) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    });

    @Override
    public byte[] apply(Object value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
