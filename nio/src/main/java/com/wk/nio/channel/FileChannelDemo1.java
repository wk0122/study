package com.wk.nio.channel;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author wangkang
 * @Date 2022/3/11 10:40
 *
 * 读取数据
 */
public class FileChannelDemo1 {
    public static void main(String[] args) throws Exception {
        //创建FileChannel
        RandomAccessFile randomAccessFile = new RandomAccessFile(Thread.currentThread().getContextClassLoader().getResource("1.txt").getPath(), "rw");
        FileChannel channel = randomAccessFile.getChannel();

        //创建buffer
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        int read = channel.read(byteBuffer);
        while ( read != -1){
            System.out.println(read);

            //读写反转
            byteBuffer.flip();

            while (byteBuffer.hasRemaining()){
                System.out.println(byteBuffer.get());
            }
            byteBuffer.clear();
            read = channel.read(byteBuffer);
        }
        channel.close();
        randomAccessFile.close();
    }
}
