package com.itheima.controller;


import com.itheima.entity.SetmealCheckgroup;
import com.itheima.service.SetmealCheckgroupService;
import com.itheima.entity.Result;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * (SetmealCheckgroup)表控制层
 *
 * @author 柠檬吖
 * @since 2023-02-05 13:56:39
 */
@RestController
@Slf4j
@RequestMapping("/setmealCheckgroups")
public class SetmealCheckgroupController {
    /**
     * 服务对象
     */
    @Resource
    private SetmealCheckgroupService setmealCheckgroupService;



}

