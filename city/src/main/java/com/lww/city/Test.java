package com.lww.city;

/**
 * Created by Lww on 2017/8/28.
 */
public class Test {
    public static void main(String[] a) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.println(j);
                if (j == 3) {
                    break;
                }
            }
        }
        System.gc();
    }
}
