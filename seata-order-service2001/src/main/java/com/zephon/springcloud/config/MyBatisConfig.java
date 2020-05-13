package com.zephon.springcloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Zephon
 * @version V1.0
 * @Package com.zephon.springcloud.config
 * @date 2020/5/13 下午10:23
 * @Copyright ©
 */
@Configuration
@MapperScan({"com.zephon.springcloud.dao"})
public class MyBatisConfig {

}
