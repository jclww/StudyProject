package com.lww.learnjdk.thread;

import java.util.HashMap;
import java.util.Map;

public class ThreadLocalTest {
    public static final ThreadLocal<String> stringValue = new ThreadLocal<>();
    public static final ThreadLocal<Map<String, String>> mapValue = new ThreadLocal<>();
    static {
        mapValue.set(new HashMap<>());
    }

    public static void main(String[] args) {
        stringValue.set("test");
        mapValue.get().put("key", "value");

        System.out.println(stringValue.get());
        System.out.println(mapValue.get().get("key"));
        stringValue.remove();
        mapValue.remove();
    }
}
