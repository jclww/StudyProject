package com.lww.test.h2db;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

public class Test {
    public static void main(String[] args) {
        String str= "asdsadasd\"sdasda\"";
        System.out.println(str.contains("\\"));

        String s = JSON.toJSONString(str, SerializerFeature.DisableCheckSpecialChar);
        System.out.println(s);
    }

}
