/**
 * Created on 2019/6/7.
 */
package com.alicp.jetcache.anno.support;

import com.alicp.jetcache.CacheConfigException;
import com.alicp.jetcache.anno.SerialPolicy;
import com.alicp.jetcache.support.JavaValueDecoder;
import com.alicp.jetcache.support.JavaValueEncoder;
import com.alicp.jetcache.support.Kryo5ValueDecoder;
import com.alicp.jetcache.support.Kryo5ValueEncoder;
import com.alicp.jetcache.support.KryoValueDecoder;
import com.alicp.jetcache.support.KryoValueEncoder;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * @author huangli
 */
public class DefaultEncoderParser implements EncoderParser {

    protected static Map<String, String> parseQueryParameters(String query) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    JavaValueDecoder javaValueDecoder(boolean useIdentityNumber) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Function<Object, byte[]> parseEncoder(String valueEncoder) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private boolean isUseIdentityNumber(URI uri) {
        Map<String, String> params = parseQueryParameters(uri.getQuery());
        boolean useIdentityNumber = true;
        if ("false".equalsIgnoreCase(params.get("useIdentityNumber"))) {
            useIdentityNumber = false;
        }
        return useIdentityNumber;
    }

    @Override
    public Function<byte[], Object> parseDecoder(String valueDecoder) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
