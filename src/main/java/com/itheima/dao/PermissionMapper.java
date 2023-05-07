package com.itheima.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itheima.entity.Permission;
import org.apache.ibatis.annotations.Mapper;

/**
 * (Permission)表数据库访问层
 *
 * @author 柠檬吖
 * @since 2023-02-14 16:42:01
 */
@Mapper
public interface PermissionMapper extends BaseMapper<Permission> {
}

