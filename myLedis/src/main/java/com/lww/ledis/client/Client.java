package com.lww.ledis.client;

import com.lww.ledis.commands.CommandMethod;
import com.lww.ledis.global.GlobalPosition;
import com.lww.ledis.util.SafeEncoder;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocketFactory;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Created by lenovo on 2017/7/27.
 */
public class Client extends BinaryClient  implements CommandMethod {

    public Client() {
        super();
    }

    public Client(final String host) {
        super(host);
    }

    public Client(final String host, final int port) {
        super(host, port);
    }

    public Client(final String host, final int port, final boolean ssl) {
        super(host, port, ssl);
    }

    public Client(final String host, final int port, final boolean ssl,
                  final SSLSocketFactory sslSocketFactory, final SSLParameters sslParameters,
                  final HostnameVerifier hostnameVerifier) {
        super(host, port, ssl, sslSocketFactory, sslParameters, hostnameVerifier);
    }


    /**
     * CommandMethod
     */
    public void set(final String key,final String value) {
        set(SafeEncoder.encode(key), SafeEncoder.encode(value));

    }


    public void exists(final String key) {
        exists(SafeEncoder.encode(key));
    }

    public void exists(final String... keys) {
        final byte[][] bkeys = SafeEncoder.encodeMany(keys);
        exists(bkeys);
    }

    public void del(final String... keys) {
        final byte[][] bkeys = new byte[keys.length][];
        for (int i = 0; i < keys.length; i++) {
            bkeys[i] = SafeEncoder.encode(keys[i]);
        }
        del(bkeys);
    }

    public void type(final String key) {
        type(SafeEncoder.encode(key));
    }

    public void keys(final String pattern) {
        keys(SafeEncoder.encode(pattern));
    }


    public void expire(final String key, final int seconds) {
        expire(SafeEncoder.encode(key), seconds);
    }

    public void expireAt(final String key, final long unixTime) {
        expireAt(SafeEncoder.encode(key), unixTime);
    }

    public void ttl(final String key) {
        ttl(SafeEncoder.encode(key));
    }

    public void move(final String key, final int dbIndex) {
        move(SafeEncoder.encode(key), dbIndex);
    }

    public void persist(final String key) {
        persist(SafeEncoder.encode(key));
    }


    public void getSet(final String key, final String value) {
        getSet(SafeEncoder.encode(key), SafeEncoder.encode(value));
    }

    public void mget(final String... keys) {
        final byte[][] bkeys = new byte[keys.length][];
        for (int i = 0; i < bkeys.length; i++) {
            bkeys[i] = SafeEncoder.encode(keys[i]);
        }
        mget(bkeys);
    }

    public void setnx(final String key, final String value) {
        setnx(SafeEncoder.encode(key), SafeEncoder.encode(value));
    }

    public void setrange(String key, long offset, String value) {
        setrange(SafeEncoder.encode(key), offset, SafeEncoder.encode(value));
    }

    public void strlen(final String key) {
        strlen(SafeEncoder.encode(key));
    }


    public void setex(final String key, final int seconds, final String value) {
        setex(SafeEncoder.encode(key), seconds, SafeEncoder.encode(value));
    }

    public void mset(final String... keysvalues) {
        final byte[][] bkeysvalues = new byte[keysvalues.length][];
        for (int i = 0; i < keysvalues.length; i++) {
            bkeysvalues[i] = SafeEncoder.encode(keysvalues[i]);
        }
        mset(bkeysvalues);
    }

    public void msetnx(final String... keysvalues) {
        final byte[][] bkeysvalues = new byte[keysvalues.length][];
        for (int i = 0; i < keysvalues.length; i++) {
            bkeysvalues[i] = SafeEncoder.encode(keysvalues[i]);
        }
        msetnx(bkeysvalues);
    }

    public void decrBy(final String key, final long integer) {
        decrBy(SafeEncoder.encode(key), integer);
    }

    public void decr(final String key) {
        decr(SafeEncoder.encode(key));
    }

    public void get(final String key) {
        get(SafeEncoder.encode(key));
    }


