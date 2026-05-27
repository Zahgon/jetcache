/**
 * Created on 2019/6/7.
 */
package com.alicp.jetcache.anno.support;

import com.alicp.jetcache.CacheConfigException;
import com.alicp.jetcache.anno.KeyConvertor;
import com.alicp.jetcache.support.Fastjson2KeyConvertor;
import com.alicp.jetcache.support.Jackson3KeyConvertor;
import com.alicp.jetcache.support.JacksonKeyConvertor;
import java.util.function.Function;

/**
 * @author huangli
 */
public class DefaultKeyConvertorParser implements KeyConvertorParser {

    @Override
    public Function<Object, Object> parseKeyConvertor(String convertor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
