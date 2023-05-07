package com.itheima.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itheima.entity.Order;
import org.apache.ibatis.annotations.Mapper;

/**
 * (Order)表数据库访问层
 *
 * @author 柠檬吖
 * @since 2023-02-09 15:51:01
 */
@Mapper
public interface OrderMapper extends BaseMapper<Order> {
}

