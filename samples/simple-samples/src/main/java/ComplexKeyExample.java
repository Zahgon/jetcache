import com.alicp.jetcache.Cache;
import com.alicp.jetcache.embedded.CaffeineCacheBuilder;
import com.alicp.jetcache.support.Fastjson2KeyConvertor;
import java.util.concurrent.TimeUnit;

/**
 * Created on 2016/11/2.
 *
 * @author huangli
 */
public class ComplexKeyExample {

    public static void main(String[] args) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // no "equals" method
    static class DynamicQuery {

        private long id;

        private String name;

        private String email;

        public long getId() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public void setId(long id) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public String getName() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public void setName(String name) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public String getEmail() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public void setEmail(String email) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
