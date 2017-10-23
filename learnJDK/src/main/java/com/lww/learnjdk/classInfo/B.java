package com.lww.learnjdk.classInfo;

/**
 * Created by Lww on 2017/8/24.
 */
public class B extends A {
    String c;

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

    @Override
    public String toString() {
        return "B{" +
                "c='" + c + '\'' +
                ", a='" + a + '\'' +
                ", b='" + b + '\'' +
                '}';
    }
}
