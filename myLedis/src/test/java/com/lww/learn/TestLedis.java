package com.lww.learn;

/**
 * Created by lenovo on 2017/7/27.
 */
public class TestLedis {
    public static void main(String[] a)
    {
//        BinaryClient bc = new BinaryClient("120.24.91.23",6379);
//        bc.setPassword("lwwredis");
//        bc.connect();
//        Jedis jedis = new Jedis("120.24.91.23",6379);
//        jedis.auth("lwwredis");
//        Ledis ledis = new Ledis("120.24.91.23",6379);
//        ledis.auth("lwwredis");
//        System.out.println(ledis.append("a","a"));
//        System.out.println(ledis.append("b","b"));
//        System.out.println(ledis.mset("t","datetime","u","inda"));

//        System.out.println(ledis.ping());
        int size = 9969664;
        double MB = 1024*1024;
        double x = size/MB;
//        String.format(x);
        System.out.println(size/MB);
    }
}
