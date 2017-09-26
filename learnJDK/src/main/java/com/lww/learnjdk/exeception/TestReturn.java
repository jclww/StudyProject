package com.lww.learnjdk.exeception;

import com.lww.learnjdk.classInfo.A;

/**
 * Created by Lww on 2017/9/14.
 */
public class TestReturn {
    public static int meth() {
        int a = 10;
        try {
            int b = a/0;
            return a;
        } catch (Exception e) {
            a = 1;
            return a;
        } finally {
            a = 20;
            return a;
        }
    }

    public static void main(String[] args) {
//        int ss = TestReturn.meth();
//        System.out.println(ss);
        B bb = TestReturn.meth2();
        System.out.println(bb.getA());
    }

    public static B meth2() {
        B b = new B();
        try {
            int a = 1/0;
            b.setA(1);
           return b;
        } catch (NullPointerException e) {
            b.setA(10);
            return b;
        } catch (Exception e) {
            b.setA(10);
            return b;
        }
        finally {
//            b.setA(20);
//            return a;
        }
    }
}
class B {
    int a;
    public void setA(int a ) {
        this.a = a;
    }
    public int getA() {
        return this.a;
    }
}