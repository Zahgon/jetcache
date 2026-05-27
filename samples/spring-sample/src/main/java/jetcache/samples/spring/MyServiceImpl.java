/**
 * Created on 2018/8/11.
 */
package jetcache.samples.spring;

import com.alicp.jetcache.Cache;
import com.alicp.jetcache.CacheManager;
import com.alicp.jetcache.template.QuickConfig;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.time.Duration;

/**
 * @author huangli
 */
@Component
public class MyServiceImpl implements MyService, InitializingBean {

    @Autowired
    private UserService userService;

    @Autowired
    private CacheManager cacheManager;

    private Cache<String, String> orderCache;

    @Override
    public void afterPropertiesSet() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void createCacheDemo() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void cachedDemo() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
