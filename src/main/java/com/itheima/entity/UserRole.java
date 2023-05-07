package com.itheima.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

import lombok.NoArgsConstructor;
import lombok.Data;

/**
 * (UserRole)表实体类
 *
 * @author 柠檬吖
 * @since 2023-02-10 16:07:58
 */
@Data
@NoArgsConstructor
public class UserRole implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer userId;

    private Integer roleId;

}

