package com.wk.netty.demo.common.codec;

import com.alibaba.fastjson.JSON;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author wangkang
 * @Date 2021/12/3 14:55
 */
public class InvocationEncoder extends MessageToByteEncoder<Invocation> {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, Invocation invocation, ByteBuf byteBuf) throws Exception {
        //将Invocation 转换成byte[] 数组
        byte[] content = JSON.toJSONBytes(invocation);
        //写入length
        byteBuf.writeInt(content.length);
        //写入内容
        byteBuf.writeBytes(content);
        logger.info("[encode][连接({}) 编码了一条消息({})]", channelHandlerContext.channel().id(), invocation.toString());
    }
}
