package com.lww.ledis.global;


import com.lww.ledis.util.SafeEncoder;

/**
 * Created by lenovo on 2017/8/2.
 */
public enum GlobalPosition {
    BEFORE, AFTER;
    public final byte[] raw;

    private GlobalPosition() {
        raw = SafeEncoder.encode(name());
    }
}