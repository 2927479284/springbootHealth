package com.itheima.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itheima.service.MenuService;
import com.itheima.dao.MenuMapper;
import com.itheima.entity.Menu;
import org.springframework.stereotype.Service;

/**
 * (Menu)表服务实现类
 *
 * @author 柠檬吖
 * @since 2023-02-14 16:42:00
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {
}

