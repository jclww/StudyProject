package com.lww.myLog.test;

import com.alibaba.fastjson.JSON;
import com.lww.myLog.log.print.Print;
import com.lww.myLog.test.obj.TestClassA;
import com.lww.myLog.test.obj.TestClassB;

/**
 * Created by Lww on 2017/11/8.
 */
public class Test1 {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        TestClassB b = new TestClassB();
        b.setbInt(1);
        b.setbString("bString");
        b.setPrivateInt(2);
        b.setPrivateString("aString");
        Print.print(b);
        System.out.println(JSON.toJSONString(b));

        System.out.println(JSON.toJSONString("123"));
        Print.print(1);
    }
}

