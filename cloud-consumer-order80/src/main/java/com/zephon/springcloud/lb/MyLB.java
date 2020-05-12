package com.zephon.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Zephon
 * @version V1.0
 * @Package com.zephon.springcloud.lb
 * @date 2020/5/5 下午1:58
 * @Copyright ©
 */
@Component
public class MyLB implements LoadBalancer {
    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public final int getAndIncrement(){
        int current;
        int next;
        // 自旋锁
        do{
            current = this.atomicInteger.get();
            next = current>=Integer.MAX_VALUE?0:current+1;

        }while(!this.atomicInteger.compareAndSet(current,next));
        System.out.println("********next："+next);
        return next;
    }

    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
        int index = getAndIncrement() % serviceInstances.size();
        return serviceInstances.get(index);
    }
}
