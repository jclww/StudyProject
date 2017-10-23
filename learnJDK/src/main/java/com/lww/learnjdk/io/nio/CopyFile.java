package com.lww.learnjdk.io.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by Lww on 2017/10/17.
 */
public class CopyFile {
    /**
     *  Bufffer
     *
     * mark <= position <= limit <= capacity
     *
     *  position    下一个可以操作的位置      初始为0
     *  limit       下一个不可操作位置       初始为数组长度
     *  capacity    数组总长度
     *  mark        用于记录当前position的前一个位置或者默认是0
     *
     *
     *  方法：
     *  flip()
     *      limit = position;
     *      position = 0;
     *      mark = -1;
     *  clear()
     *      position = 0;
     *      limit = capacity;
     *      mark = -1;
     *  compact()
     *      position = oldArr.length
     *      limit = capacity;
     *      mark = -1;
     *
     * 特殊注意
     *  new HeapByteBuffer在JVM堆上分配内存
     *  public static ByteBuffer allocate(int capacity)
     *  new DirectByteBuffer 在JVM直接内存分配 由FULL GC清理
     *  public static ByteBuffer allocateDirect(int capacity)
     */
    public static void main(String[] args) throws Exception {
        long begin = System.currentTimeMillis();
        String infile = "A:\\war\\test.zip";
        String outfile = "A:\\war\\2.zip";
        // 获取源文件和目标文件的输入输出流
        FileInputStream fin = new FileInputStream(infile);
        FileOutputStream fout = new FileOutputStream(outfile);
        // 获取输入输出通道
        FileChannel fcin = fin.getChannel();
        FileChannel fcout = fout.getChannel();
        // 创建缓冲区
        ByteBuffer buffer = ByteBuffer.allocateDirect(1024*1024*500);
        int r = fcin.read(buffer);
        while (r != -1) {
//            System.out.println("asd");
            // clear方法重设缓冲区，使它可以接受读入的数据
//            buffer.clear();
            // 从输入通道中将数据读到缓冲区
            // read方法返回读取的字节数，可能为零，如果该通道已到达流的末尾，则返回-1


            // flip方法让缓冲区可以将新读入的数据写入另一个通道
            buffer.flip();
            // 从输出通道中将数据写入缓冲区
            fcout.write(buffer);
            buffer.compact();
            r = fcin.read(buffer);
        }
        long end = System.currentTimeMillis();
        System.out.println("cost:"+ (end - begin));
//        cost:175817
//        cost:170104

    }
}
