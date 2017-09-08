package com.lww.learnjdk.instanceofT;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lww on 2017/9/6.
 */
public class TestInstanceof {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        System.out.println(list instanceof AbstractList);
    }
}
