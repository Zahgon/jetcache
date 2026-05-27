package com.alicp.jetcache.redisson;

import com.alicp.jetcache.*;
import com.alicp.jetcache.external.AbstractExternalCache;
import com.alicp.jetcache.support.CacheEncodeException;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import org.redisson.api.RBatch;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.redisson.client.codec.ByteArrayCodec;
import org.redisson.client.codec.Codec;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

/**
 * Created on 2022/7/12.
 *
 * @author <a href="mailto:jeason1914@qq.com">yangyong</a>
 */
public class RedissonCache<K, V> extends AbstractExternalCache<K, V> {

    private final RedissonClient client;

    private final RedissonCacheConfig<K, V> config;

    private final Function<Object, byte[]> valueEncoder;

    private final Function<byte[], Object> valueDecoder;

    public RedissonCache(final RedissonCacheConfig<K, V> config) {
        super(config);
        this.config = config;
        this.client = config.getRedissonClient();
        this.valueEncoder = config.getValueEncoder();
        this.valueDecoder = config.getValueDecoder();
    }

    protected String getCacheKey(final K key) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public CacheConfig<K, V> config() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <T> T unwrap(final Class<T> clazz) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private Codec getCodec() {
        return ByteArrayCodec.INSTANCE;
    }

    private byte[] encoder(final CacheValueHolder<V> holder) {
        if (Objects.nonNull(holder)) {
            return valueEncoder.apply(holder);
        }
        return null;
    }

    @SuppressWarnings({ "unchecked" })
    private CacheValueHolder<V> decoder(final K key, final byte[] data, final int counter) {
        CacheValueHolder<V> holder = null;
        if (Objects.nonNull(data) && data.length > 0) {
            try {
                holder = (CacheValueHolder<V>) valueDecoder.apply(data);
            } catch (CacheEncodeException e) {
                holder = compatibleOldVal(key, data, counter + 1);
                if (Objects.isNull(holder)) {
                    logError("decoder", key, e);
                }
            } catch (Throwable e) {
                logError("decoder", key, e);
            }
        }
        return holder;
    }

    private CacheValueHolder<V> decoder(final K key, final byte[] data) {
        return decoder(key, data, 0);
    }

    private CacheValueHolder<V> compatibleOldVal(final K key, final byte[] data, final int counter) {
        if (Objects.nonNull(key) && Objects.nonNull(data) && data.length > 0 && counter <= 1) {
            try {
                final Codec codec = this.client.getConfig().getCodec();
                if (Objects.nonNull(codec)) {
                    final Class<?> cls = ByteArrayCodec.class;
                    if (codec.getClass() != cls) {
                        final ByteBuf in = ByteBufAllocator.DEFAULT.buffer().writeBytes(data);
                        final byte[] out = (byte[]) codec.getValueDecoder().decode(in, null);
                        return decoder(key, out, counter);
                    }
                }
            } catch (Throwable e) {
                logError("compatibleOldVal", key, e);
            }
        }
        return null;
    }

    @Override
    @SuppressWarnings({ "unchecked" })
    protected CacheGetResult<V> do_GET(final K key) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    @SuppressWarnings({ "unchecked" })
    protected MultiGetResult<K, V> do_GET_ALL(final Set<? extends K> keys) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected CacheResult do_PUT(final K key, final V value, final long expireAfterWrite, final TimeUnit timeUnit) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected CacheResult do_PUT_ALL(final Map<? extends K, ? extends V> map, final long expireAfterWrite, final TimeUnit timeUnit) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected CacheResult do_REMOVE(final K key) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected CacheResult do_REMOVE_ALL(final Set<? extends K> keys) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected CacheResult do_PUT_IF_ABSENT(final K key, final V value, final long expireAfterWrite, final TimeUnit timeUnit) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
