package com.itheima.entity;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

import lombok.NoArgsConstructor;
import lombok.Data;

/**
 * (User)表实体类
 *
 * @author 柠檬吖
 * @since 2023-02-10 16:07:58
 */
@Data
@NoArgsConstructor
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    private Date birthday;

    private String gender;

    private String username;

    private String password;

    private String remark;

    private String station;

    private String telephone;

}

