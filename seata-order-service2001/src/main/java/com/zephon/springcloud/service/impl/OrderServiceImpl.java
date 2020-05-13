package com.zephon.springcloud.service.impl;

import com.zephon.springcloud.dao.OrderDao;
import com.zephon.springcloud.domain.Order;
import com.zephon.springcloud.service.AccountService;
import com.zephon.springcloud.service.OrderService;
import com.zephon.springcloud.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Zephon
 * @version V1.0
 * @Package com.zephon.springcloud.service.impl
 * @date 2020/5/13 下午9:45
 * @Copyright ©
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDao orderDao;
    @Resource
    private StorageService storageService;
    @Resource
    private AccountService accountService;
    @Override
    public void create(Order order) {
        log.info("----->开启新建订单");
        orderDao.create(order);
        log.info("----->订单微服务开始调用库存，开始扣减Count");
        storageService.decrease(order.getProductId(),order.getCount());
        log.info("----->订单微服务开始调用库存，扣减End");
        log.info("----->订单微服务开始调用帐户，开始扣减Money");
        accountService.decrease(order.getUserId(),order.getMoney());
        log.info("----->订单微服务开始调用帐户，扣减End");
        // 修改订单状态，从0到1，1代表已完成
        log.info("----->修改订单状态开始");
        orderDao.update(order.getUserId(),0);
        log.info("----->修改订单状态结束");
        log.info("----->下订单结束");
    }
}
