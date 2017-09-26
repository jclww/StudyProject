package com.lww.learnjdk.map;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Lww on 2017/9/20.
 */
public class MapTest {
    public static void main(String[] args) {
        HashMap hashMap = new HashMap();
        hashMap.put("q","q");
        hashMap.put("w","w");
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        concurrentHashMap.put("Q","Q");
        concurrentHashMap.put("W","W");
        System.out.println(hashMap);
        System.out.println(concurrentHashMap);
    }
}
