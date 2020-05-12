package com.zephon.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author Zephon
 * @version V1.0
 * @Package com.zephon.springcloud
 * @date 2020/5/10 下午4:07
 * @Copyright ©
 */
@SpringBootApplication
@EnableEurekaClient

public class StreamMQMain8801 {
    public static void main(String[] args) {
        SpringApplication.run(StreamMQMain8801.class,args);
    }
}
