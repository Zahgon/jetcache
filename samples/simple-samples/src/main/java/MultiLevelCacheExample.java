import com.alicp.jetcache.Cache;
import com.alicp.jetcache.MultiLevelCacheBuilder;
import com.alicp.jetcache.embedded.CaffeineCacheBuilder;
import com.alicp.jetcache.redis.RedisCacheBuilder;
import com.alicp.jetcache.support.Fastjson2KeyConvertor;
import com.alicp.jetcache.support.JavaValueDecoder;
import com.alicp.jetcache.support.JavaValueEncoder;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import redis.clients.jedis.JedisPool;
import java.util.concurrent.TimeUnit;

/**
 * Created on 2016/9/27.
 *
 * @author huangli
 */
public class MultiLevelCacheExample {

    public static void main(String[] args) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
