package com.itheima.dto;

import lombok.Data;

import java.io.Serializable;
@Data
public class OrdersettingDto implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer data;
    private Integer number;
    private Integer reservations;
}
