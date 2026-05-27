package com.alicp.jetcache;

import com.alicp.jetcache.anno.CacheConsts;
import java.time.Duration;
import java.util.concurrent.*;

/**
 * Created on 2016/9/28.
 *
 * @author huangli
 */
public class CacheResult {

    public static final String MSG_ILLEGAL_ARGUMENT = "illegal argument";

    private static Duration DEFAULT_TIMEOUT = CacheConsts.ASYNC_RESULT_TIMEOUT;

    public static final CacheResult SUCCESS_WITHOUT_MSG = new CacheResult(CacheResultCode.SUCCESS, null);

    public static final CacheResult PART_SUCCESS_WITHOUT_MSG = new CacheResult(CacheResultCode.PART_SUCCESS, null);

    public static final CacheResult FAIL_WITHOUT_MSG = new CacheResult(CacheResultCode.FAIL, null);

    public static final CacheResult FAIL_ILLEGAL_ARGUMENT = new CacheResult(CacheResultCode.FAIL, MSG_ILLEGAL_ARGUMENT);

    public static final CacheResult EXISTS_WITHOUT_MSG = new CacheResult(CacheResultCode.EXISTS, null);

    private volatile CacheResultCode resultCode;

    private volatile String message;

    private final CompletionStage<ResultData> future;

    private volatile Duration timeout = DEFAULT_TIMEOUT;

    public CacheResult(CompletionStage<ResultData> future) {
        this.future = future;
    }

    public CacheResult(CacheResultCode resultCode, String message) {
        this(CompletableFuture.completedFuture(new ResultData(resultCode, message, null)));
    }

    public CacheResult(Throwable ex) {
        future = CompletableFuture.completedFuture(new ResultData(ex));
    }

    public boolean isSuccess() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected void waitForResult() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void waitForResult(Duration timeout) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected void fetchResultSuccess(ResultData resultData) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected void fetchResultFail(Throwable e) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public CacheResultCode getResultCode() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public String getMessage() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public CompletionStage<ResultData> future() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static void setDefaultTimeout(Duration defaultTimeout) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setTimeout(Duration timeout) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
