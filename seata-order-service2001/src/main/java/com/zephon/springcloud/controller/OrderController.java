package com.zephon.springcloud.controller;

import com.zephon.springcloud.domain.Order;
import com.zephon.springcloud.entities.CommonResult;
import com.zephon.springcloud.service.OrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Zephon
 * @version V1.0
 * @Package com.zephon.springcloud.controller
 * @date 2020/5/13 下午9:59
 * @Copyright ©
 */
@RestController
public class OrderController {
    @Resource
    private OrderService orderService;

    @PostMapping("/order/create")
    public CommonResult create(Order order){
        orderService.create(order);
        return new CommonResult(200,"订单创建完成");
    }
}
