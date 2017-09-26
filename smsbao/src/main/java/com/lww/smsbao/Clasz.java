package com.lww.smsbao;

/**
 * Created by Lww on 2017/9/12.
 */
public class Clasz extends AbstractClass {
    @Override
    public void m() {
        System.out.println("Classz");
    }

    public static void main(String[] args) {
        AbstractClass cl = new Clasz();
        System.out.println(-1*70);
        cl.m2();
    }
}
