package com.lww.ledis.util;


import com.lww.ledis.exception.LedisDataException;
import com.lww.ledis.exception.LedisException;
import com.lww.ledis.protocol.RedisProtocol;

import java.io.UnsupportedEncodingException;

/**
 * Created by lenovo on 2017/7/27.
 */
public class SafeEncoder {
    private SafeEncoder(){
        throw new InstantiationError( "Must not instantiate this class" );
    }

    public static byte[][] encodeMany(final String... strs) {
        byte[][] many = new byte[strs.length][];
        for (int i = 0; i < strs.length; i++) {
            many[i] = encode(strs[i]);
        }
        return many;
    }

    public static byte[] encode(final String str) {
        try {
            if (str == null) {
                throw new LedisDataException("value sent to redis cannot be null");
            }
            return str.getBytes(RedisProtocol.CHARSET);
        } catch (UnsupportedEncodingException e) {
            throw new LedisException(e);
        }
    }

    public static String encode(final byte[] data) {
        try {
            return new String(data, RedisProtocol.CHARSET);
        } catch (UnsupportedEncodingException e) {
            throw new LedisException(e);
        }
    }
}
