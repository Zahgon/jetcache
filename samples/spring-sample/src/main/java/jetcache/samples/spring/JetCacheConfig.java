/**
 * Created on 2018/8/11.
 */
package jetcache.samples.spring;

import com.alicp.jetcache.anno.CacheConsts;
import com.alicp.jetcache.anno.config.EnableMethodCache;
import com.alicp.jetcache.anno.support.GlobalCacheConfig;
import com.alicp.jetcache.anno.support.JetCacheBaseBeans;
import com.alicp.jetcache.embedded.EmbeddedCacheBuilder;
import com.alicp.jetcache.embedded.LinkedHashMapCacheBuilder;
import com.alicp.jetcache.redis.RedisCacheBuilder;
import com.alicp.jetcache.support.Fastjson2KeyConvertor;
import com.alicp.jetcache.support.JavaValueDecoder;
import com.alicp.jetcache.support.JavaValueEncoder;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.util.Pool;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
@EnableMethodCache(basePackages = "jetcache.samples.spring")
@Import(JetCacheBaseBeans.class)
public class JetCacheConfig {

    @Bean
    public Pool<Jedis> pool() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Bean
    public GlobalCacheConfig config(Pool<Jedis> pool) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
