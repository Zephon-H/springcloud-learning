package com.zephon.springcloud.service;

import com.zephon.springcloud.entities.CommonResult;
import com.zephon.springcloud.entities.Payment;
import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author Zephon
 * @version V1.0
 * @Package com.zephon.springcloud.service
 * @date 2020/5/5 下午7:29
 * @Copyright ©
 */
@Component
@FeignClient("CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {
    @GetMapping("/payment/{id}")
    CommonResult<Payment> getPaymentById(@PathVariable("id")Long id);

    @GetMapping("/payment/feign/timeout")
    String paymentFeignTimeout();
}
