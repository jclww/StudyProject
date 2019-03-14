package com.lww.learnjdk.map;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class HashMapTest {
    public static void main(String[] args) {
        Map<Object, String> map = new HashMap<>(5);

        map.put("1", "2");
        map.put("1", "3");
        map.put(49, "4");

        System.out.println(map.toString());
        map.get("1");
        int a = 31 >>> 1;
        int b = 31 << 1;
        int c = 31 >> 1;

        ConcurrentMap<Object, String> concurrentMap = new ConcurrentHashMap<>(5);
        concurrentMap.put("1", "2");
        concurrentMap.put("1", "3");
        concurrentMap.put(49, "4");

        System.out.println(concurrentMap);
    }
}
