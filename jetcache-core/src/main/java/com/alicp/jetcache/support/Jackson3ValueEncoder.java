package com.alicp.jetcache.support;

/**
 * @author huangli
 */
public class Jackson3ValueEncoder extends AbstractJsonEncoder {

    public static final Jackson3ValueEncoder INSTANCE = new Jackson3ValueEncoder(true);

    public Jackson3ValueEncoder(boolean useIdentityNumber) {
        super(useIdentityNumber, DecoderMap.IDENTITY_NUMBER_JACKSON3);
    }

    @Override
    protected byte[] encodeSingleValue(Object value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
