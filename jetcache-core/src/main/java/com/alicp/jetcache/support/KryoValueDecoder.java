package com.alicp.jetcache.support;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import java.io.ByteArrayInputStream;

/**
 * Created on 2016/10/4.
 *
 * Since 2.8.0 the com.esotericsoftware:kryo should be 5+, kryo4 is not supported.
 *
 * @author huangli
 */
public class KryoValueDecoder extends AbstractValueDecoder {

    public static final KryoValueDecoder INSTANCE = new KryoValueDecoder(true, KryoValueEncoder.DEFAULT_POOL);

    private final ObjectPool<KryoValueEncoder.KryoCache> pool;

    public KryoValueDecoder(boolean useIdentityNumber, ObjectPool<KryoValueEncoder.KryoCache> pool) {
        super(useIdentityNumber);
        this.pool = pool;
    }

    @Override
    public Object doApply(byte[] buffer) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
