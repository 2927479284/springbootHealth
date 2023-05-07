package com.itheima.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itheima.dao.OrderMapper;
import com.itheima.dao.SetmealCheckgroupMapper;
import com.itheima.dao.SetmealMapper;
import com.itheima.dto.MemberDto;
import com.itheima.entity.*;
import com.itheima.service.MemberService;
import com.itheima.dao.MemberMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

import static com.itheima.utils.MessageConstant.GET_ORDERSETTING_FAIL;
import static com.itheima.utils.MessageConstant.GET_ORDERSETTING_SUCCESS;

/**
 * (Member)表服务实现类
 *
 * @author 柠檬吖
 * @since 2023-02-10 14:20:54
 */
@Service
public class MemberServiceImpl extends ServiceImpl<MemberMapper, Member> implements MemberService {
    @Resource
    private MemberMapper memberMapper;
    @Resource
    private OrderMapper orderMapper;
    @Resource
    private SetmealMapper setmealMapper;
    @Resource
    private SetmealCheckgroupMapper setmealCheckgroupMapper;
    @Override
    public Result SelectById(Integer page,Integer pageSize) {
        page=(page-1)*pageSize;
        List<MemberDto> memberDtos = memberMapper.selectById(page,pageSize);
        memberDtos.forEach(item->{
            String format = DateUtil.format(item.getOrderdate(), "yyyy-MM-dd");
            item.setOrderdate1(format);
        });
        return CollectionUtil.isNotEmpty(memberDtos)?Result.success(memberDtos,GET_ORDERSETTING_SUCCESS): Result.fail(GET_ORDERSETTING_FAIL);
    }

    @Override
    public Result Insert(MemberDto memberDto) {
        Member member = new Member();
        BeanUtil.copyProperties(memberDto,member);
        member.setName(memberDto.getUsername());
        member.setRegtime(new Date());
        memberMapper.insert(member);
        Setmeal setmeal = new Setmeal();
        setmeal.setName(memberDto.getSetmealname());
        setmeal.setRemark(memberDto.getRemark());
        setmeal.setImg(memberDto.getImg());
        setmealMapper.insert(setmeal);
        Order order = new Order();
        order.setOrdertype(memberDto.getOrdertype());
        order.setOrderdate(new Date());
        order.setOrderstatus("未到诊");
        order.setMemberId(member.getId());
        order.setSetmealId(setmeal.getId());
        orderMapper.insert(order);
        return Result.success("添加成功");
    }

    @Override
    public Result Delete(MemberDto memberDto) {
        Integer id = memberMapper.selectByName(memberDto.getUsername());
        memberMapper.deleteById(id);
        LambdaQueryWrapper<Order> lqw = new LambdaQueryWrapper<>();
        lqw.eq(Order::getMemberId,id);
        Order order = orderMapper.selectOne(lqw);
        orderMapper.deleteById(order);
        LambdaQueryWrapper<SetmealCheckgroup> lqw2 = new LambdaQueryWrapper<>();
        lqw2.eq(SetmealCheckgroup::getSetmealId,order.getSetmealId());
        setmealCheckgroupMapper.delete(lqw2);
        setmealMapper.deleteById(order.getSetmealId());
        return Result.success("删除成功");
    }

    @Override
    public Result Update(MemberDto memberDto) {
        Integer id = memberMapper.selectByName(memberDto.getUsername());
        Member member = memberMapper.selectById(id);
        member.setIdcard(memberDto.getIdcard());
        member.setPhonenumber(memberDto.getPhonenumber());
        memberMapper.updateById(member);
        LambdaQueryWrapper<Order> lqw = new LambdaQueryWrapper<>();
        lqw.eq(Order::getMemberId,id);
        Order order = orderMapper.selectOne(lqw);
        order.setOrdertype(memberDto.getOrdertype());
        order.setSetmealId(Integer.valueOf(memberDto.getSetmealname()));
        orderMapper.updateById(order);
        LambdaQueryWrapper<SetmealCheckgroup> lqw2 = new LambdaQueryWrapper<>();
        lqw2.eq(SetmealCheckgroup::getSetmealId,order.getSetmealId());
        List<SetmealCheckgroup> setmealCheckgroups = setmealCheckgroupMapper.selectList(lqw2);
        setmealCheckgroupMapper.delete(lqw2);
        setmealCheckgroups.forEach(item->{
            item.setSetmealId(order.getSetmealId());
            setmealCheckgroupMapper.insert(item);
        });
        return Result.success("修改成功");
    }

}

