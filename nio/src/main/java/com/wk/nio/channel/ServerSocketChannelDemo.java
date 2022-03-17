package com.wk.nio.channel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * @author wangkang
 * @Date 2022/3/11 15:20
 */
public class ServerSocketChannelDemo {
    public static void main(String[] args) throws IOException, InterruptedException {

        int port = 8888;

        ByteBuffer byteBuffer = ByteBuffer.wrap("dddd".getBytes());

        try (ServerSocketChannel serverSocketChannel = ServerSocketChannel.open()) {

            serverSocketChannel.socket().bind(new InetSocketAddress(port));

            //设置非阻塞
            serverSocketChannel.configureBlocking(false);

            while (true){
                SocketChannel socketChannel = serverSocketChannel.accept();
                if (socketChannel == null){
                    System.out.println("null");
                    Thread.sleep(2000);
                }else {
                    System.out.println("connect success: " + socketChannel.getRemoteAddress().toString());
                    byteBuffer.rewind();
                    socketChannel.write(byteBuffer);
                    socketChannel.close();
                }
            }
        }
    }
}
