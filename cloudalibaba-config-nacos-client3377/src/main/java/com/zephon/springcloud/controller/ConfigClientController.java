package com.zephon.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Zephon
 * @version V1.0
 * @Package com.zephon.springcloud.controller
 * @date 2020/5/11 下午7:57
 * @Copyright ©
 */
@RestController
@RefreshScope // 支持Nacos刷新功能
public class ConfigClientController {
    @Value("${config.info}")
    private String configInfo;
    @GetMapping("/config/info")
    public String getConfigInfo(){
        return configInfo;
    }
}
