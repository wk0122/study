package com.wk.netty.demo.server.message.heartbeat;

import com.wk.netty.demo.common.dispatcher.Message;

/**
 * @author wangkang
 * @Date 2021/12/3 17:59
 */
public class HeartbeatResponse implements Message {

    /**
     * 类型 - 心跳响应
     */
    public static final String TYPE = "HEARTBEAT_RESPONSE";

    @Override
    public String toString() {
        return "HeartbeatResponse{}";
    }

}
