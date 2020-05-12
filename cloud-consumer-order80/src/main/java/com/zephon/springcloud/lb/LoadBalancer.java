package com.zephon.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author Zephon
 * @version V1.0
 * @Package com.zephon.springcloud.lb
 * @date 2020/5/5 下午1:57
 * @Copyright ©
 */
public interface LoadBalancer {
    ServiceInstance instances(List<ServiceInstance> serviceInstances);
}
