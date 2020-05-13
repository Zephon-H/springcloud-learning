package com.zephon.springcloud.service;

import com.zephon.springcloud.domain.Order;

/**
 * @author Zephon
 * @version V1.0
 * @Package com.zephon.springcloud
 * @date 2020/5/13 下午9:44
 * @Copyright ©
 */
public interface OrderService {
    void create(Order order);
}
