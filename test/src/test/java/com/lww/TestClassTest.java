package com.lww;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestClassTest {

    @Test
    public void count() throws Exception {
        TestClass testClass = new TestClass();
        testClass.count(1);
        testClass.count(2);
    }

}