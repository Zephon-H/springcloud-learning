package com.zephon.springcloud.dao;

import com.zephon.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author Zephon
 * @version V1.0
 * @Package com.zephon.springcloud.dao
 * @date 2020/4/30 下午10:35
 * @Copyright ©
 */
/**
 * 使用@Mapper代替@Repository
 */
@Mapper
public interface PaymentDao {

    int create(Payment payment);

    Payment getPaymentByID(@Param("id")Long id);
}
