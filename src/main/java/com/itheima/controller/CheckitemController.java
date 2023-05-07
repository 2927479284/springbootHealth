package com.itheima.controller;


import cn.hutool.core.collection.ListUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itheima.entity.Checkitem;
import com.itheima.service.CheckitemService;
import com.itheima.entity.Result;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import static com.itheima.utils.MessageConstant.*;

/**
 * (Checkitem)表控制层
 *
 * @author 柠檬吖
 * @since 2023-02-03 20:16:41
 */
@RestController
@Slf4j
@RequestMapping("/checkitems")
public class CheckitemController {
    /**
     * 服务对象
     */
    @Resource
    private CheckitemService checkitemService;
    @GetMapping("/selectall")
    Result SelectList(){
        List<Checkitem> list = checkitemService.list();
        return Result.success(list,QUERY_CHECKITEM_SUCCESS);
    }
    @GetMapping
    Result SelectAll(Integer page, Integer pageSize,String queryString){
        LambdaQueryWrapper<Checkitem> lqw = new LambdaQueryWrapper<>();
        Page<Checkitem> checkitemPage = new Page<>(page, pageSize);
        lqw.like(StrUtil.isNotBlank(queryString),Checkitem::getName,queryString).or()
                .like(StrUtil.isNotBlank(queryString),Checkitem::getCode,queryString)
                .orderByAsc(Checkitem::getId);
        Page<Checkitem> page1 = checkitemService.page(checkitemPage, lqw);
        return page1!=null? Result.success(page1,QUERY_CHECKITEM_SUCCESS): Result.fail(QUERY_CHECKITEM_FAIL);
    }
    /**
     * 新增数据
     *
     * @param checkitem 实体对象
     * @return 新增结果
     */
    @PostMapping
    public Result insert(@RequestBody Checkitem checkitem) {
        return checkitemService.save(checkitem)?Result.success(ADD_CHECKITEM_SUCCESS): Result.fail(ADD_CHECKITEM_FAIL);
    }

    /**
     * 修改数据
     *
     * @param checkitem 实体对象
     * @return 修改结果
     */
    @PutMapping
    public Result update(@RequestBody Checkitem checkitem) {
        return checkitemService.updateById(checkitem)? Result.success(EDIT_CHECKITEM_SUCCESS): Result.fail(EDIT_CHECKITEM_FAIL);
    }

    @PostMapping("/delete")
    public Result delete( @RequestBody Checkitem checkitem) {
        return checkitemService.removeById(checkitem)? Result.success( DELETE_CHECKITEM_SUCCESS): Result.fail(DELETE_CHECKITEM_FAIL);
    }
}

