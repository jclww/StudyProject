package com.lww.jvm;

import java.io.IOException;
import java.lang.management.BufferPoolMXBean;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryUsage;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<BufferPoolMXBean> pools = ManagementFactory.getPlatformMXBeans(BufferPoolMXBean.class);
        for (BufferPoolMXBean pool : pools) {
            System.out.println(pool.getName());
            System.out.println(pool.getCount());
            System.out.println("memory used " + toMB(pool.getMemoryUsed()));
            System.out.println("total capacity" + toMB(pool.getTotalCapacity()));
            System.out.println();
        }
        MemoryUsage heapMemoryUsage = ManagementFactory.getMemoryMXBean().getHeapMemoryUsage();
        System.out.println("jvm.heap.init is " + (heapMemoryUsage.getInit()));
        System.out.println("jvm.heap.used is " + (heapMemoryUsage.getUsed()));
        System.out.println("jvm.heap.committed is " + (heapMemoryUsage.getCommitted()));
        System.out.println("jvm.heap.max is " + (heapMemoryUsage.getMax()));

        MemoryUsage nonHeapMemoryUsage = ManagementFactory.getMemoryMXBean().getNonHeapMemoryUsage();
        System.out.println("jvm.nonheap.init is " + (nonHeapMemoryUsage.getInit()));
        System.out.println("jvm.nonheap.used is " + (nonHeapMemoryUsage.getUsed()));
        System.out.println("jvm.nonheap.committed is " + (nonHeapMemoryUsage.getCommitted()));
        System.out.println("jvm.nonheap.max is " + (nonHeapMemoryUsage.getMax()));
        System.in.read();
    }
    private static String toMB(long init) {
        return (Long.valueOf(init).doubleValue() / (1024 * 1024)) + " MB";
    }
}
