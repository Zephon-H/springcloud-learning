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
 * @date 2020/5/4 下午4:27
 * @Copyright ©
 */
@RestController
@Slf4j
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/consul")
    public String paymentConsul(){
        return "spring cloud with consul："+serverPort+"\t"+ UUID.randomUUID();
    }
}
