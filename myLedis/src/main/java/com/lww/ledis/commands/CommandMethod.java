package com.lww.ledis.commands;

import com.lww.ledis.global.GlobalPosition;

import java.util.Map;

/**
 * Created by lenovo on 2017/7/27.
 */
public interface CommandMethod {
    /**
     * Key（键）
     */
    public void del(final String... keys);   //删除一个及以上

    public void exists(final String key);    //判断是否存在key

    public void exists(final String... keys);//

    public void expire(final String key, final int seconds);    //key过期时间   s

    public void expireAt(final String key, final long unixTime);//           时间戳

    public void ttl(final String key);                          //返回存活时间   s

    public void keys(final String pattern);                     //返回存在的key

    public void move(final String key, final int dbIndex);

    public void persist(final String key);                      //移除key存活时间转为永久

    public void pttl(final String key);                          //返回存活时间   ms

    public void sort(final String key);

//    public void sort(final String key, final SortingParams sortingParameters);

    public void type(final String key);

    /**
     * String(字符串)
     */
    public void append(final String key, final String value);

//    public void bitcount(final String key);
//
//    public void bitcount(final String key, long start, long end);
//
//    public void bitop(BitOP op, final String destKey, String... srcKeys);
    public void decrBy(final String key, final long integer);

    public void decr(final String key);

    public void get(final String key);

    public void getrange(String key, long startOffset, long endOffset);

    public void getSet(final String key, final String value);

    public void incrBy(final String key, final long integer);

    public void incrByFloat(final String key, final double value);

    public void incr(final String key);

    public void mget(final String... keys);

    public void mset(final String... keysvalues);

    public void msetnx(final String... keysvalues);

    public void set(final String key, final String value);

    public void setex(final String key, final int seconds, final String value);

    public void setnx(final String key, final String value);

    public void setrange(String key, long offset, String value);

    public void strlen(final String key);

    /**
     * Hash（哈希表）
     */
    public void hdel(final String key, final String... fields);

    public void hexists(final String key, final String field);

    public void hget(final String key, final String field);

    public void hgetAll(final String key);

    public void hincrBy(final String key, final String field, final long value);

    public void hincrByFloat(final String key, final String field, final double value);

    public void hkeys(final String key);

    public void hlen(final String key);

    public void hmset(final String key, final Map<String, String> hash);

    public void hmget(final String key, final String... fields);

    public void hset(final String key, final String field, final String value);

    public void hsetnx(final String key, final String field, final String value);

    public void hvals(final String key);

    /**
     * List(列表)
     */
    public void lindex(final String key, final long index);

    public void linsert(final String key, final GlobalPosition where, final String pivot, final String value);

    public void llen(final String key);

    public void lpop(final String key);

    public void lpush(final String key, final String... strings);

    public void lpushx(final String key, final String... string);

    public void lrange(final String key, final long start, final long end);

    public void lrem(final String key, final long count, final String value);

    public void lset(final String key, final long index, final String value);

    public void ltrim(final String key, final long start, final long end);

    public void rpop(final String key);

    public void rpoplpush(final String srckey, final String dstkey);

    public void rpush(final String key, final String... strings);

    public void rpushx(final String key, final String... string);

    /**
     * Set(集合)
     */
    public void sadd(final String key, final String... members);

    public void scard(final String key);

    public void sdiff(final String... keys);

    public void sdiffstore(final String dstkey, final String... keys);

    public void sinter(final String... keys);

    public void sinterstore(final String dstkey, final String... keys);

    public void sismember(final String key, final String member);

    public void smembers(final String key);

    public void smove(final String srckey, final String dstkey, final String member);

    public void spop(final String key);

    public void spop(final String key, final long count);

    public void srandmember(final String key);

    public void srem(final String key, final String... member);

    public void sunion(final String... keys);

    public void sunionstore(final String dstkey, final String... keys);

    /**
     * SortedSet（有序集合）
     */


    /**
     * Pub/Sub（发布/订阅）
     */


    /**
     * Transaction（事务）
     */

    public void discard();

    public void exec();

    public void multi();

    public void watch(final String... keys);

    /**
     * Connection（连接）
     */

}
