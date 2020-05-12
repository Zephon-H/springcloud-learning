package com.zephon.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.zephon.springcloud.entities.CommonResult;
import com.zephon.springcloud.entities.Payment;
import com.zephon.springcloud.myhandler.CustomerBlockHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Zephon
 * @version V1.0
 * @Package com.zephon.springcloud.controller
 * @date 2020/5/12 下午10:24
 * @Copyright ©
 */
@RestController
public class RateLimitController {
    @GetMapping("/byResource")
    @SentinelResource(value = "byResource",blockHandler = "handleException")
    public CommonResult<Payment> byResource(){
        return new CommonResult<>(200,"按资源名称限流测试ok",new Payment(2020L,"serial1001"));
    }
    public CommonResult<Payment> handleException(BlockException exception){
        return new CommonResult<>(444,exception.getClass().getCanonicalName()+"\t服务不可用");
    }

    @GetMapping("/rateLimit/byUrl")
    @SentinelResource("byUrl")
    public CommonResult<Payment> byUrl(){
        return new CommonResult<>(200, "按Url限流测试OK", new Payment(2020L, "serail1002"));
    }

    @GetMapping("/rateLimit/customerBlockHandler")
    @SentinelResource(value = "customerBlockHandler",
            blockHandlerClass = CustomerBlockHandler.class,
            blockHandler = "handleException2")
    public CommonResult<Payment> customerBlockHandler(){
        return new CommonResult<>(200, "按客户自定义", new Payment(2020L, "serail1003"));
    }
}
