package com.lww.learnjdk.classInfo;

/**
 * Created by Lww on 2017/8/24.
 */
public class Test {
    public static void main(String[] a) {
        B bb = new B();
        bb.setA("aa");
        bb.setC("c");
        A aa = bb;
        aa.setA("a");
        aa.setB("bhh");

        System.out.println(bb.getA()+"  "+aa.getA());
    }
}
