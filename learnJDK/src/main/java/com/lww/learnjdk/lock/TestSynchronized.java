package com.lww.learnjdk.lock;

public class TestSynchronized {
    private String str = "str";
    private String str2 = "str";

    public synchronized String synObjectMethod() {
        return "synObjectMethod";
    }
    public static synchronized String synClassMethod() {
        return "synClassMethod";
    }

    public String synObjectValue() {
        synchronized (this) {
            int a = 1 + 1;
            return "synObjectValue";
        }
    }
    public String synClassValue() {
        synchronized (TestSynchronized.class) {
            return "synClassValue";
        }
    }

    public String synObjectVariable() {
        synchronized (str) {
            return "synObjectVariable";
        }
    }

}
