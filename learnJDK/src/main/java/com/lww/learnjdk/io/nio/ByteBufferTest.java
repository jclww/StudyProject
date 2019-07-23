package com.lww.learnjdk.io.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ByteBufferTest {
    public static void main(String[] args) throws IOException {
        RandomAccessFile aFile = new RandomAccessFile("/data/provider/check3.txt", "rw");
        FileChannel inChannel = aFile.getChannel();

        //create buffer with capacity of 48 bytes
        ByteBuffer buf = ByteBuffer.allocate(48);
        //read into buffer.
        int bytesRead = inChannel.read(buf);
        while (bytesRead != -1) {
            //make buffer ready for read
            buf.flip();
            while (buf.hasRemaining()) {
                // read 1 byte at a time
                System.out.print((char) buf.get());
            }

            buf.clear(); //make buffer ready for writing
            bytesRead = inChannel.read(buf);
        }
        aFile.close();
    }
}
