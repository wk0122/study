package com.wk.netty.demo.common.codec;

import com.alibaba.fastjson.JSON;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.CorruptedFrameException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @author wangkang
 * @Date 2021/12/3 14:41
 */
public class InvocationDecoder extends ByteToMessageDecoder {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        //标记当前读取的位置
        byteBuf.markReaderIndex();
        //判断是否能够读取 一个长度
        if (byteBuf.readableBytes() <= 4){
            return;
        }

        //读取长度
        int length = byteBuf.readInt();
        if (length < 0){
            throw new CorruptedFrameException("negative length: " + length);
        }

        //如果 message 不够可读 则退回到原来读取的位置
        if (byteBuf.readableBytes() < length){
            byteBuf.resetReaderIndex();
        }

        //读取内容
        byte[] content = new byte[length];
        byteBuf.readBytes(content);

        //解析成 Invocation
        Invocation invocation = JSON.parseObject(content,Invocation.class);
        list.add(invocation);
        logger.info("[decode][连接({}) 解析到一条消息({})]", channelHandlerContext.channel().id(), invocation.toString());
    }
}
