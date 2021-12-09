package com.wk.netty.demo.server.server.handler;

import com.wk.netty.demo.common.codec.InvocationDecoder;
import com.wk.netty.demo.common.codec.InvocationEncoder;
import com.wk.netty.demo.common.dispatcher.MessageDispatcher;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.handler.timeout.ReadTimeoutHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author wangkang
 * @Date 2021/12/3 13:55
 */
@Component
public class NettyServerHandlerInitializer extends ChannelInitializer<Channel> {

    /**
     * 心跳超过时间
     */
    private static final Integer READ_TIMEOUT_SECONDS = 3*60;

    @Autowired
    private MessageDispatcher messageDispatcher;
    @Autowired
    private NettyServerHandler nettyServerHandler;

    /**
     * 初始化Channel时 自定义创建
     * @param channel
     * @throws Exception
     */
    @Override
    protected void initChannel(Channel channel) throws Exception {

        //获取 Channel 对应的 ChannelPipeline
        ChannelPipeline channelPipeline = channel.pipeline();
        //添加一些handler到 ChannelPipeline 中
        channelPipeline
                //空闲检测
                .addLast(new ReadTimeoutHandler(READ_TIMEOUT_SECONDS, TimeUnit.SECONDS))
                //编码器
                .addLast(new InvocationEncoder())
                //解码器
                .addLast(new InvocationDecoder())
                //消息分发器
                .addLast(messageDispatcher)
                //服务端处理器
                .addLast(nettyServerHandler);
    }
}
