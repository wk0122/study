package com.wk.nio.channel;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author wangkang
 * @Date 2022/3/11 10:58
 *
 * 写数据
 */
public class FileChannelDemo2 {
    public static void main(String[] args) throws Exception {
        //创建FileChannel
        RandomAccessFile randomAccessFile = new RandomAccessFile(Thread.currentThread().getContextClassLoader().getResource("2.txt").getPath(), "rw");
        FileChannel channel = randomAccessFile.getChannel();

        //创建buffer
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        byteBuffer.clear();

        String data = "sssss";
        byteBuffer.put(data.getBytes());

        byteBuffer.flip();
        while (byteBuffer.hasRemaining()){
            channel.write(byteBuffer);
        }
        channel.close();
        randomAccessFile.close();
    }
}
