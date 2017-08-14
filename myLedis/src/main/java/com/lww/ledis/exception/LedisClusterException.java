package com.lww.ledis.exception;

import redis.clients.jedis.exceptions.JedisDataException;

/**
 * Created by lenovo on 2017/7/27.
 */
public class LedisClusterException extends LedisDataException {
    private static final long serialVersionUID = 3878126572474819403L;

    public LedisClusterException(Throwable cause) {
        super(cause);
    }

    public LedisClusterException(String message, Throwable cause) {
        super(message, cause);
    }

    public LedisClusterException(String message) {
        super(message);
    }
}
