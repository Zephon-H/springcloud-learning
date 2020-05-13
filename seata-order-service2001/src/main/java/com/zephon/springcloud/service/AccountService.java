package com.zephon.springcloud.service;

import com.zephon.springcloud.entities.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @author Zephon
 * @version V1.0
 * @Package com.zephon.springcloud.service
 * @date 2020/5/13 下午9:44
 * @Copyright ©
 */
@FeignClient(value = "seata-account-service")
public interface AccountService {
    @PostMapping("/account/decrease")
    CommonResult decrease(@RequestParam("userId")Long userId,@RequestParam("money") BigDecimal money);
}
