package com.wk.nio.channel;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

/**
 * @author wangkang
 * @Date 2022/3/11 14:15
 */
public class FileChannelDemo3 {
    public static void main(String[] args) throws Exception {
        //创建FileChannel
        RandomAccessFile aFile = new RandomAccessFile(Thread.currentThread().getContextClassLoader().getResource("1.txt").getPath(), "rw");
        FileChannel fromChannel = aFile.getChannel();

        //创建FileChannel
        RandomAccessFile bFile = new RandomAccessFile(Thread.currentThread().getContextClassLoader().getResource("2.txt").getPath(), "rw");
        FileChannel toChannel = bFile.getChannel();

        toChannel.transferFrom(fromChannel,0,fromChannel.size());
        aFile.close();
        bFile.close();
    }
}
