package com.zephon.springcloud.dao;

import com.zephon.springcloud.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author Zephon
 * @version V1.0
 * @Package com.zephon.springcloud.dao
 * @date 2020/5/13 下午9:19
 * @Copyright ©
 */
@Mapper
public interface OrderDao {
    /**
     * 新建订单
     * @param order
     */
    void create(Order order);

    /**
     * 修改订单状态，0->1
     * @param userId
     * @param status
     */
    void update(@Param("userId")Long userId,@Param("status")Integer status);
}
