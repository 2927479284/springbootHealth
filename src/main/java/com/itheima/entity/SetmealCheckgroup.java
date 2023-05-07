package com.itheima.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

import lombok.NoArgsConstructor;
import lombok.Data;

/**
 * (SetmealCheckgroup)表实体类
 *
 * @author 柠檬吖
 * @since 2023-02-05 13:56:39
 */
@Data
@NoArgsConstructor
public class SetmealCheckgroup implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(value = "setmeal_id", type = IdType.ASSIGN_ID)
    private Integer setmealId;

    private Integer checkgroupId;

}

