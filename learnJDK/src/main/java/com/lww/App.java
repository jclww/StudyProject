package com.lww;

import com.google.common.base.Charsets;
import com.google.common.hash.Hashing;

import java.security.MessageDigest;
import java.security.MessageDigestSpi;
import java.util.UUID;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
//        System.out.println( "Hello World!" );
//        for (int i = 0; i < 10; i++) {
//            String uuid = UUID.randomUUID().toString().replaceAll("-", "");
//            System.out.println(uuid);
//        }

        String pwd = "21312sadwqhjpokmjjbhjkamsnqhgduhjqikwmenwqheqkweqjwoik3131";
        String md = Hashing.md5().hashString(pwd, Charsets.UTF_8).toString()/*.newHasher().putString(pwd, Charsets.UTF_8).hash().toString()*/;
        System.out.println(md+"\t"+md.length());


    }
}
