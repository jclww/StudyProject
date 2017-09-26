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
    }
}
