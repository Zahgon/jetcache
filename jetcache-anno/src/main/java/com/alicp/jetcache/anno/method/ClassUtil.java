/**
 * Created on  13-09-09 17:20
 */
package com.alicp.jetcache.anno.method;

import org.springframework.asm.Type;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.HashSet;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author huangli
 */
public class ClassUtil {

    private static ConcurrentHashMap<Method, String> methodSigMap = new ConcurrentHashMap();

    public static String getShortClassName(String className) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static Class<?>[] getAllInterfaces(Object obj) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static void getMethodSig(StringBuilder sb, Method m) {
        sb.append(m.getName());
        sb.append(Type.getType(m).getDescriptor());
    }

    public static String getMethodSig(Method m) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
