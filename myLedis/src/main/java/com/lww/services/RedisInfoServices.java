package com.lww.services;

import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lenovo on 2017/7/31.
 */
public class RedisInfoServices {
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
                } finally {
                }
            }
        }
        return map;
    }
    public static Map<String,Object> getMemoryInfoAll(Jedis jedis) {
        System.out.println(jedis.getClient().getHost());
        String[] strs = jedis.info().split("\r\n");
        String[] detail;
        Map<String, Object> map = new HashMap<String, Object>();
        for (int i = 0; i < strs.length; i++) {
            String s = strs[i];
            if (s.contains(":"))
            {
                detail = s.split(":");
                if (isNum(detail[1])){
                    map.put(detail[0],Integer.parseInt(detail[1]));
                }
                else {
                    map.put(detail[0],detail[1]);
                }
            }
        }
        return map;
    }
    public static boolean isNum(String str){
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i)>'9' || str.charAt(i)<'0') {
                return false;
            }
        }
        return true;
    }

}
