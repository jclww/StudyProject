package com.lww.ledis.global;

import com.lww.ledis.util.SafeEncoder;

/**
 * Created by lenovo on 2017/8/2.
 */
public class GlobalValue {
    public static final byte[] BYTES_TRUE = toByteArray(1);
    public static final byte[] BYTES_FALSE = toByteArray(0);
    public static final byte[] toByteArray(final int value) {
        return SafeEncoder.encode(String.valueOf(value));
    }

    public static final String MASTER = "master";
    public static final String SLAVE = "slave";
}
