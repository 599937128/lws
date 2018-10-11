package com.lv.lvws.service.impl;

import com.lv.lvws.service.OrderService;
import com.lv.lvws.service.WebSocket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: lvws
 * @Date: 2018/10/7 12:11
 * @Author: Mr.lv
 * @Description:
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private WebSocket webSocket;
    @Override
    public String crete() {
        //发送到客户端的消息
        webSocket.sendMessage("创建订单");
        return "有订单";
    }
}
