package com.wk.nio.channel;

import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.charset.Charset;

/**
 * @author wangkang
 * @Date 2022/3/11 16:02
 */
public class DatagramChannelDemo {

    @Test
    public void send() throws IOException, InterruptedException {
        DatagramChannel datagramChannel = DatagramChannel.open();
        InetSocketAddress inetSocketAddress = new InetSocketAddress("127.0.0.1", 9999);

        while (true){
            datagramChannel.send(ByteBuffer.wrap("我正在发送".getBytes("UTF-8")),inetSocketAddress);
            System.out.println("发送完成");
            Thread.sleep(2000);
        }

    }

    @Test
    public void recevie() throws IOException, InterruptedException {
        DatagramChannel datagramChannel = DatagramChannel.open();
        InetSocketAddress inetSocketAddress = new InetSocketAddress(9999);
        datagramChannel.bind(inetSocketAddress);

        ByteBuffer byteBuffer = ByteBuffer.allocate(64);

        while (true){
            byteBuffer.clear();
            SocketAddress socketAddress = datagramChannel.receive(byteBuffer);
            byteBuffer.flip();
            System.out.println(socketAddress.toString());
            System.out.println(Charset.forName("UTF-8").decode(byteBuffer));
            Thread.sleep(2000);
        }
    }
}
