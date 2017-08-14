package com.lww.learnjdk;

/**
 * Created by lenovo on 2017/7/13.
 */
public class LearnString {
    public static void main(String[] a)
    {
        String str6 = "b";
        String str7 = "a" + str6;
        String str67 = "ab";
        System.out.println("str7 = str67 : "+ (str7 == str67));
        //↑str6为变量，在运行期才会被解析。
        final String str8 = "b";
        String str9 = "a" + str8;
        String str89 = "ab";
        System.out.println("str9 = str89 : "+ (str9 == str89));
    }


}
