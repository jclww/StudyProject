package com.lww.learnjdk.Time;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by lenovo on 2017/8/11.
 */
public class Date {
    public static void main(String[] a) {
        String timeStr = "2017-02-23";

        SimpleDateFormat formatter = new SimpleDateFormat(
                "yyyy-MM-dd");
        try {
            java.util.Date date = formatter.parse(timeStr);
            System.out.println(date);
            System.out.println(date.getTime());
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //        Date beginTime = null;
//        Date endTime = null;
//        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        try {
//            beginTime = formatter.parse(deliveryTrackerDto.getOrderTime()+" 00:00:00");
//            endTime = formatter.parse(deliveryTrackerDto.getOrderTime()+" 23:59:59");
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        if (Objects.isNull(beginTime)||Objects.isNull(endTime))
//            return null;
    }
}
