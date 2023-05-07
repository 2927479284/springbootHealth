package com.itheima.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

import lombok.NoArgsConstructor;
import lombok.Data;

/**
 * (Permission)表实体类
 *
 * @author 柠檬吖
 * @since 2023-02-14 16:42:01
 */
@Data
@NoArgsConstructor
public class Permission implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    private String name;

    private String keyword;

    private String description;

}

