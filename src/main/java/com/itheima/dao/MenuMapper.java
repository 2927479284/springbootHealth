package com.itheima.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itheima.entity.Menu;
import org.apache.ibatis.annotations.Mapper;

/**
 * (Menu)表数据库访问层
 *
 * @author 柠檬吖
 * @since 2023-02-14 16:42:00
 */
@Mapper
public interface MenuMapper extends BaseMapper<Menu> {
}

