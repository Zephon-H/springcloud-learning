package com.zephon.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Zephon
 * @version V1.0
 * @Package com.zephon.springcloud.entities
 * @date 2020/4/30 下午10:18
 * @Copyright ©
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment implements Serializable {
    private Long id;
    private String serial;
}
