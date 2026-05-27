package com.alicp.jetcache.anno.support;

import com.alicp.jetcache.CacheBuilder;
import com.alicp.jetcache.CacheManager;
import com.alicp.jetcache.embedded.EmbeddedCacheBuilder;
import com.alicp.jetcache.external.ExternalCacheBuilder;
import com.alicp.jetcache.support.AbstractLifecycle;
import com.alicp.jetcache.support.DecodeFilter;
import com.alicp.jetcache.support.StatInfo;
import com.alicp.jetcache.support.StatInfoLogger;
import com.alicp.jetcache.template.CacheBuilderTemplate;
import com.alicp.jetcache.template.CacheMonitorInstaller;
import com.alicp.jetcache.template.MetricsMonitorInstaller;
import com.alicp.jetcache.template.NotifyMonitorInstaller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.time.Duration;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Created on 2016/11/29.
 *
 * @author huangli
 */
public class ConfigProvider extends AbstractLifecycle {

    private static final Logger logger = LoggerFactory.getLogger(ConfigProvider.class);

    protected GlobalCacheConfig globalCacheConfig;

    protected EncoderParser encoderParser;

    protected KeyConvertorParser keyConvertorParser;

    private Consumer<StatInfo> metricsCallback;

    private CacheBuilderTemplate cacheBuilderTemplate;

    public ConfigProvider() {
        encoderParser = new DefaultEncoderParser();
        keyConvertorParser = new DefaultKeyConvertorParser();
        metricsCallback = new StatInfoLogger(false);
    }

    @Override
    protected void doInit() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected void initCacheMonitorInstallers() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private void initDecodeFilter() {
        DecodeFilter f = DecodeFilter.getDefault();
        f.setEnabled(globalCacheConfig.isDecodeFilterEnabled());
        List<String> allowPatterns = globalCacheConfig.getDecodeFilterAllowPatterns();
        if (allowPatterns != null && !allowPatterns.isEmpty()) {
            f.addAllowPatterns(allowPatterns.toArray(new String[0]));
        }
        List<String> denyPatterns = globalCacheConfig.getDecodeFilterDenyPatterns();
        if (denyPatterns != null && !denyPatterns.isEmpty()) {
            f.addDenyPatterns(denyPatterns.toArray(new String[0]));
        }
    }

    protected CacheMonitorInstaller metricsMonitorInstaller() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected CacheMonitorInstaller notifyMonitorInstaller() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public CacheBuilderTemplate getCacheBuilderTemplate() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void doShutdown() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Keep this method for backward compatibility.
     * NOTICE: there is no getter for encoderParser.
     */
    public Function<Object, byte[]> parseValueEncoder(String valueEncoder) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Keep this method for backward compatibility.
     * NOTICE: there is no getter for encoderParser.
     */
    public Function<byte[], Object> parseValueDecoder(String valueDecoder) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Keep this method for backward compatibility.
     * NOTICE: there is no getter for keyConvertorParser.
     */
    public Function<Object, Object> parseKeyConvertor(String convertor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public CacheNameGenerator createCacheNameGenerator(String[] hiddenPackages) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public CacheContext newContext(CacheManager cacheManager) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setEncoderParser(EncoderParser encoderParser) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setKeyConvertorParser(KeyConvertorParser keyConvertorParser) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public GlobalCacheConfig getGlobalCacheConfig() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setGlobalCacheConfig(GlobalCacheConfig globalCacheConfig) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setMetricsCallback(Consumer<StatInfo> metricsCallback) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
