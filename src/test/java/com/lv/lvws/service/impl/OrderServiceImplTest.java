package com.lv.lvws.service.impl;

import com.lv.lvws.LvwsApplication;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @program: lvws
 * @Date: 2018/10/11 15:42
 * @Author: Mr.lv
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = LvwsApplication.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class OrderServiceImplTest {

    @Autowired
    private OrderServiceImpl orderService;
    @Test
    public void crete() {
        String result = orderService.crete();
        Assert.assertEquals("有订单", result);
    }
}