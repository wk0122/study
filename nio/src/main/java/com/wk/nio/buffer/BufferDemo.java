package com.wk.nio.buffer;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author wangkang
 * @Date 2022/3/14 14:15
 */
public class BufferDemo {

    //子缓冲区 缓冲区分片
    @Test
    public void test01(){
        ByteBuffer byteBuffer = ByteBuffer.allocate(10);
        for (int i = 0; i < byteBuffer.capacity(); i++) {
            byteBuffer.put((byte) i);
        }

        byteBuffer.position(3);
        byteBuffer.limit(7);
        ByteBuffer slice = byteBuffer.slice();
        for (int i = 0; i <slice.capacity() ; i++) {
            slice.put(i, (byte) (slice.get(i)*10));
        }

        byteBuffer.position(0);
        byteBuffer.limit(byteBuffer.capacity());
        for (int b = 0; b < byteBuffer.capacity() ; b++) {
            System.out.println(byteBuffer.get(b));
        }
    }

    //只读缓冲区
    @Test
    public void test02(){
        ByteBuffer byteBuffer = ByteBuffer.allocate(10);
        for (int i = 0; i < byteBuffer.capacity(); i++) {
            byteBuffer.put((byte) i);
        }

        ByteBuffer readOnlyBuffer = byteBuffer.asReadOnlyBuffer();


        for (int i = 0; i <byteBuffer.capacity() ; i++) {
            byteBuffer.put(i, (byte) (byteBuffer.get(i)*10));
        }

        readOnlyBuffer.position(0);
        readOnlyBuffer.limit(byteBuffer.capacity());

        while (readOnlyBuffer.hasRemaining()){
            System.out.println(readOnlyBuffer.get());
        }
    }

    //直接缓冲区
    @Test
    public void test03() throws IOException {
        FileInputStream fileInputStream = new FileInputStream(Thread.currentThread().getContextClassLoader().getResource("1.txt").getPath());
        FileChannel fileInputStreamChannel = fileInputStream.getChannel();

        FileOutputStream fileOutputStream = new FileOutputStream(Thread.currentThread().getContextClassLoader().getResource("2.txt").getPath());
        FileChannel fileOutputStreamChannel = fileOutputStream.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(1024);
        while (true){
            byteBuffer.clear();
            int read = fileInputStreamChannel.read(byteBuffer);
            if (read == -1){
                break;
            }

            byteBuffer.flip();
            fileOutputStreamChannel.write(byteBuffer);
        }
        fileInputStream.close();
        fileOutputStream.close();
    }
}
