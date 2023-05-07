package com.itheima.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itheima.entity.Ordersetting;
import org.apache.ibatis.annotations.Mapper;

/**
 * (Ordersetting)表数据库访问层
 *
 * @author 柠檬吖
 * @since 2023-02-09 15:51:12
 */
@Mapper
public interface OrdersettingMapper extends BaseMapper<Ordersetting> {
}

