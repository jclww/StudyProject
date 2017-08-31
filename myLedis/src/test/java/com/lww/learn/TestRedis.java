package com.lww.learn;

import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lenovo on 2017/7/27.
 */
public class TestRedis {
    public static void main(String[] a)
    {
        Jedis jedis= new Jedis("172.16.0.89",6379);
        jedis.auth("hiveview");

//        String s = jedis.hget("redis:counts","172.16.0.89");

        System.out.println(jedis.info());

//        jedis.hincrBy("redis:counts","172.16.0.89",1);
//        System.out.println(jedis.hget("redis:counts","172.16.0.89"));

//        TestRedis.getMemoryInfo(jedis);
//        String key1 = jedis.get("key1");
//        jedis.set("keys",String.valueOf(66));
//        String memory_info = jedis.info();
//        Long dbsize = jedis.dbSize();
//        System.out.println(memory_info);
//        jedis.hgetAll("s");
//        Map map;
//        map = TestRedis.getMemoryInfo(jedis);
//        Map map2 = TestRedis.getMemoryInfoS(jedis);

//        map.put("ping_time",new Date());
//        map.put("ping_ip",jedis.getClient().getHost());
//        System.out.println(JSON.toJSONString(map));
//        System.out.println(map.size()+"\r\n"+map2.size());
//        System.out.println();
    }
    //获取当前redis使用内存大小情况
    public static Map<String,Object> getMemoryInfo(Jedis jedis) {
        System.out.println(jedis.getClient().getHost());
        String[] strs = jedis.info().split("\r\n");
        String[] detail;
        Map<String, Object> map = new HashMap<String, Object>();
        for (int i = 0; i < strs.length; i++) {
            String s = strs[i];
            if (s.contains(":"))
            {
                detail = s.split(":");
                try {
                    map.put(detail[0],Integer.parseInt(detail[1]));
                } catch (Exception e) {
//                    e.printStackTrace();
                } finally {
                }
            }
        }
        return map;
    }
    public static Map<String,Object> getMemoryInfoS(Jedis jedis) {
        System.out.println(jedis.getClient().getHost());
        String[] strs = jedis.info().split("\r\n");
        String[] detail;
        Map<String, Object> map = new HashMap<String, Object>();
        for (int i = 0; i < strs.length; i++) {
            String s = strs[i];

            if (s.contains(":"))
            {
                detail = s.split(":");
                    map.put(detail[0],detail[1]);
            }
        }
        return map;
    }
}
