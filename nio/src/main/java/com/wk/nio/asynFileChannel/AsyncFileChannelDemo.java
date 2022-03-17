package com.wk.nio.asynFileChannel;

import org.junit.Test;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.Future;

/**
 * @author wangkang
 * @Date 2022/3/16 09:57
 */
public class AsyncFileChannelDemo {

    @Test
    public void test01() throws IOException {
        AsynchronousFileChannel asynchronousFileChannel = AsynchronousFileChannel.open(Paths.get("/Users/admin/study/nio/src/main/resources/1.txt"), StandardOpenOption.READ);

        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        Future<Integer> future = asynchronousFileChannel.read(byteBuffer, 0);

        while (!future.isDone());

        byteBuffer.flip();

        byte[] bytes = new byte[byteBuffer.limit()];
        byteBuffer.get(bytes);
        System.out.println(new String(bytes));
        byteBuffer.clear();
        asynchronousFileChannel.close();
    }

    @Test
    public void test02() throws IOException {
        AsynchronousFileChannel asynchronousFileChannel = AsynchronousFileChannel.open(Paths.get("/Users/admin/study/nio/src/main/resources/1.txt"), StandardOpenOption.READ);

        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        asynchronousFileChannel.read(byteBuffer, 0,byteBuffer, new CompletionHandler<Integer,ByteBuffer>() {

            @Override
            public void completed(Integer result, ByteBuffer attachment) {
                System.out.println(result);
                attachment.flip();

                byte[] bytes = new byte[attachment.limit()];
                attachment.get(bytes);
                System.out.println(new String(bytes));
                attachment.clear();

            }

            @Override
            public void failed(Throwable exc, ByteBuffer attachment) {

            }
        });

        asynchronousFileChannel.close();

    }
}
