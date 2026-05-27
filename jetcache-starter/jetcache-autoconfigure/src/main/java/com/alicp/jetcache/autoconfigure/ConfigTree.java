package com.alicp.jetcache.autoconfigure;

import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.EnumerablePropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.util.Assert;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created on 2017/11/20.
 *
 * @author huangli
 */
public class ConfigTree {

    private ConfigurableEnvironment environment;

    private String prefix;

    public ConfigTree(ConfigurableEnvironment environment, String prefix) {
        Assert.notNull(environment, "environment is required");
        Assert.notNull(prefix, "prefix is required");
        this.environment = environment;
        this.prefix = prefix;
    }

    public ConfigTree subTree(String prefix) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private String fullPrefixOrKey(String prefixOrKey) {
        return this.prefix + prefixOrKey;
    }

    public Map<String, Object> getProperties() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public boolean containsProperty(String key) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public String getProperty(String key) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public String getProperty(String key, String defaultValue) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public boolean getProperty(String key, boolean defaultValue) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public int getProperty(String key, int defaultValue) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public long getProperty(String key, long defaultValue) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public String getPrefix() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Set<String> directChildrenKeys() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
