package com.wk.netty.demo.common.codec;

import com.alibaba.fastjson.JSON;
import com.wk.netty.demo.common.dispatcher.Message;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 通信协议的消息体
 * @author wangkang
 * @Date 2021/12/3 14:40
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Invocation {

    /**
     * 类型
     */
    private String type;

    /**
     * 消息 JSON
     */
    private String message;

    public Invocation(String type, Message message) {
        this.type = type;
        this.message = JSON.toJSONString(message);
    }
}
