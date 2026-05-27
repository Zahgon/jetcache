package com.alicp.jetcache.support;

import com.esotericsoftware.kryo.kryo5.Kryo;
import com.esotericsoftware.kryo.kryo5.KryoException;
import com.esotericsoftware.kryo.kryo5.Registration;
import com.esotericsoftware.kryo.kryo5.io.Input;
import com.esotericsoftware.kryo.kryo5.util.DefaultClassResolver;
import com.esotericsoftware.kryo.kryo5.util.IntMap;
import com.esotericsoftware.kryo.kryo5.util.ObjectMap;

/**
 * DecodeFilter-aware Kryo5 class resolver.
 * <p>
 * Filter check logic is in {@link KryoClassResolverUtil}.
 *
 * @author huangli
 */
class Kryo5ClassResolver extends DefaultClassResolver {

    private final DecodeFilter decodeFilter;

    public Kryo5ClassResolver(DecodeFilter decodeFilter) {
        this.decodeFilter = decodeFilter;
    }

    @Override
    public Registration readClass(Input input) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // Copied from DefaultClassResolver.readName() (Kryo 5.x, com.esotericsoftware.kryo:kryo5)
    // with filter check inserted after reading className string and after class loading.
    // If Kryo upgrades, this method must be reviewed for consistency.
    @Override
    protected Registration readName(Input input) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected Class<?> getTypeByName(String className) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
