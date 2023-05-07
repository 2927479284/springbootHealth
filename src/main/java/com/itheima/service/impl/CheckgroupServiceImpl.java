package com.itheima.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itheima.service.CheckgroupService;
import com.itheima.dao.CheckgroupMapper;
import com.itheima.entity.Checkgroup;
import org.springframework.stereotype.Service;

/**
 * (Checkgroup)表服务实现类
 *
 * @author 柠檬吖
 * @since 2023-02-03 20:16:41
 */
@Service
public class CheckgroupServiceImpl extends ServiceImpl<CheckgroupMapper, Checkgroup> implements CheckgroupService {
}

