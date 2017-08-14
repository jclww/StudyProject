package com.lww.ledis.commands;

import java.util.List;

/**
 * Created by lenovo on 2017/8/2.
 */
public interface StringCommands {
    /**
     * String(字符串)
     */
    public Long append(final String key, final String value);

//    public void bitcount(final String key);
//
//    public void bitcount(final String key, long start, long end);
//
//    public void bitop(BitOP op, final String destKey, String... srcKeys);
    public Long decrBy(final String key, final long integer);

    public Long decr(final String key);

    public String get(final String key);

    public String getrange(String key, long startOffset, long endOffset);

    public String getSet(final String key, final String value);

    public Long incrBy(final String key, final long integer);

    public Double incrByFloat(final String key, final double value);

    public Long incr(final String key);

    public List<String> mget(final String... keys);

    public String mset(final String... keysvalues);

    public Long msetnx(final String... keysvalues);

    public String set(final String key, final String value);

    public String setex(final String key, final int seconds, final String value);

    public Long setnx(final String key, final String value);

    public Long setrange(String key, long offset, String value);

    public Long strlen(final String key);
}
