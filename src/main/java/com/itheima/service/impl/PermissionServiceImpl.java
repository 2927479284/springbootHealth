package com.itheima.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itheima.service.PermissionService;
import com.itheima.dao.PermissionMapper;
import com.itheima.entity.Permission;
import org.springframework.stereotype.Service;

/**
 * (Permission)表服务实现类
 *
 * @author 柠檬吖
 * @since 2023-02-14 16:42:01
 */
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements PermissionService {
}

