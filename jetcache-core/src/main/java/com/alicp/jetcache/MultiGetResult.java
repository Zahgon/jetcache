package com.alicp.jetcache;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

/**
 * Created on 2017/2/21.
 *
 * @author huangli
 */
public class MultiGetResult<K, V> extends CacheResult {

    private volatile Map<K, CacheGetResult<V>> values;

    public MultiGetResult(CompletionStage<ResultData> future) {
        super(future);
    }

    public MultiGetResult(CacheResultCode resultCode, String message, Map<K, CacheGetResult<V>> values) {
        super(CompletableFuture.completedFuture(new ResultData(resultCode, message, values)));
    }

    public MultiGetResult(Throwable e) {
        super(e);
    }

    public Map<K, CacheGetResult<V>> getValues() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected void fetchResultSuccess(ResultData resultData) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected void fetchResultFail(Throwable e) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Map<K, V> unwrapValues() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
