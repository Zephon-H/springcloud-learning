package com.zephon.springcloud.controller;

import com.zephon.springcloud.entities.CommonResult;
import com.zephon.springcloud.entities.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.UUID;

/**
 * @author Zephon
 * @version V1.0
 * @Package com.zephon.springcloud.controller
 * @date 2020/5/12 下午11:25
 * @Copyright ©
 */
@RestController
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;
    /**
     * 模拟数据库
     */
    public static HashMap<Long, Payment> hashMap = new HashMap<>();
    static {
        hashMap.put(1L,new Payment(1L, UUID.randomUUID().toString()));
        hashMap.put(2L,new Payment(2L, UUID.randomUUID().toString()));
        hashMap.put(3L,new Payment(3L, UUID.randomUUID().toString()));
    }
    @GetMapping("/paymentSQL/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id")Long id){
        Payment payment = hashMap.get(id);
        return new CommonResult<>(200,"from mysql,serverPort:"+serverPort,payment);
    }
}
