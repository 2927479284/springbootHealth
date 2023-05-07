package com.itheima.controller;


import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itheima.dto.MemberDto;
import com.itheima.entity.Member;
import com.itheima.entity.Menu;
import com.itheima.service.MemberService;
import com.itheima.entity.Result;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import static com.itheima.utils.MessageConstant.*;

/**
 * (Member)表控制层
 *
 * @author 柠檬吖
 * @since 2023-02-10 14:20:54
 */
@RestController
@Slf4j
@RequestMapping("/members")
public class MemberController {
    /**
     * 服务对象
     */
    @Resource
    private MemberService memberService;
    @PostMapping("/insert")
    Result Insert(@RequestBody MemberDto memberDto){
        return memberService.Insert(memberDto);
    }
    @PostMapping("/Delete")
    Result delete(@RequestBody MemberDto memberDto)
    {
        return memberService.Delete(memberDto);
    }
    @PutMapping("/update")
    Result Update(@RequestBody MemberDto memberDto){
        return memberService.Update(memberDto);
    }
    @PostMapping("/delete")
    Result Delete(@RequestBody Member member){
        return memberService.removeById(member)?Result.success(DELETE_MEMBER_SUCCESS): Result.fail(DELETE_MEMBER_FAIL);
    }
    @GetMapping
    Result SelectByPage(Integer page,Integer pageSize,String queryString){
        LambdaQueryWrapper<Member> lqw = new LambdaQueryWrapper<>();
        lqw.like(StrUtil.isNotBlank(queryString),Member::getPhonenumber,queryString)
                .or().like(StrUtil.isNotBlank(queryString),Member::getName,queryString);
        Page<Member> memberPage = new Page<>(page, pageSize);
        Page<Member> page1 = memberService.page(memberPage, lqw);

        return page1!=null?Result.success(page1,GET_MEMBER_SUCCESS): Result.fail(GET_MEMBER_FAIL);
    }

    @GetMapping("/selectById")
    public Result selectOne(Integer page,Integer pageSize) {
        return memberService.SelectById(page, pageSize);
    }

    /**
     * 新增数据
     *
     * @param member 实体对象
     * @return 新增结果
     */
    @PostMapping
    public Result insert(@RequestBody Member member) {
        member.setRegtime(new Date());
        return memberService.save(member)?Result.success(ADD_MEMBER_SUCCESS): Result.fail(ADD_MEMBER_FAIL);
    }

    /**
     * 修改数据
     *
     * @param member 实体对象
     * @return 修改结果
     */
    @PutMapping
    public Result update(@RequestBody Member member) {
        return memberService.updateById(member)?Result.success(EDIT_MEMBER_SUCCESS): Result.fail(EDIT_MEMBER_FAIL);
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public Result delete(@RequestParam("idList") List<Long> idList) {
        return Result.success("功能未开发");
    }
}

