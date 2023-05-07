package com.itheima.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itheima.service.SetmealService;
import com.itheima.dao.SetmealMapper;
import com.itheima.entity.Setmeal;
import org.springframework.stereotype.Service;

/**
 * (Setmeal)表服务实现类
 *
 * @author 柠檬吖
 * @since 2023-02-05 13:55:57
 */
@Service
public class SetmealServiceImpl extends ServiceImpl<SetmealMapper, Setmeal> implements SetmealService {
}

