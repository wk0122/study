package com.wk.netty.demo.server.message.auth;

import com.wk.netty.demo.common.dispatcher.Message;
import lombok.Data;

/**
 * @author wangkang
 * @Date 2021/12/6 14:53
 */
@Data
public class AuthRequest implements Message {
    public static final String TYPE = "AUTH_REQUEST";

    /**
     * 认证 Token
     */
    private String accessToken;
}
