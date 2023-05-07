package com.itheima.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itheima.service.OrdersettingService;
import com.itheima.dao.OrdersettingMapper;
import com.itheima.entity.Ordersetting;
import org.springframework.stereotype.Service;

/**
 * (Ordersetting)表服务实现类
 *
 * @author 柠檬吖
 * @since 2023-02-09 15:51:12
 */
@Service
public class OrdersettingServiceImpl extends ServiceImpl<OrdersettingMapper, Ordersetting> implements OrdersettingService {
}

