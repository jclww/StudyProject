package com.lww.learnjdk.lang;

import java.io.UnsupportedEncodingException;

/**
 * Created by Lww on 2017/9/29.
 */
public class StringEncode {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String str = "asdadssnadiasndajsn按死的那是今年金卡十多年三大";
        String s1 = new String(str.getBytes("UTF-8"),"UTF-8");
        System.out.println(s1);
    }
}
