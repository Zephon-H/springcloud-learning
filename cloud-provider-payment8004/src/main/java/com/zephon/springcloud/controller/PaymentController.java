package com.zephon.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author Zephon
 * @version V1.0
 * @Package com.zephon.springcloud.controller
 * @date 2020/5/4 下午2:05
 * @Copyright ©
 */
@RestController
@Slf4j
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;
    @GetMapping("/payment/zk")
    public String paymentzk(){
        return "SpringCloud with zookeeper："+serverPort+"\t"+ UUID.randomUUID().toString();
    }
}
