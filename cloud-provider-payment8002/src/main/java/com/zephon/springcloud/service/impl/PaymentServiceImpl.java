package com.zephon.springcloud.service.impl;

import com.zephon.springcloud.dao.PaymentDao;
import com.zephon.springcloud.entities.Payment;
import com.zephon.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Zephon
 * @version V1.0
 * @Package com.zephon.springcloud.service.impl
 * @date 2020/4/30 下午10:53
 * @Copyright ©
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao paymentDao;
    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentByID(Long id) {
        return paymentDao.getPaymentByID(id);
    }
}
