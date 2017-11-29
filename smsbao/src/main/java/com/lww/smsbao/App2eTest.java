package com.lww.smsbao;


/**
 * Created by Lww on 2017/11/27.
 */
public class App2eTest {
    public static void main(String[] args) {
        SMSApp2e sms = new SMSApp2e();

        String str = sms.sendMessage("");
        System.out.println(str);

    }
}
