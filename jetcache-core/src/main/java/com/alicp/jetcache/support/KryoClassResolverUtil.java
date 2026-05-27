package com.alicp.jetcache.support;

final class KryoClassResolverUtil {

    private static final String[] PRIMITIVE_TYPE_NAMES = { "boolean", "byte", "char", "short", "int", "long", "float", "double", "void" };

    static void checkAllowed(Class<?> type, DecodeFilter decodeFilter) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static void checkAllowed(String className, DecodeFilter decodeFilter) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static Class<?> loadClass(String className, ClassLoader primary, ClassLoader fallback) throws ClassNotFoundException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static boolean isPrimitiveTypeName(String className) {
        if (className == null) {
            return false;
        }
        for (String primitiveTypeName : PRIMITIVE_TYPE_NAMES) {
            if (primitiveTypeName.equals(className)) {
                return true;
            }
        }
        return false;
    }
}
