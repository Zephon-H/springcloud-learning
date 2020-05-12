package com.zephon.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author Zephon
 * @version V1.0
 * @Package com.zephon.springcloud.service
 * @date 2020/5/6 上午11:52
 * @Copyright ©
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "PaymentFallbackService fall back";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "PaymentFallbackService fall back timeout";
    }
}
