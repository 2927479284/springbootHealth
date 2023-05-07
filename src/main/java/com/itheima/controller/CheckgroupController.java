package com.itheima.controller;


import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.lang.UUID;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itheima.entity.Checkgroup;
import com.itheima.entity.CheckgroupCheckitem;
import com.itheima.entity.Checkitem;
import com.itheima.exception.BusinessException;
import com.itheima.service.CheckgroupCheckitemService;
import com.itheima.service.CheckgroupService;
import com.itheima.entity.Result;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import com.itheima.utils.QiniuUtils;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import static com.itheima.utils.MessageConstant.*;

/**
 * (Checkgroup)表控制层
 *
 * @author 柠檬吖
 * @since 2023-02-03 20:16:41
 */
@RestController
@Slf4j
@RequestMapping("/checkgroups")
public class CheckgroupController {
    /**
     * 服务对象
     */
    @Resource
    private CheckgroupService checkgroupService;
    @Resource
    private CheckgroupCheckitemService checkgroupCheckitemService;

    @PostMapping("/getcheckitemIds")
    Result GetcheckitemIds(@RequestBody Checkgroup checkgroup) {
        LambdaQueryWrapper<CheckgroupCheckitem> lqw = new LambdaQueryWrapper<>();
        lqw.eq(CheckgroupCheckitem::getCheckgroupId, checkgroup.getId());
        List<CheckgroupCheckitem> list = checkgroupCheckitemService.list(lqw);
        return Result.success(list, QUERY_CHECKGROUP_SUCCESS);
    }

    @GetMapping
    Result SelectAll(Integer page, Integer pageSize, String queryString) {
        LambdaQueryWrapper<Checkgroup> lqw = new LambdaQueryWrapper<>();
        Page<Checkgroup> checkgroupPage = new Page<>(page, pageSize);
        lqw.like(StrUtil.isNotBlank(queryString), Checkgroup::getCode, queryString).or()
                .like(StrUtil.isNotBlank(queryString), Checkgroup::getName, queryString).or()
                .like(StrUtil.isNotBlank(queryString), Checkgroup::getHelpcode, queryString)
                .orderByAsc(Checkgroup::getId);
        Page<Checkgroup> page1 = checkgroupService.page(checkgroupPage, lqw);
        return page1 != null ? Result.success(page1, QUERY_CHECKGROUP_SUCCESS) : Result.fail(QUERY_CHECKGROUP_FAIL);
    }

    /**
     * 新增数据
     *
     * @param checkgroup 实体对象
     * @return 新增结果
     */
    @PostMapping
    public Result insert(String checkitemIds, @RequestBody Checkgroup checkgroup) {
        boolean save = checkgroupService.save(checkgroup);
        extracted(checkitemIds, checkgroup);
        return save ? Result.success(ADD_CHECKGROUP_SUCCESS) : Result.fail(ADD_CHECKGROUP_FAIL);
    }

    /**
     * 修改数据
     *
     * @param checkgroup 实体对象
     * @return 修改结果
     */
    @PutMapping
    public Result update(String checkitemIds, @RequestBody Checkgroup checkgroup) {
        boolean b = checkgroupService.updateById(checkgroup);
        if (StrUtil.isBlank(checkitemIds)) {
            return b ? Result.success(EDIT_CHECKGROUP_SUCCESS) : Result.fail(EDIT_CHECKGROUP_FAIL);
        }
        LambdaQueryWrapper<CheckgroupCheckitem> lqw = new LambdaQueryWrapper<>();
        lqw.eq(CheckgroupCheckitem::getCheckgroupId, checkgroup.getId());
        checkgroupCheckitemService.remove(lqw);
        extracted(checkitemIds, checkgroup);
        return b ? Result.success(EDIT_CHECKGROUP_SUCCESS) : Result.fail(EDIT_CHECKGROUP_FAIL);
    }

    private void extracted(String checkitemIds, Checkgroup checkgroup) {
        String[] split = checkitemIds.split(",");
        Arrays.stream(split).forEach(item -> {
            CheckgroupCheckitem checkgroupCheckitem = new CheckgroupCheckitem();
            checkgroupCheckitem.setCheckgroupId(checkgroup.getId());
            checkgroupCheckitem.setCheckitemId(Integer.valueOf(item));
            checkgroupCheckitemService.save(checkgroupCheckitem);
        });
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody Checkgroup checkgroup) {
        LambdaQueryWrapper<CheckgroupCheckitem> lqw = new LambdaQueryWrapper<>();
        lqw.eq(CheckgroupCheckitem::getCheckgroupId, checkgroup.getId());
        List<CheckgroupCheckitem> list = checkgroupCheckitemService.list(lqw);
        if (CollectionUtil.isEmpty(list)) {
            return checkgroupService.removeById(checkgroup.getId()) ? Result.success(DELETE_CHECKGROUP_SUCCESS) : Result.fail(DELETE_CHECKGROUP_FAIL);
        }
        checkgroupCheckitemService.remove(lqw);
        return checkgroupService.removeById(checkgroup.getId()) ? Result.success(DELETE_CHECKGROUP_SUCCESS) : Result.fail(DELETE_CHECKGROUP_FAIL);
    }
}

