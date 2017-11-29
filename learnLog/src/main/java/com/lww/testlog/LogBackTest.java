package com.lww.testlog;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Lww on 2017/9/6.
 */
public class LogBackTest {
    private static final Logger logger = LoggerFactory.getLogger(LogBackTest.class);
    public static void main(String[] args) {
//        int a = 'a';
        logger.debug("DEBUG TEST 这个地方输出DEBUG级别的日志");
        logger.info("INFO test 这个地方输出INFO级别的日志");
        logger.error("ERROR test 这个地方输出ERROR级别的日志");

//        if((!false || !false && !false && ! false)){
//            System.out.println("asda");
//        } else {
//            System.out.println("1111");
//        }
//        if ((!"1915".equals("0000") || !"19".equals("00")
//                && !"1915".equals("00")&& !"19".equals("00") )) {
//            System.out.println("1915");
//        }

//        if(false || falssa() && truee() && reaa() ) {
//            System.out.println("sdasda");
//        }

        method(1L);
    }

    private static boolean falssa() {
        System.out.println("asdasdasda");
        return false;
    }

    private static boolean reaa() {
        System.out.println("readas");
        return true;
    }

    private static boolean truee() {
        System.out.println("qwwqeq");
        return true;
    }
    private static void method(int i) {
        System.out.println("int:"+i);
    }
    private static void method(long i) {
        System.out.println("long:"+i);
    }

}
