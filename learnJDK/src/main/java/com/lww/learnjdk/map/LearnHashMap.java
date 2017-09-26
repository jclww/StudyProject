package com.lww.learnjdk.map;

import java.util.HashMap;

/**
 * Created by lenovo on 2017/7/10.
 */
public class LearnHashMap {
    public static void main(String[] a){
        HashMap hm = new HashMap();
        TestClass tc1 = new TestClass();
        TestClass tc2 = new TestClass();

        hm.put(20,20);
        hm.put(tc1,"2");
        hm.put(tc2,"1");
        hm.put(20,12);
        hm.get(tc2);
        System.out.println(hm.size());
        System.out.println(tc1.hashCode());
        System.out.println(tc2.hashCode());


    }
}
class TestClass{
    @Override
    public int hashCode() {
        return 20;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public int a =0;

}
