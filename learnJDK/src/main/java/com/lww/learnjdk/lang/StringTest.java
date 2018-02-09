package com.lww.learnjdk.lang;

import com.alibaba.fastjson.JSON;
import com.lww.learnjdk.Time.Date;

/**
 * Created by Lww on 2017/11/8.
 */
public class StringTest {
    private static final String RELEASE_REASON = "#%s#释放商机:%s - %s";

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

        java.util.Date date = new java.util.Date();
        Long dates = date.getTime();
        String str =  String.format(RELEASE_REASON, dates, "客户不需要","客户不需要");

        System.out.println(str);



        for (int month = 0; month < 12; month++) {
            switch (month) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    System.out.println(month + "月有31天");
                    break;
                case 4:
                case 6:
                case 9:
                case 11:
                    System.out.println(month + "月有30天");
                    break;
                default:
                    System.out.println(month + "月有28天");
            }
        }
    }
    /**
     * 释放商机时跟进记录文案
     * @param timeStamp
     * @param reason
     * @param context
     * @return
     */
    public static String buildReleaseReason(Long timeStamp, String reason, String context) {
        return String.format(RELEASE_REASON, timeStamp, reason, context);
    }
}
