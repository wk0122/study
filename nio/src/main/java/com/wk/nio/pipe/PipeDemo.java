package com.wk.nio.pipe;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;

/**
 * @author wangkang
 * @Date 2022/3/15 13:38
 */
public class PipeDemo {

    public static void main(String[] args) throws IOException {
        //获取管道
        Pipe pipe = Pipe.open();

        //获取sink通道
        Pipe.SinkChannel sinkChannel = pipe.sink();

        //创建缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        byteBuffer.put("sdfsdf".getBytes());
        byteBuffer.flip();


        //写入sink
        sinkChannel.write(byteBuffer);


        //获取source通道
        Pipe.SourceChannel sourceChannel = pipe.source();

        byteBuffer.flip();

        int read = sourceChannel.read(byteBuffer);
        System.out.println(new String(byteBuffer.array(),0,read));
        sinkChannel.close();
        sourceChannel.close();

    }
}