    public void getrange(String key, long startOffset, long endOffset) {
        getrange(SafeEncoder.encode(key), startOffset, endOffset);

    }

    public void incrBy(final String key, final long integer) {
        incrBy(SafeEncoder.encode(key), integer);
    }

    public void incrByFloat(final String key, final double increment) {
        incrByFloat(SafeEncoder.encode(key), increment);
    }


    public void incr(final String key) {
        incr(SafeEncoder.encode(key));
    }

    public void append(final String key, final String value) {
        append(SafeEncoder.encode(key), SafeEncoder.encode(value));
    }

    public void hset(final String key, final String field, final String value) {
        hset(SafeEncoder.encode(key), SafeEncoder.encode(field), SafeEncoder.encode(value));
    }

    public void hget(final String key, final String field) {
        hget(SafeEncoder.encode(key), SafeEncoder.encode(field));
    }

    public void hsetnx(final String key, final String field, final String value) {
        hsetnx(SafeEncoder.encode(key), SafeEncoder.encode(field), SafeEncoder.encode(value));
    }

    public void hmset(final String key, final Map<String, String> hash) {
        final Map<byte[], byte[]> bhash = new HashMap<byte[], byte[]>(hash.size());
        for (final Entry<String, String> entry : hash.entrySet()) {
            bhash.put(SafeEncoder.encode(entry.getKey()), SafeEncoder.encode(entry.getValue()));
        }
        hmset(SafeEncoder.encode(key), bhash);
    }

    public void hmget(final String key, final String... fields) {
        final byte[][] bfields = new byte[fields.length][];
        for (int i = 0; i < bfields.length; i++) {
            bfields[i] = SafeEncoder.encode(fields[i]);
        }
        hmget(SafeEncoder.encode(key), bfields);
    }

    public void hincrBy(final String key, final String field, final long value) {
        hincrBy(SafeEncoder.encode(key), SafeEncoder.encode(field), value);
    }

    public void hincrByFloat(final String key, final String field, double increment) {
        hincrByFloat(SafeEncoder.encode(key), SafeEncoder.encode(field), increment);
    }

    public void hexists(final String key, final String field) {
        hexists(SafeEncoder.encode(key), SafeEncoder.encode(field));
    }

    public void hdel(final String key, final String... fields) {
        hdel(SafeEncoder.encode(key), SafeEncoder.encodeMany(fields));
    }

    public void hlen(final String key) {
        hlen(SafeEncoder.encode(key));
    }

    public void hkeys(final String key) {
        hkeys(SafeEncoder.encode(key));
    }

    public void hvals(final String key) {
        hvals(SafeEncoder.encode(key));
    }

    public void hgetAll(final String key) {
        hgetAll(SafeEncoder.encode(key));
    }

    public void rpush(final String key, final String... string) {
        rpush(SafeEncoder.encode(key), SafeEncoder.encodeMany(string));
    }

    public void rpushx(final String key, final String... string) {
        rpushx(SafeEncoder.encode(key), getByteParams(string));
    }

    public void lpush(final String key, final String... string) {
        lpush(SafeEncoder.encode(key), SafeEncoder.encodeMany(string));
    }

    public void lpushx(final String key, final String... string) {
        lpushx(SafeEncoder.encode(key), getByteParams(string));
    }

    public void llen(final String key) {
        llen(SafeEncoder.encode(key));
    }

    public void lrange(final String key, final long start, final long end) {
        lrange(SafeEncoder.encode(key), start, end);
    }

    public void ltrim(final String key, final long start, final long end) {
        ltrim(SafeEncoder.encode(key), start, end);
    }

    public void lindex(final String key, final long index) {
        lindex(SafeEncoder.encode(key), index);
    }

    public void linsert(final String key, final GlobalPosition where, final String pivot,
                        final String value) {
        linsert(SafeEncoder.encode(key), where, SafeEncoder.encode(pivot), SafeEncoder.encode(value));
    }

    public void lset(final String key, final long index, final String value) {
        lset(SafeEncoder.encode(key), index, SafeEncoder.encode(value));
    }

