package com.lww.learnjdk.reflection;

/**
 * @author: lenovo
 * @data: 2017/11/8
 * @description: TestClassB
 */
public class TestClassB extends TestClassA {
    public int bInt;
    private String bString;

    @Override
    public String toString() {
        System.out.println("TestClassB{" +
                "bInt=" + bInt +
                ", bString='" + bString + '\'' +
                '}');
        return "TestClassB{" +
                "bInt=" + bInt +
                ", bString='" + bString + '\'' +
                '}';
    }

    public int getbInt() {
        return bInt;
    }

    public void setbInt(int bInt) {
        this.bInt = bInt;
    }

    public String getbString() {
        return bString;
    }

    public void setbString(String bString) {
        this.bString = bString;
    }
}
