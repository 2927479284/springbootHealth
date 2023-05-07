package com.itheima.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itheima.entity.Setmeal;
import org.apache.ibatis.annotations.Mapper;

/**
 * (Setmeal)表数据库访问层
 *
 * @author 柠檬吖
 * @since 2023-02-05 13:55:57
 */
@Mapper
public interface SetmealMapper extends BaseMapper<Setmeal> {
}

