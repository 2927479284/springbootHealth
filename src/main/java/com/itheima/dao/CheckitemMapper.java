package com.itheima.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itheima.entity.Checkitem;
import org.apache.ibatis.annotations.Mapper;

/**
 * (Checkitem)表数据库访问层
 *
 * @author 柠檬吖
 * @since 2023-02-03 20:16:41
 */
@Mapper
public interface CheckitemMapper extends BaseMapper<Checkitem> {
}

