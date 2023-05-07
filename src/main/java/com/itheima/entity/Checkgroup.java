package com.itheima.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

import lombok.NoArgsConstructor;
import lombok.Data;

/**
 * (Checkgroup)表实体类
 *
 * @author 柠檬吖
 * @since 2023-02-03 20:16:41
 */
@Data
@NoArgsConstructor
public class Checkgroup implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    private String code;

    private String name;

    private String helpcode;

    private String sex;

    private String remark;

    private String attention;

}

