package com.itheima;

import com.itheima.utils.QiniuUtils;
import com.itheima.utils.SMSUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class SpringboothealthApplicationTests {
    @Resource
    SMSUtils smsUtils;
    @Resource
    QiniuUtils qiniuUtils;



}
