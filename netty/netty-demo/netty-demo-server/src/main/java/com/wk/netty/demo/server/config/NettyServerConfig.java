package com.wk.netty.demo.server.config;

import com.wk.netty.demo.common.dispatcher.MessageDispatcher;
import com.wk.netty.demo.common.dispatcher.MessageHandlerContainer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wangkang
 * @Date 2021/12/3 15:42
 */
@Configuration
public class NettyServerConfig {

    @Bean
    public MessageDispatcher messageDispatcher(){
        return new MessageDispatcher();
    }

    @Bean
    public MessageHandlerContainer messageHandlerContainer(){
        return new MessageHandlerContainer();
    }
}
