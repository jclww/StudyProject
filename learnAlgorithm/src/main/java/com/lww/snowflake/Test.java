package com.lww.snowflake;

/**
 * Created by Lww on 2017/10/23.
 */
public class Test {
    public static void main(String[] args) {
        SnowFlake snowFlake = new SnowFlake(2, 3);
        for (int i = 0; i < (1 << 2); i++) {
            System.out.println(snowFlake.nextId());
        }
        System.out.println(System.currentTimeMillis());
        /**
         * 491195215873
         */
        /**
         * 100528628466724865
         *
         */
        DomyID id = new DomyID(1,2);
        for (int i = 0; i < (1 << 2); i++) {
            System.out.println(id.nextId());
        }
    }
}
