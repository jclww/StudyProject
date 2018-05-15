package com.lww;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Charsets;
import com.google.common.hash.Hashing;

import java.lang.reflect.Array;
import java.security.MessageDigest;
import java.security.MessageDigestSpi;
import java.util.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
//        System.out.println( "Hello World!" );
//        for (int i = 0; i < 10; i++) {
//            String uuid = UUID.randomUUID().toString().replaceAll("-", "");
//            System.out.println(uuid);
//        }
        List<String> list = new ArrayList<>();
        list.add("ass");
        list.add("qqq");
        Set<String> roleSet = new HashSet<>(list);
        System.out.println(JSON.toJSONString(roleSet));
        System.out.println(JSON.toJSONString(list));


        List<String> list1 = Arrays.asList("sales_business_operation","kf_business_operation");
        List<String> list2 = Arrays.asList("[\"sales_business_operation\",\"kf_business_operation\"]");
        System.out.println(JSON.toJSONString(list1));
        System.out.println(JSON.toJSONString(list2));


//        String pwd = "21312sadwqhjpokmjjbhjkamsnqhgduhjqikwmenwqheqkweqjwoik3131";
//        String md = Hashing.md5().hashString(pwd, Charsets.UTF_8).toString()/*.newHasher().putString(pwd, Charsets.UTF_8).hash().toString()*/;
//        System.out.println(md+"\t"+md.length());
        long time =  1523991123000L;
        long time2 = 1523944727206L;
        long time3 = 1523945294000L;
        Date date = new Date(time);
        System.out.println(date.toLocaleString());
        System.out.println(System.currentTimeMillis());

    }
}
