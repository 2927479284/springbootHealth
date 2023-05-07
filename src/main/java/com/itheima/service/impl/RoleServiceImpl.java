package com.itheima.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itheima.service.RoleService;
import com.itheima.dao.RoleMapper;
import com.itheima.entity.Role;
import org.springframework.stereotype.Service;

/**
 * (Role)表服务实现类
 *
 * @author 柠檬吖
 * @since 2023-02-14 16:42:00
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {
}

