package com.wk.netty.demo.client.config;

import com.wk.netty.demo.common.dispatcher.MessageDispatcher;
import com.wk.netty.demo.common.dispatcher.MessageHandlerContainer;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author wangkang
 * @Date 2021/12/3 16:50
 */
@Component
public class NettyClientConfig {
    @Bean
    public MessageDispatcher messageDispatcher() {
        return new MessageDispatcher();
    }

    @Bean
    public MessageHandlerContainer messageHandlerContainer() {
        return new MessageHandlerContainer();
    }

}
