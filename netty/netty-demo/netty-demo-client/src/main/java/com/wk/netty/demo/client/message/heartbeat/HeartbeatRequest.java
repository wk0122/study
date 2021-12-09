package com.wk.netty.demo.client.message.heartbeat;

import com.wk.netty.demo.common.dispatcher.Message;

/**
 * @author wangkang
 * @Date 2021/12/3 17:58
 */
public class HeartbeatRequest implements Message {

    /**
     * 类型 - 心跳请求
     */
    public static final String TYPE = "HEARTBEAT_REQUEST";

    @Override
    public String toString() {
        return "HeartbeatRequest{}";
    }

}