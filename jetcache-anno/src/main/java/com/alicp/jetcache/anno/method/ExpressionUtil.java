/**
 * Created on  13-10-02 18:38
 */
package com.alicp.jetcache.anno.method;

import com.alicp.jetcache.anno.CacheConsts;
import com.alicp.jetcache.anno.support.CacheAnnoConfig;
import com.alicp.jetcache.anno.support.CacheUpdateAnnoConfig;
import com.alicp.jetcache.anno.support.CachedAnnoConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author huangli
 */
class ExpressionUtil {

    private static final Logger logger = LoggerFactory.getLogger(ExpressionUtil.class);

    static Object EVAL_FAILED = new Object();

    public static boolean evalCondition(CacheInvokeContext context, CacheAnnoConfig cac) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static boolean evalPostCondition(CacheInvokeContext context, CachedAnnoConfig cac) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static Object evalKey(CacheInvokeContext context, CacheAnnoConfig cac) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static Object evalValue(CacheInvokeContext context, CacheUpdateAnnoConfig cac) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
