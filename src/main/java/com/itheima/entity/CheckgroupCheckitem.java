package com.itheima.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

import lombok.NoArgsConstructor;
import lombok.Data;

/**
 * (CheckgroupCheckitem)表实体类
 *
 * @author 柠檬吖
 * @since 2023-02-04 16:58:52
 */
@Data
@NoArgsConstructor
public class CheckgroupCheckitem implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer checkgroupId;

    private Integer checkitemId;

}

