package com.itheima.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itheima.service.UserService;
import com.itheima.dao.UserMapper;
import com.itheima.entity.User;
import org.springframework.stereotype.Service;

/**
 * (User)表服务实现类
 *
 * @author 柠檬吖
 * @since 2023-02-10 16:07:58
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}

