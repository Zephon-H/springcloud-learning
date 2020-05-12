package com.zephon.springcloud.service;

import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author Zephon
 * @version V1.0
 * @Package com.zephon.springcloud.service
 * @date 2020/5/5 下午9:18
 * @Copyright ©
 */
public interface PaymentService {
    String paymentInfo_OK(Integer id);
    String paymentInfo_TimeOut(Integer id);
    String paymentCircuitBreaker(@PathVariable("id") Integer id);
}
