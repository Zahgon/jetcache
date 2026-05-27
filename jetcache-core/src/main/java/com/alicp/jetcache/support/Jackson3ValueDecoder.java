package com.alicp.jetcache.support;

import tools.jackson.databind.DatabindContext;
import tools.jackson.databind.DefaultTyping;
import tools.jackson.databind.JavaType;
import tools.jackson.databind.ObjectMapper;
import tools.jackson.databind.json.JsonMapper;
import tools.jackson.databind.jsontype.PolymorphicTypeValidator;
import java.nio.charset.StandardCharsets;

/**
 * @author huangli
 */
public class Jackson3ValueDecoder extends AbstractJsonDecoder {

    public static final Jackson3ValueDecoder INSTANCE = new Jackson3ValueDecoder(true);

    static final ObjectMapper OBJECT_MAPPER = JsonMapper.builder().activateDefaultTyping(new JetCachePolymorphicTypeValidator(), DefaultTyping.NON_FINAL).build();

    public Jackson3ValueDecoder(boolean useIdentityNumber) {
        super(useIdentityNumber);
    }

    @Override
    protected Object parseObject(byte[] buffer, int index, int len, Class clazz) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static class JetCachePolymorphicTypeValidator extends PolymorphicTypeValidator.Base {

        @Override
        public Validity validateSubClassName(DatabindContext ctxt, JavaType baseType, String subClassName) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public Validity validateSubType(DatabindContext ctxt, JavaType baseType, JavaType subType) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
