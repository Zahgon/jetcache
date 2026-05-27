/**
 * Created on  13-09-09 18:16
 */
package com.alicp.jetcache;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

/**
 * @author huangli
 */
public class CacheGetResult<V> extends CacheResult {

    private volatile V value;

    private volatile CacheValueHolder<V> holder;

    public static final CacheGetResult NOT_EXISTS_WITHOUT_MSG = new CacheGetResult(CacheResultCode.NOT_EXISTS, null, null);

    public static final CacheGetResult EXPIRED_WITHOUT_MSG = new CacheGetResult(CacheResultCode.EXPIRED, null, null);

    public CacheGetResult(CacheResultCode resultCode, String message, CacheValueHolder<V> holder) {
        super(CompletableFuture.completedFuture(new ResultData(resultCode, message, holder)));
    }

    public CacheGetResult(CompletionStage<ResultData> future) {
        super(future);
    }

    public CacheGetResult(Throwable ex) {
        super(ex);
    }

    public V getValue() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected void fetchResultSuccess(ResultData resultData) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static Object unwrapValue(Object holder) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected void fetchResultFail(Throwable e) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected CacheValueHolder<V> getHolder() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
