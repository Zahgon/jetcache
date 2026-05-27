package com.alicp.jetcache.support;

import com.esotericsoftware.kryo.kryo5.Kryo;
import com.esotericsoftware.kryo.kryo5.io.Input;
import java.io.ByteArrayInputStream;

/**
 * Created on 2016/10/4.
 *
 * @author huangli
 */
public class Kryo5ValueDecoder extends AbstractValueDecoder {

    public static final Kryo5ValueDecoder INSTANCE = new Kryo5ValueDecoder(true, Kryo5ValueEncoder.DEFAULT_POOL);

    private final ObjectPool<Kryo5ValueEncoder.KryoCache> pool;

    public Kryo5ValueDecoder(boolean useIdentityNumber, ObjectPool<Kryo5ValueEncoder.KryoCache> pool) {
        super(useIdentityNumber);
        this.pool = pool;
    }

    @Override
    public Object doApply(byte[] buffer) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
