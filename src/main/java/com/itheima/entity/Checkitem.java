package com.itheima.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

import lombok.NoArgsConstructor;
import lombok.Data;

/**
 * (Checkitem)表实体类
 *
 * @author 柠檬吖
 * @since 2023-02-03 20:16:41
 */
@Data
@NoArgsConstructor
public class Checkitem implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    private String code;

    private String name;

    private String sex;

    private String age;

    private Object price;

    /**
     * 查检项类型,分为检查和检验两种
     */
    private String type;

    private String attention;

    private String remark;

}

