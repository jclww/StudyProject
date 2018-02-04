package com.lww.test;

public class Bean {

    public int add(int a, int b){
        System.out.println("add func:"+(a+b));
        return a + b;
    }

    public int doub(int a) {
        System.out.println("doub func:"+(a<<1));
        return a << 1;
    }

}
