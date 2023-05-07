package com.itheima.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class OrdersettingPo implements Serializable {
    private static final long serialVersionUID = 1L;
    private String orderdate;
    private Integer number;
    private Integer reservations;
}
