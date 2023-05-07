package com.itheima.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itheima.service.OrderService;
import com.itheima.dao.OrderMapper;
import com.itheima.entity.Order;
import org.springframework.stereotype.Service;

/**
 * (Order)表服务实现类
 *
 * @author 柠檬吖
 * @since 2023-02-09 15:51:01
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {
}

