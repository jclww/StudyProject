package com.lww.ledis.exception;

import redis.clients.jedis.exceptions.JedisDataException;

/**
 * Created by lenovo on 2017/7/27.
 */
public class LedisBusyException extends LedisDataException {

    private static final long serialVersionUID = 3992655220229243478L;

    public LedisBusyException(final String message) {
        super(message);
    }

    public LedisBusyException(final Throwable cause) {
        super(cause);
    }

    public LedisBusyException(final String message, final Throwable cause) {
        super(message, cause);
    }

}
