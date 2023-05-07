package com.itheima.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itheima.service.UserRoleService;
import com.itheima.dao.UserRoleMapper;
import com.itheima.entity.UserRole;
import org.springframework.stereotype.Service;

/**
 * (UserRole)表服务实现类
 *
 * @author 柠檬吖
 * @since 2023-02-10 16:07:58
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements UserRoleService {
}

