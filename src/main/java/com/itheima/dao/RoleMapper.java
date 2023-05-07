package com.itheima.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itheima.entity.Role;
import org.apache.ibatis.annotations.Mapper;

/**
 * (Role)表数据库访问层
 *
 * @author 柠檬吖
 * @since 2023-02-14 16:41:59
 */
@Mapper
public interface RoleMapper extends BaseMapper<Role> {
}

