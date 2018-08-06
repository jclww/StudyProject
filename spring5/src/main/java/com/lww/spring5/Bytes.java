package com.lww.spring5;

import java.security.MessageDigest;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Bytes {
    private static final String C64 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=";
    private static final char[] BASE16 = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static final char[] BASE64 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=".toCharArray();
    private static final int MASK4 = 15;
    private static final int MASK6 = 63;
    private static final int MASK8 = 255;
    private static final Map<Integer, byte[]> DECODE_TABLE_MAP = new ConcurrentHashMap();
    private static ThreadLocal<MessageDigest> MD = new ThreadLocal();

    public static byte[] copyOf(byte[] src, int length) {
        byte[] dest = new byte[length];
        System.arraycopy(src, 0, dest, 0, Math.min(src.length, length));
        return dest;
    }

    public static byte[] short2bytes(short v) {
        byte[] ret = new byte[]{0, 0};
        short2bytes(v, ret);
        return ret;
    }

    public static void short2bytes(short v, byte[] b) {
        short2bytes(v, b, 0);
    }

    public static void short2bytes(short v, byte[] b, int off) {
        b[off + 1] = (byte) v;
        b[off + 0] = (byte) (v >>> 8);
    }
}