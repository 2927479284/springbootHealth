package com.itheima.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itheima.dto.MemberDto;
import com.itheima.entity.Member;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * (Member)表数据库访问层
 *
 * @author 柠檬吖
 * @since 2023-02-10 14:20:54
 */
@Mapper
public interface MemberMapper extends BaseMapper<Member> {
    @Select("select  t1.name as username ,t1.idcard,t1.phonenumber,t3.name as setmealname,t3.remark,t3.img,t2.ordertype,t2.orderdate from t_member t1,t_order t2 ,t_setmeal t3 where t1.id=t2.member_id and t2.setmeal_id=t3.id LIMIT #{page},#{pageSize}")
    public List<MemberDto> selectById(Integer page,Integer pageSize) ;
    @Select("select  id from t_member where name=#{name}")
    public Integer selectByName(String name);
}

