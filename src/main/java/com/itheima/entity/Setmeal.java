package com.itheima.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

import lombok.NoArgsConstructor;
import lombok.Data;

/**
 * (Setmeal)表实体类
 *
 * @author 柠檬吖
 * @since 2023-02-05 13:55:57
 */
@Data
@NoArgsConstructor
public class Setmeal implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    private String name;

    private String code;

    private String helpcode;

    private String sex;

    private String age;

    private Float price;

    private String remark;

    private String attention;

    private String img;

}

