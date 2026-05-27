/**
 * Created on 2018/8/11.
 */
package jetcache.samples.springboot;

import com.alicp.jetcache.anno.config.EnableMethodCache;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author huangli
 */
@SpringBootApplication
@EnableMethodCache(basePackages = "jetcache")
public class RedissonDemo {

    public static void main(String[] args) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
