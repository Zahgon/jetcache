/**
 * Created on 2018/8/11.
 */
package jetcache.samples.spring;

import java.io.Serializable;

/**
 * @author huangli
 */
public class User implements Serializable {

    private static final long serialVersionUID = -5157877924507849953L;

    private long userId;

    private String userName;

    public long getUserId() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setUserId(long userId) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public String getUserName() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setUserName(String userName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
