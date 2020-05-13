package com.zephon.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.zephon.springcloud.entities.CommonResult;
import com.zephon.springcloud.entities.Payment;
import com.zephon.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author Zephon
 * @version V1.0
 * @Package com.zephon.springcloud.controller
 * @date 2020/5/12 下午11:37
 * @Copyright ©
 */
@RestController
@Slf4j
public class CircleBreakerController {
    @Value("${service-url.nacos-user-service}")
    private String serviceUrl;
    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/fallback/{id}")
    // @SentinelResource(value = "fallback")
    // @SentinelResource(value="fallback",fallback = "handlerFallback") // fallback只负责业务异常
    // @SentinelResource(value = "fallback",blockHandler = "blockHandler")
    @SentinelResource(value = "fallback",
            blockHandler = "blockHandler",
            fallback = "handlerFallback",
            exceptionsToIgnore = {IllegalArgumentException.class})
    public CommonResult<Payment> fallback(@PathVariable Long id){
        CommonResult<Payment> result = restTemplate.getForObject(serviceUrl+"/paymentSQL/"+id,CommonResult.class,id);
        if(id==4){
            throw new IllegalArgumentException("非法参数异常...");
        }else if(result.getData()==null){
            throw new NullPointerException("该ID没有对应的记录，空指针异常");
        }
        return result;
    }
    public CommonResult<Payment> blockHandler(@PathVariable Long id, BlockException e){
        Payment payment = new Payment(id,"null");
        return new CommonResult<>(444,"blockHandler-sentinel限流，无此流水,blockException："+e.getMessage(),payment);

    }
    public CommonResult<Payment> handlerFallback(@PathVariable Long id,Throwable e){
        Payment payment = new Payment(id,"null");
        return new CommonResult<>(444,"兜底异常handlerFallback,exception："+e.getMessage(),payment);
    }

    @Resource
    private PaymentService paymentService;
    @GetMapping("/consumer/openfeign/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id")Long id){
        return paymentService.paymentSQL(id);
    }
}
