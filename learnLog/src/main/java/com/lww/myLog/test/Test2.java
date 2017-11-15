package com.lww.myLog.test;

import com.alibaba.fastjson.JSON;
import com.lww.myLog.log.Print;
import com.lww.myLog.test.obj.TestClassB;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Lww on 2017/11/9.
 */
public class Test2 {
    public static void main(String[] args) {
//        String s = null;
//        System.out.println(Print.print(s));
//        System.out.println(JSON.toJSONString(s));

        TestClassB b = new TestClassB();
        b.setbInt(1);
        b.setbString("bString");
        b.setPrivateInt(2);
        b.setPrivateString("aString");
//        System.out.println(Print.print(b));
//        System.out.println(JSON.toJSONString(b));

        Map map = new HashMap();
        map.put("1","asda");
        map.put(2,b);
        b.map = map;
//        System.out.println(Print.print(map));
        System.out.println(JSON.toJSONString(map));


    }
}
