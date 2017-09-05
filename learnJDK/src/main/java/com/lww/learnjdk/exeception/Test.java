package com.lww.learnjdk.exeception;

/**
 * Created by Lww on 2017/9/4.
 */
public class Test {
    public static void main(String[] args) {

        System.out.println(s());
    }
    public static String s(){
        try {
            int a = 5/0;
        } catch (Exception e) {
            return "ccc";
        }
        System.out.println("aa");
        return "bbb";
    }
}
