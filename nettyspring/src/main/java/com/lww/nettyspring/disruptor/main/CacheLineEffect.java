package com.lww.nettyspring.disruptor.main;

public class CacheLineEffect {
    //考虑一般缓存行大小是64字节，一个 long 类型占8字节
    static  long[][] arr;

    public static void main(String[] args) {
        int x = 16  * 2;
        int y = 1024 * 1024;
        arr = new long[y][];
        for (int i = 0; i < y; i++) {
            arr[i] = new long[x];
            for (int j = 0; j < x; j++) {
                arr[i][j] = 0L;
            }
        }
        long sum = 0L;
        long marked = System.currentTimeMillis();
        for (int i = 0; i < y; i+=1) {
            for(int j =0; j< x;j++){
                sum = arr[i][j];
            }
        }
        System.out.println("Loop times:" + (System.currentTimeMillis() - marked) + "ms");

        marked = System.currentTimeMillis();
        for (int i = 0; i < x; i+=1) {
            for(int j =0; j< y;j++){
                sum = arr[j][i];
            }
        }
        System.out.println("Loop times:" + (System.currentTimeMillis() - marked) + "ms");
    }
}