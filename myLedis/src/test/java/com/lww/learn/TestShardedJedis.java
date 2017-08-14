package com.lww.learn;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedis;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2017/8/9.
 */
public class TestShardedJedis {
    public static void main(String[] a) {
        List<JedisShardInfo> shards  = new ArrayList<JedisShardInfo>();
        JedisShardInfo jedisShardInfo = new JedisShardInfo("120.24.91.23",6379);
//        jedisShardInfo.n.
        jedisShardInfo.setPassword("lwwredis");

        JedisShardInfo jedisShardInfo2 = new JedisShardInfo("172.16.0.89",6379);
        jedisShardInfo2.setPassword("hiveview");
        shards.add(jedisShardInfo);
        shards.add(jedisShardInfo2);
        ShardedJedis sj = new ShardedJedis(shards);
        Jedis jedis = sj.getShard("SHARD-0-NODE-1");
        //如果JedisSharedInfo设置了name用下
//        Jedis jedis = sj.getShard("172.16.0.89*16");
//        sj.del("asda");
//        Jedis jedis2 = new Jedis("172.16.0.89",6379);
//        jedis2.auth("hiveview");
//        jedis.set("test:test:test1","asdsadasda");
//        sj.set("a","b");
    }
}
