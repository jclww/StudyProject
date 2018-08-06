package com.lww.spring5;

public class App {
    public static void main(String[] args) {
        System.out.println("Hello Spring5!");

        System.out.println(~2);
        System.out.println(~1);
        byte[] bytes = Bytes.short2bytes((short)-9541);

        System.out.println(bytesToHexString(bytes));
    }
    public static String bytesToHexString(byte[] bArray) {
        StringBuilder sb = new StringBuilder(bArray.length);
        String sTemp;
        for (int i = 0; i < bArray.length; i++) {
            sTemp = Integer.toHexString(0xFF & bArray[i]);
            if (sTemp.length() < 2) {
                sb.append(0);
            }
            sb.append(sTemp.toUpperCase());
        }
        return sb.toString();
    }


}
