package com.lww.myLog.test.obj;

/**
 * @author: lenovo
 * @data: 2017/11/8
 * @description: TestClassA
 */
public class TestClassA {
    public int publicInt;
    public String publicString;
    private int privateInt;
    private String privateString;

    @Override
    public String toString() {
        return "TestClassA{" +
                "publicInt=" + publicInt +
                ", publicString='" + publicString + '\'' +
                ", privateInt=" + privateInt +
                ", privateString='" + privateString + '\'' +
                '}';
    }

    public int getPublicInt() {
        return publicInt;
    }

    public void setPublicInt(int publicInt) {
        this.publicInt = publicInt;
    }

    public String getPublicString() {
        return publicString;
    }

    public void setPublicString(String publicString) {
        this.publicString = publicString;
    }

    public int getPrivateInt() {
        return privateInt;
    }

    public void setPrivateInt(int privateInt) {
        this.privateInt = privateInt;
    }

    public String getPrivateString() {
        return privateString;
    }

    public void setPrivateString(String privateString) {
        this.privateString = privateString;
    }
}
