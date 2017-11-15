package com.lww.learnjdk.lang;

import com.alibaba.fastjson.JSON;

/**
 * Created by Lww on 2017/11/8.
 */
public class StringTest {
    public static void main(String[] args) {
        String a = "a";
        String b = "b";

        String a2 = new String("a");
        String b2 = new String("b");

        String c = a+"b";
        String c2 = a2+"b";
        String c3 = a+ b;

        System.out.println(c == c2);
        System.out.println("a"+"b" == "ab");
        System.out.println(c == c3);
        System.out.println(c3 == c2);

        System.out.println("abcd".substring(2));
        JSON.toJSONString("asds");
//        false
//        true
//        false
//        false

        StringBuilder sb = new StringBuilder();
        String s = null;
        sb.append(s);
        System.out.println(sb);
    }
}
