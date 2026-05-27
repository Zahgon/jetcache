/**
 * Created on  13-09-10 15:45
 */
package com.alicp.jetcache.support;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.function.Function;

/**
 * @author huangli
 */
public class JacksonKeyConvertor implements Function<Object, Object> {

    public static final JacksonKeyConvertor INSTANCE = new JacksonKeyConvertor();

    private static ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public Object apply(Object originalKey) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
