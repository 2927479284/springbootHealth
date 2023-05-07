package com.itheima.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.itheima.dto.MemberDto;
import com.itheima.entity.Member;
import com.itheima.entity.Result;

/**
 * (Member)表服务接口
 *
 * @author 柠檬吖
 * @since 2023-02-10 14:20:54
 */
public interface MemberService extends IService<Member> {
    Result SelectById(Integer page,Integer pageSize);
    Result Insert(MemberDto memberDto);

    Result Delete(MemberDto memberDto);

    Result Update(MemberDto memberDto);
}

