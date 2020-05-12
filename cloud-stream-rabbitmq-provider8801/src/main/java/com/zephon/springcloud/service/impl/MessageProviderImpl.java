package com.zephon.springcloud.service.impl;

import com.zephon.springcloud.service.IMessageProvider;
import org.springframework.cloud.stream.annotation.EnableBinding;
import javax.annotation.Resource;
import java.util.UUID;
/**
 * @author Zephon
 * @version V1.0
 * @Package com.zephon.springcloud.service.impl
 * @date 2020/5/10 下午4:09
 * @Copyright ©
 */

import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

/**
 * 此处不需要@Service
 * 因为此Service是与MQ打交道的
 * 使用@EnableBinding(Source.class)，定义消息的推送管道
 */
@EnableBinding(Source.class)
public class MessageProviderImpl implements IMessageProvider
{
    /**
     * 消息发送管道
     */
    @Resource
    private MessageChannel output;

    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build());
        System.out.println("****send serial："+serial);
        return serial;
    }
}
