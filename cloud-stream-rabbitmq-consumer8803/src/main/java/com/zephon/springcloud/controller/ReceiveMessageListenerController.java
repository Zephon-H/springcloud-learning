package com.zephon.springcloud.controller;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @author Zephon
 * @version V1.0
 * @Package com.zephon.springcloud.controller
 * @date 2020/5/10 下午4:37
 * @Copyright ©
 */
import org.springframework.cloud.stream.messaging.Sink;

@Component
@EnableBinding(Sink.class)
public class  ReceiveMessageListenerController {
    @Value("${server.port}")
    private String serverPort;
    @StreamListener(Sink.INPUT)
    public void input(Message<String> message){
        System.out.println("消费者1号，----->收到的消息："+message.getPayload()+"\t port"+serverPort);
    }
}
