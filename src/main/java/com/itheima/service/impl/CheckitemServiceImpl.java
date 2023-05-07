package com.itheima.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itheima.service.CheckitemService;
import com.itheima.dao.CheckitemMapper;
import com.itheima.entity.Checkitem;
import org.springframework.stereotype.Service;

/**
 * (Checkitem)表服务实现类
 *
 * @author 柠檬吖
 * @since 2023-02-03 20:16:42
 */
@Service
public class CheckitemServiceImpl extends ServiceImpl<CheckitemMapper, Checkitem> implements CheckitemService {
}

