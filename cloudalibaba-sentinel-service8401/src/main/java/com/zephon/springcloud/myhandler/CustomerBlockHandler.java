package com.zephon.springcloud.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.zephon.springcloud.entities.CommonResult;
import com.zephon.springcloud.entities.Payment;

/**
 * @author Zephon
 * @version V1.0
 * @Package com.zephon.springcloud.controller
 * @date 2020/5/12 下午11:01
 * @Copyright ©
 */
public class CustomerBlockHandler {
    /**
     * 必须是static
     * @param exception
     * @return
     */
    public static CommonResult<Payment> handleException(BlockException exception){
        return new CommonResult<>(4444,"按客户自定义的Global----1");
    }
    public static CommonResult<Payment> handleException2(BlockException exception){
        return new CommonResult<>(4444,"按客户自定义的Global----2");
    }
}
