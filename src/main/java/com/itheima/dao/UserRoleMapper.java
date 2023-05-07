package com.itheima.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itheima.entity.UserRole;
import org.apache.ibatis.annotations.Mapper;

/**
 * (UserRole)表数据库访问层
 *
 * @author 柠檬吖
 * @since 2023-02-10 16:07:58
 */
@Mapper
public interface UserRoleMapper extends BaseMapper<UserRole> {

}

