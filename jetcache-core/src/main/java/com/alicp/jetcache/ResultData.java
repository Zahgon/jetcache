package com.alicp.jetcache;

/**
 * Created on 2017/5/2.
 *
 * @author huangli
 */
public class ResultData {

    private CacheResultCode resultCode;

    private String message;

    private Object data;

    public ResultData(Throwable e) {
        this.resultCode = CacheResultCode.FAIL;
        this.message = "Ex : " + e.getClass() + ", " + e.getMessage();
    }

    public ResultData(CacheResultCode resultCode, String message, Object data) {
        this.resultCode = resultCode;
        this.message = message;
        this.data = data;
    }

    public Object getData() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Object getOriginData() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public CacheResultCode getResultCode() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setResultCode(CacheResultCode resultCode) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public String getMessage() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setMessage(String message) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setData(Object data) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
