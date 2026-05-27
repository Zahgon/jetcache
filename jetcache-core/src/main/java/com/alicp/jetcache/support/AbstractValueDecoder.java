package com.alicp.jetcache.support;

import java.util.Objects;
import java.util.function.Function;

/**
 * Created on 2016/10/4.
 *
 * @author huangli
 */
public abstract class AbstractValueDecoder implements Function<byte[], Object>, ValueEncoders {

    protected boolean useIdentityNumber;

    private DecoderMap decoderMap = DecoderMap.defaultInstance();

    public AbstractValueDecoder(boolean useIdentityNumber) {
        this.useIdentityNumber = useIdentityNumber;
    }

    protected int parseHeader(byte[] buf) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected abstract Object doApply(byte[] buffer) throws Exception;

    @Override
    public Object apply(byte[] buffer) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public boolean isUseIdentityNumber() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setDecoderMap(DecoderMap decoderMap) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
