package com.itheima.controller;


import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.itheima.dto.OrdersettingDto;
import com.itheima.entity.Ordersetting;
import com.itheima.service.OrdersettingService;
import com.itheima.entity.Result;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.itheima.utils.DateUtils;
import com.itheima.utils.POIUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import static com.itheima.utils.MessageConstant.*;

/**
 * (Ordersetting)表控制层
 *
 * @author 柠檬吖
 * @since 2023-02-09 15:51:12
 */
@RestController
@Slf4j
@RequestMapping("/ordersettings")
public class OrdersettingController {
    /**
     * 服务对象
     */
    @Resource
    private OrdersettingService ordersettingService;
    @GetMapping("/selectByMouth")
    Result SelectByMouth(String data){
        LambdaQueryWrapper<Ordersetting> lqw = new LambdaQueryWrapper<>();
        lqw.like(Ordersetting::getOrderdate,data);
        List<OrdersettingDto> ordersettingDtos = new ArrayList<>();
        List<Ordersetting> list = ordersettingService.list(lqw);
        list.stream().forEach(item->{
            OrdersettingDto ordersettingDto = new OrdersettingDto();
            BeanUtil.copyProperties(item,ordersettingDto,"orderdate");
            ordersettingDto.setData(item.getOrderdate().getDate());
            ordersettingDtos.add(ordersettingDto);
        });

        return CollectionUtil.isNotEmpty(list)?Result.success(ordersettingDtos,GET_ORDERSETTING_SUCCESS): Result.fail(GET_ORDERSETTING_FAIL);
    }
    @GetMapping("/editNumberByDate")
    Result EditNumberByDate(String orderdate,String number) throws Exception {
        LambdaQueryWrapper<Ordersetting> lqw = new LambdaQueryWrapper<>();
        lqw.eq(Ordersetting::getOrderdate,orderdate);
        Ordersetting one = ordersettingService.getOne(lqw);
        if (one==null){
            Ordersetting ordersetting = new Ordersetting();
            ordersetting.setNumber(Integer.valueOf(number));
            ordersetting.setOrderdate(DateUtils.parseString2Date(orderdate));
            ordersetting.setReservations(0);
            return ordersettingService.save(ordersetting)? Result.success(ORDERSETTING_SUCCESS): Result.fail(ORDERSETTING_FAIL);
        }
        one.setNumber(Integer.valueOf(number));
        return  ordersettingService.updateById(one)? Result.success(ORDERSETTING_SUCCESS): Result.fail(ORDERSETTING_FAIL);
    }


    @PostMapping("/upload")
    Result Upload(MultipartFile excelFile)  {
        try {
            List<String[]> list = POIUtils.readExcel(excelFile);
            list.stream().forEach(item->{
                LambdaQueryWrapper<Ordersetting> lqw = new LambdaQueryWrapper<>();
                lqw.eq(Ordersetting::getOrderdate,item[0]);
                Ordersetting one = ordersettingService.getOne(lqw);
                if (one==null){
                    one.setOrderdate(new Date(item[0]));
                    one.setNumber(Integer.valueOf(item[1]));
                    one.setReservations(0);
                    ordersettingService.save(one);
                }
                one.setNumber(Integer.valueOf(item[1]));
                ordersettingService.updateById(one);
            });
            return Result.success(IMPORT_ORDERSETTING_SUCCESS);
        } catch (IOException e) {
            return Result.success(IMPORT_ORDERSETTING_FAIL);
        }
    }

}

