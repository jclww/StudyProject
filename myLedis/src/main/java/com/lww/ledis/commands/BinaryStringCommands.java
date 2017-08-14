package com.lww.ledis.commands;

import java.util.List;

/**
 * Created by lenovo on 2017/7/27.
 */
public interface BinaryStringCommands {
    Long append(byte[] key, byte[] value);

//    public void bitcount(final String key);
//
//    public void bitcount(final String key, long start, long end);
//
//    public void bitop(BitOP op, final String destKey, String... srcKeys);
    public Long decrBy(final byte[] key, final long integer);

    public Long decr(final byte[] key);

    public byte[] get(final byte[] key);

    public byte[] getrange(byte[] key, long startOffset, long endOffset);

    public byte[] getSet(final byte[] key, final byte[] value);

    public Long incrBy(final byte[] key, final long integer);

    public Double incrByFloat(final byte[] key, final double integer);

    public Long incr(final byte[] key);

    public List<byte[]> mget(final byte[]... keys);

    public String mset(final byte[]... keysvalues);

    public Long msetnx(final byte[]... keysvalues);

    public String set(final byte[] key, final byte[] value);

    public String setex(final byte[] key, final int seconds, final byte[] value);

    public Long setnx(final byte[] key, final byte[] value);

    public Long setrange(byte[] key, long offset, byte[] value);

    public Long strlen(final byte[] key);
}
