package com.lww.learnguava;

import com.google.common.collect.ImmutableMap;
import com.google.thirdparty.publicsuffix.PublicSuffixPatterns;
import com.google.thirdparty.publicsuffix.PublicSuffixType;

public class TestGuava {
    public static void main(String[] args) {
        ImmutableMap<String, PublicSuffixType> map = PublicSuffixPatterns.EXACT;

        System.out.println(map.toString());
    }
}
