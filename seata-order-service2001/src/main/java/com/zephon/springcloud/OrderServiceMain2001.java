package com.zephon.springcloud;

import com.zephon.springcloud.config.DataSourceProxyConfig;
import com.zephon.springcloud.domain.Order;
import com.zephon.springcloud.service.OrderService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author Zephon
 * @version V1.0
 * @Package com.zephon.springcloud
 * @date 2020/5/13 下午9:02
 * @Copyright ©
 */
@EnableDiscoveryClient
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableFeignClients
public class OrderServiceMain2001 {
    public static void main(String[] args) {
        SpringApplication.run(OrderServiceMain2001.class,args);
    }
}
