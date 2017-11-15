package com.lww.myLog.fastjson;

import com.alibaba.fastjson.JSON;

/**
 * Created by Lww on 2017/11/8.
 */
public class TestFastJson {
    public static void main(String[] args) {

        System.out.println(JSON.toJSONString(new D()));  // {"a":"a","d":"d"}

    }
}

class A {
    public int ia = 3;
    public String a = "a";
    private String a2 = "a2";
    public String gsda2 = "asda";
//
    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }
//
    public String getA2() {
        return a2;
    }

    public void setA2(String a2) {
        this.a2 = a2;
    }
}
interface B {
    public String b = "b";
}
interface C {
    String c = "c";

}
class D extends A implements B,C{
    public boolean bd = true;
    public float fd = (float) 3.5;
    public double dd = 3.3;

    public int[] iarr = new int[]{1,2,3};
    public String[] sarr = new String[]{"a","b","c"};
    public String d = "d";
    private String d2 = "d2";

    public E e = new E();
//    public String getD() {
//        return d;
//    }
//
//    public void setD(String d) {
//        this.d = d;
//    }
//
//    public String getD2() {
//        return d2;
//    }
//
//    public void setD2(String d2) {
//        this.d2 = d2;
//    }
}

class E {
    public String e = "E";
    public F f = new F();
}
class F {
    public String f = "F";
    private String ps = "PF";

    public String getPs() {
        return ps;
    }

    public void setPs(String ps) {
        this.ps = ps;
    }
}