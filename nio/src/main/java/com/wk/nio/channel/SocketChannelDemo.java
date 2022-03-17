package com.wk.nio.channel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * @author wangkang
 * @Date 2022/3/11 15:43
 */
public class SocketChannelDemo {

    public static void main(String[] args) throws IOException {

        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("www.baidu.com",80));

        socketChannel.configureBlocking(false);

        ByteBuffer byteBuffer = ByteBuffer.allocate(16);
        socketChannel.write(byteBuffer);
        socketChannel.close();
        System.out.println("close");
    }
}
