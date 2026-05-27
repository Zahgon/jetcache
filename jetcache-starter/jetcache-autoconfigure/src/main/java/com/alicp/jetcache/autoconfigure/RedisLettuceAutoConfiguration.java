package com.alicp.jetcache.autoconfigure;

import com.alicp.jetcache.CacheBuilder;
import com.alicp.jetcache.CacheConfigException;
import com.alicp.jetcache.anno.CacheConsts;
import com.alicp.jetcache.external.ExternalCacheBuilder;
import com.alicp.jetcache.redis.lettuce.JetCacheCodec;
import com.alicp.jetcache.redis.lettuce.LettuceConnectionManager;
import com.alicp.jetcache.redis.lettuce.RedisLettuceCacheBuilder;
import io.lettuce.core.AbstractRedisClient;
import io.lettuce.core.ClientOptions;
import io.lettuce.core.ReadFrom;
import io.lettuce.core.RedisClient;
import io.lettuce.core.RedisURI;
import io.lettuce.core.api.StatefulConnection;
import io.lettuce.core.cluster.ClusterClientOptions;
import io.lettuce.core.cluster.ClusterTopologyRefreshOptions;
import io.lettuce.core.cluster.RedisClusterClient;
import io.lettuce.core.cluster.api.StatefulRedisClusterConnection;
import io.lettuce.core.masterreplica.MasterReplica;
import io.lettuce.core.masterreplica.StatefulRedisMasterReplicaConnection;
import io.lettuce.core.pubsub.StatefulRedisPubSubConnection;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import java.net.URI;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created on 2017/5/10.
 *
 * @author huangli
 */
@Configuration
@Conditional(RedisLettuceAutoConfiguration.RedisLettuceCondition.class)
public class RedisLettuceAutoConfiguration {

    public static final String AUTO_INIT_BEAN_NAME = "redisLettuceAutoInit";

    public static class RedisLettuceCondition extends JetCacheCondition {

        public RedisLettuceCondition() {
            super("redis.lettuce");
        }
    }

    @Bean(name = { AUTO_INIT_BEAN_NAME })
    public RedisLettuceAutoInit redisLettuceAutoInit() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static class RedisLettuceAutoInit extends ExternalCacheAutoInit {

        public RedisLettuceAutoInit() {
            super("redis.lettuce");
        }

        @Override
        protected CacheBuilder initCache(ConfigTree ct, String cacheAreaWithPrefix) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        private StatefulConnection<byte[], byte[]> clusterConnection(ConfigTree ct, ReadFrom readFrom, RedisClusterClient client, boolean pubsub) {
            int enablePeriodicRefresh = ct.getProperty("enablePeriodicRefresh", 60);
            boolean enableAllAdaptiveRefreshTriggers = ct.getProperty("enableAllAdaptiveRefreshTriggers", true);
            ClusterTopologyRefreshOptions.Builder topologyOptionBuilder = ClusterTopologyRefreshOptions.builder();
            if (enablePeriodicRefresh > 0) {
                topologyOptionBuilder.enablePeriodicRefresh(Duration.ofSeconds(enablePeriodicRefresh));
            }
            if (enableAllAdaptiveRefreshTriggers) {
                topologyOptionBuilder.enableAllAdaptiveRefreshTriggers();
            }
            ClusterClientOptions options = ClusterClientOptions.builder().topologyRefreshOptions(topologyOptionBuilder.build()).disconnectedBehavior(ClientOptions.DisconnectedBehavior.REJECT_COMMANDS).build();
            client.setOptions(options);
            if (pubsub) {
                return client.connectPubSub(new JetCacheCodec());
            } else {
                StatefulRedisClusterConnection<byte[], byte[]> c = client.connect(new JetCacheCodec());
                if (readFrom != null) {
                    c.setReadFrom(readFrom);
                }
                return c;
            }
        }
    }
}
