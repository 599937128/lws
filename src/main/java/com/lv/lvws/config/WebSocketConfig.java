package com.lv.lvws.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;
/**
 * @program: lvws
 * @Date: 2018/10/7 10:56
 * @Author: Mr.lv
 * @Description: 第一步引入依赖，第二步就是：
 * 创建websocket的配置类并且加入到spring容器中,返回相关的对象
 * 第三步就是写触发的方法一般也是在sevice层,其实就是用户下单或者是用户催单
 */
@Component
public class WebSocketConfig {

    @Bean
    public ServerEndpointExporter serverEndpointConfig() {
        return new ServerEndpointExporter();
    }
}

