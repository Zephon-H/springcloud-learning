package com.zephon.springcloud.service;

import com.zephon.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author Zephon
 * @version V1.0
 * @Package com.zephon.springcloud.service
 * @date 2020/4/30 下午10:53
 * @Copyright ©
 */
public interface PaymentService {
    int create(Payment payment);

    Payment getPaymentById(@Param("id")Long id);

}
