package com.wk.netty.demo.common.dispatcher;

import io.netty.channel.Channel;

/**
 * @author wangkang
 * @Date 2021/12/3 15:01
 */
public interface MessageHandler<T extends Message> {

    /**
     * 执行处理消息
     *
     * @param channel 通道
     * @param message 消息
     */
    void execute(Channel channel, T message);

    /**
     * @return 消息类型，即每个 Message 实现类上的 TYPE 静态字段
     */
    String getType();
}
