package com.lww.ssm.test.mybatis;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by lenovo on 2017/7/10.
 */
public class TestTime {
    public static void main(String[] args) {
        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH:mm");
        String hehe = dateFormat.format((Long.parseLong("1501586850000")));
        System.out.println(hehe);



    }
}
