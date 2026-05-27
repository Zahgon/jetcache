/**
 * Created on 2018/3/20.
 */
package com.alicp.jetcache.support;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author huangli
 */
public class DecoderMap {

    public static final int IDENTITY_NUMBER_JAVA = 0x4A953A80;

    // int IDENTITY_NUMBER_FASTJSON = 0x4A953A81; not used since 2.5+
    // removed in 2.8.0
    // int IDENTITY_NUMBER_KRYO4 = 0x4A953A82;
    /**
     * @since 2.7
     */
    public static final int IDENTITY_NUMBER_KRYO5 = 0xF6E0A5C0;

    /**
     * fastjson2 encoder/decoder is implemented but not register by default.
     * This is because json is not good serializable util for java and has many compatible problems.
     *
     * @see com.alicp.jetcache.anno.support.DefaultEncoderParser
     * @see DecoderMap
     * @since 2.7
     */
    public static final int IDENTITY_NUMBER_FASTJSON2 = 0xF6E0A5C1;

    /**
     * jackson3 encoder/decoder is implemented but not register by default.
     * This is because json is not good serializable util for java and has many compatible problems.
     *
     * @see com.alicp.jetcache.anno.support.DefaultEncoderParser
     * @see DecoderMap
     * @since 2.8
     */
    public static final int IDENTITY_NUMBER_JACKSON3 = 0xF6E0A5C2;

    private final ConcurrentHashMap<Integer, AbstractValueDecoder> decoderMap = new ConcurrentHashMap<>();

    private volatile boolean inited = false;

    private final ReentrantLock reentrantLock = new ReentrantLock();

    private static final DecoderMap instance = new DecoderMap();

    public DecoderMap() {
    }

    public static DecoderMap defaultInstance() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public AbstractValueDecoder getDecoder(int identityNumber) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void register(int identityNumber, AbstractValueDecoder decoder) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void clear() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public ReentrantLock getLock() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setInited(boolean inited) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void initDefaultDecoder() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static JavaValueDecoder defaultJavaValueDecoder() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
