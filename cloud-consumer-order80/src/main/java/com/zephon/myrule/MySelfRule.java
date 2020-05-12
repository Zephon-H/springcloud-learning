package com.zephon.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sun.misc.LRUCache;

/**
 * @author Zephon
 * @version V1.0
 * @Package com.zephon.springcloud.myrule
 * @date 2020/5/5 下午12:03
 * @Copyright ©
 */
@Configuration
public class MySelfRule {
    @Bean
    public IRule myRule(){
        // 定义为随机规则
        return new RandomRule();
    }
}
