package com.itheima.dto;

import com.itheima.entity.Order;
import lombok.Data;

import java.io.Serializable;
@Data
public class OrderDto extends Order implements Serializable {
    private static final long serialVersionUID = 1L;
    private String member;
    private String setmeal;
}
