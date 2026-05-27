package com.alicp.jetcache.redis.lettuce;

import io.lettuce.core.codec.RedisCodec;
import java.nio.ByteBuffer;

/**
 * Created on 2017/4/28.
 *
 * @author huangli
 */
public class JetCacheCodec implements RedisCodec {

    @Override
    public ByteBuffer encodeKey(Object key) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Object decodeKey(ByteBuffer bytes) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public ByteBuffer encodeValue(Object value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Object decodeValue(ByteBuffer bytes) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private Object convert(ByteBuffer bytes) {
        byte[] bs = new byte[bytes.remaining()];
        bytes.get(bs);
        return bs;
    }
}
