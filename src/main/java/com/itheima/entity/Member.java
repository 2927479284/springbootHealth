package com.itheima.entity;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

import lombok.NoArgsConstructor;
import lombok.Data;

/**
 * (Member)表实体类
 *
 * @author 柠檬吖
 * @since 2023-02-10 14:20:54
 */
@Data
@NoArgsConstructor
public class Member implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    private String filenumber;

    private String name;

    private String sex;

    private String idcard;

    private String phonenumber;

    private Date regtime;

    private String password;

    private String email;

    private Date birthday;

    private String remark;

}

