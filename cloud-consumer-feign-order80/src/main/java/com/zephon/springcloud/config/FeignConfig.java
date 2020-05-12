package com.zephon.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Zephon
 * @version V1.0
 * @Package com.zephon.springcloud.config
 * @date 2020/5/5 下午8:14
 * @Copyright ©
 */
@Configuration
public class FeignConfig {
    @Bean
    Logger.Level feignLoggerLevel(){
        return Logger.Level.HEADERS;
    }
}
