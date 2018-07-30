package com.sanduo.springboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 * @author sanduo
 * @date 2018/06/26
 */
@Configuration
@EnableWebSocketMessageBroker // 开启stomp协议传输代理message broker的消息，此时controller支持@messageMapping
public class WebSocketConfiguration implements WebSocketMessageBrokerConfigurer {

    /* 端点注册
     * @see org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer#registerStompEndpoints(org.springframework.web.socket.config.annotation.StompEndpointRegistry)
     */
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {// 映射指定的url

        registry.addEndpoint("/endpoint").withSockJS();// 注册一个endpoint端点，使用SockJs协议
        registry.addEndpoint("/endpointChat").withSockJS();// 注册endpoint
    }

    /* 配置消息代理
     * @see org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer#configureMessageBroker(org.springframework.messaging.simp.config.MessageBrokerRegistry)
     */
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {// 配置消息代理
        registry.enableSimpleBroker("/topic", "/queue");// 广播式应配置一个/topic消息代理,和queue点对点队列模式
    }

}
