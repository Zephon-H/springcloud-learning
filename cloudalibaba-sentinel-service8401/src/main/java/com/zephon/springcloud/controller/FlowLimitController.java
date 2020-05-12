package com.zephon.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author Zephon
 * @version V1.0
 * @Package com.zephon.springcloud.controller
 * @date 2020/5/12 下午3:37
 * @Copyright ©
 */
@RestController
@Slf4j
public class FlowLimitController {
    @GetMapping("/testA")
    public String testA(){
        log.info(Thread.currentThread().getName() + "\t" + "...testA");
        return "*********testA";
    }
    @GetMapping("/testB")
    public String testB(){
        return "*********testB";
    }
    @GetMapping("/testD")
    public String testD(){
        log.info("testD 异常比例");
        int age = 10/0;
        return "-----testD";
    }
    @GetMapping("/testE")
    public String testE(){
        log.info("testE 异常数");
        int age = 10/0;
        return "-----testE";
    }

    @GetMapping("/testHotkey")
    @SentinelResource(value = "testHotKey",blockHandler = "deal_testHotKey")
    public String testHotKey(@RequestParam(value = "p1",required = false) String p1,
                             @RequestParam(value = "p2",required = false) String p2){
        return "-----testHotKey";
    }

    /**
     * 兜底方法
     * @param p1
     * @param p2
     * @param blockException
     * @return
     */
    public String deal_testHotKey(String p1, String p2, BlockException blockException){
        return "-----deal_testHotKey";
    }
}
