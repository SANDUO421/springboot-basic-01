package com.sanduo.springboot.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;

import com.sanduo.springboot.entity.Message;
import com.sanduo.springboot.message.MessageResponse;

/**
 * webSocket的消息控制层
 * 
 * @author sanduo
 * @date 2018/06/26
 */
@Controller
public class MessageController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;// 向浏览器发送消息

    /**
     * 点对点
     * 
     * @param principal
     * @param msg
     */
    @MessageMapping("/chat")
    @SendToUser("/queue/chat") // 消息订阅，没有就会报错
    public void handleChat(Principal principal, @Payload String message) {// principle为当前用户的信息
        if (principal.getName().equals("sanduo")) {// 相互发送消息代码
            messagingTemplate.convertAndSendToUser("lantian", "/queue/notifications",
                principal.getName() + "-send:" + message);// 向用户发送消息，第一个参数接受消息的用户，第二个订阅的地址，第三个消息本身
        } else {
            messagingTemplate.convertAndSendToUser("sanduo", "/queue/notifications",
                principal.getName() + "-send:" + message);
        }
    }

    /**
     * 广播模式
     * 
     * @param message
     * @return
     * @throws InterruptedException
     */
    @MessageMapping("/message") // 映射
    @SendTo("/topic/getResponse") // 对这个路径发送消息
    public MessageResponse say(Message message) throws InterruptedException {
        Thread.sleep(5000);
        return new MessageResponse(
            "消息的内容是：" + message.getName() + "内容" + message.getContent() + "状态码:" + message.getCode());
    }
}