    public void lrem(final String key, long count, final String value) {
        lrem(SafeEncoder.encode(key), count, SafeEncoder.encode(value));
    }

    public void lpop(final String key) {
        lpop(SafeEncoder.encode(key));
    }

    public void rpop(final String key) {
        rpop(SafeEncoder.encode(key));
    }

    public void rpoplpush(final String srckey, final String dstkey) {
        rpoplpush(SafeEncoder.encode(srckey), SafeEncoder.encode(dstkey));
    }

    public void sadd(final String key, final String... members) {
        sadd(SafeEncoder.encode(key), SafeEncoder.encodeMany(members));
    }

    public void smembers(final String key) {
        smembers(SafeEncoder.encode(key));
    }

    public void srem(final String key, final String... members) {
        srem(SafeEncoder.encode(key), SafeEncoder.encodeMany(members));
    }

    public void sunion(final String... keys) {
        final byte[][] bkeys = new byte[keys.length][];
        for (int i = 0; i < bkeys.length; i++) {
            bkeys[i] = SafeEncoder.encode(keys[i]);
        }
        sunion(bkeys);
    }

    public void sunionstore(final String dstkey, final String... keys) {
        final byte[][] bkeys = new byte[keys.length][];
        for (int i = 0; i < bkeys.length; i++) {
            bkeys[i] = SafeEncoder.encode(keys[i]);
        }
        sunionstore(SafeEncoder.encode(dstkey), bkeys);
    }


    public void watch(final String... keys) {
        final byte[][] bargs = new byte[keys.length][];
        for (int i = 0; i < bargs.length; i++) {
            bargs[i] = SafeEncoder.encode(keys[i]);
        }
        watch(bargs);
    }

    public void spop(final String key) {
        spop(SafeEncoder.encode(key));
    }

    public void spop(final String key, final long count) {
        spop(SafeEncoder.encode(key), count);
    }

    public void srandmember(final String key) {
        srandmember(SafeEncoder.encode(key));
    }

    public void smove(final String srckey, final String dstkey, final String member) {
        smove(SafeEncoder.encode(srckey), SafeEncoder.encode(dstkey), SafeEncoder.encode(member));
    }

    public void scard(final String key) {
        scard(SafeEncoder.encode(key));
    }

    public void sdiff(final String... keys) {
        final byte[][] bkeys = new byte[keys.length][];
        for (int i = 0; i < bkeys.length; i++) {
            bkeys[i] = SafeEncoder.encode(keys[i]);
        }
        sdiff(bkeys);
    }

    public void sdiffstore(final String dstkey, final String... keys) {
        final byte[][] bkeys = new byte[keys.length][];
        for (int i = 0; i < bkeys.length; i++) {
            bkeys[i] = SafeEncoder.encode(keys[i]);
        }
        sdiffstore(SafeEncoder.encode(dstkey), bkeys);
    }

    public void sinter(final String... keys) {
        final byte[][] bkeys = new byte[keys.length][];
        for (int i = 0; i < bkeys.length; i++) {
            bkeys[i] = SafeEncoder.encode(keys[i]);
        }
        sinter(bkeys);
    }

    public void sinterstore(final String dstkey, final String... keys) {
        final byte[][] bkeys = new byte[keys.length][];
        for (int i = 0; i < bkeys.length; i++) {
            bkeys[i] = SafeEncoder.encode(keys[i]);
        }
        sinterstore(SafeEncoder.encode(dstkey), bkeys);
    }

    public void sismember(final String key, final String member) {
        sismember(SafeEncoder.encode(key), SafeEncoder.encode(member));
    }

    public void pttl(final String key) {
        pttl(SafeEncoder.encode(key));
    }

    public void sort(final String key) {
        sort(SafeEncoder.encode(key));
    }



    private byte[][] getByteParams(String... params) {
        byte[][] p = new byte[params.length][];
        for (int i = 0; i < params.length; i++)
            p[i] = SafeEncoder.encode(params[i]);

        return p;
    }


}
