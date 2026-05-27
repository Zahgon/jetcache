package com.alicp.jetcache.support;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputFilter;
import java.io.ObjectInputStream;

/**
 * Created on 2016/10/4.
 *
 * @author huangli
 */
public class JavaValueDecoder extends AbstractValueDecoder {

    public static final JavaValueDecoder INSTANCE = new JavaValueDecoder(true);

    public JavaValueDecoder(boolean useIdentityNumber) {
        super(useIdentityNumber);
    }

    @Override
    public Object doApply(byte[] buffer) throws Exception {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected ObjectInputStream buildObjectInputStream(ByteArrayInputStream in) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private void setFilter(ObjectInputStream ois) {
        if (!DecodeFilter.getDefault().isEnabled()) {
            return;
        }
        ObjectInputFilter filter = DecodeFilter::javaFilter;
        ObjectInputFilter existing = ois.getObjectInputFilter();
        if (existing != null) {
            ois.setObjectInputFilter(ObjectInputFilter.merge(existing, filter));
        } else {
            ois.setObjectInputFilter(filter);
        }
    }
}
