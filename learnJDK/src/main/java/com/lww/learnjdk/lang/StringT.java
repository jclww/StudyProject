package com.lww.learnjdk.lang;

import java.io.UnsupportedEncodingException;

/**
 * Created by Lww on 2017/9/28.
 */
public class StringT {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String charset_iso = "ISO8859-1";
        String charset_utf8 = "UTF-8";
        String charset_gbk = "GBK";
        String charset_gb2312 = "GB2312";

        String str = "中国；";
        String charN = "abcd123";

        byte[] b_gbk = str.getBytes(charset_gbk);
        byte[] b_utf8 = str.getBytes(charset_utf8);
        byte[] b_iso88591 = str.getBytes(charset_iso);
        byte[] b_gb2312 = str.getBytes(charset_gb2312);

        byte[] c_gbk = charN.getBytes(charset_gbk);
        byte[] c_utf8 = charN.getBytes(charset_utf8);
        byte[] c_iso88591 = charN.getBytes(charset_iso);
        byte[] c_gb2312 = charN.getBytes(charset_gb2312);


        System.out.println("s_gbk："+b_gbk.length+"字节");       //  6
        System.out.println("s_utf8："+b_utf8.length+"字节");     //  9
        System.out.println("s_iso："+b_iso88591.length+"字节");  //  3
        System.out.println("s_gb2312："+b_gb2312.length+"字节");  //  3


        System.out.println("c_gbk："+c_gbk.length+"字节");       //  6
        System.out.println("c_utf8："+c_utf8.length+"字节");     //  9
        System.out.println("c_iso："+c_iso88591.length+"字节");  //  3
        System.out.println("c_gb2312："+c_gb2312.length+"字节");  //  3
        /**
         * s_gbk： 6字节      中文占2个字节    2*8 = 16位
         * s_utf8：9字节      中文占3个字节    3*8 = 24位
         * s_iso： 3字节      字符占1个字节    1*8 =  8位   不存储中文    但可以乱码的存储byte数组
         * s_gb2312：6字节
         *
         * c_gbk： 7字节
         * c_utf8：7字节
         * c_iso： 7字节
         * c_gb2312：7字节
         */

        System.out.println("gbk："  + new String(b_gbk,charset_gbk));
        System.out.println("utf8：" + new String(b_utf8,charset_utf8));
        System.out.println("iso："  + new String(b_iso88591,charset_iso));
        /**
         * gbk：中国；
         * utf8：中国；
         * iso：???
         */


        /** ISO转码 由于ISO没有中文编码所以转utf->iso = ä¸­å½ï¼    iso -> utf = 中国；**/

        byte[] isoByte = str.getBytes("UTF-8");
        String isoStr = new String (isoByte,charset_iso);
        System.out.println(isoStr);
        String s_iso = new String(isoStr.getBytes(charset_iso),charset_utf8);
        System.out.println(s_iso);

        /** UTF-8转码 **/
        byte[] utfByte = str.getBytes("UTF-8");
        String utfStr = new String (isoByte,charset_utf8);
        System.out.println(utfStr);

//        String s = new String(isoByte);
        /** GBK转码 **/
        String gbkStr = new String (utfByte,charset_gbk);
        System.out.println("GBK转码："+gbkStr);    //涓浗锛�    由于utf-8占三个字节。而gbk只有两个错位了
        //正确
        byte[] gbkByte = str.getBytes(charset_gbk);
        gbkStr = new String (gbkByte,charset_gbk);
        System.out.println("GBK转码："+gbkStr);    //中国；

        /**
         * 转码只要能对应 相同的字节截取转码就好
         */

    }
}
