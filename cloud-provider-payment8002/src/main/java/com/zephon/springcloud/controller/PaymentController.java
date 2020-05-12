package com.zephon.springcloud.controller;

import com.zephon.springcloud.entities.CommonResult;
import com.zephon.springcloud.entities.Payment;
import com.zephon.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Zephon
 * @version V1.0
 * @Package com.zephon.springcloud.controller
 * @date 2020/4/30 下午10:55
 * @Copyright ©
 */
@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;
    @Value("${server.port}")
    private String serverPort;

    @PostMapping(value = "/payment")
    public CommonResult<Long> create(@RequestBody Payment payment){
        int res = paymentService.create(payment);
        log.info("*****插入结果" + res);
        if(res>0){
            return new CommonResult(200,"插入数据库成功",res);
        }else{
            return new CommonResult(444,"插入数据库失败");
        }
    }
    @GetMapping("/payment/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentByID(id);
        log.info("*****查询结果："+payment);
        if(payment!=null){
            return new CommonResult<>(200,"查询成功,serverPort："+serverPort,payment);
        }else{
            return new CommonResult<>(444,"没有对应记录，查询id："+id);
        }
    }
}
