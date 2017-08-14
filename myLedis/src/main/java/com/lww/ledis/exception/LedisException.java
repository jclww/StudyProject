package com.lww.ledis.exception;

/**
 * Created by Lww on 2017/7/26.
 */
public class LedisException extends RuntimeException {
    private static final long serialVersionUID = -2946266495682282677L;

    public LedisException(String message) {
        super(message);
    }

    public LedisException(Throwable e) {
        super(e);
    }

    public LedisException(String message, Throwable cause) {
        super(message, cause);
    }
}