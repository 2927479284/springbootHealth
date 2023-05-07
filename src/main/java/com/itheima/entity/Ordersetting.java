package com.itheima.entity;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

import lombok.NoArgsConstructor;
import lombok.Data;

/**
 * (Ordersetting)表实体类
 *
 * @author 柠檬吖
 * @since 2023-02-09 15:51:12
 */
@Data
@NoArgsConstructor
public class Ordersetting implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    /**
     * 约预日期
     */
    private Date orderdate;

    /**
     * 可预约人数
     */
    private Integer number;

    /**
     * 已预约人数
     */
    private Integer reservations;

}

