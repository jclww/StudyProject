package com.hiveview.test;

import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by lenovo on 2017/8/9.
 */
public class GetKeys {
    public static void main(String[] a) {
        Jedis jedis= new Jedis("172.16.0.89",6379);
        jedis.auth("hiveview");
        Set<String> kes = jedis.keys("domyshop:*");//redis:test:key:8721*
        System.out.println(kes.size());
        for (String str : kes) {
            System.out.println(str);
        }
        List list = new ArrayList();
        for (String str : kes) {
            list.add(str.split(":"));
        }
    }
}
