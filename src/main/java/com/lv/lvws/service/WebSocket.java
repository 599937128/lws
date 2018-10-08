package com.lv.lvws.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @program: lvws
 * @Date: 2018/10/7 11:14
 * @Author: Mr.lv
 * @Description:
 */
@Component
@ServerEndpoint("/webSocket")
@Slf4j   // 这样使用lombok的注解就可以方便的使用到日志
public class WebSocket {

    private Session session;

    private static CopyOnWriteArraySet<WebSocket> webSocketSet = new CopyOnWriteArraySet<>();

    /**
     * 根据session获取前端的连接的总数(获取前端的数据)
     * @param session
     */
    @OnOpen
    public void onOpen(Session session) {
        this.session = session;
        webSocketSet.add(this);
        log.info("[webSocket消息] 有新的连接，总数{}：",webSocketSet.size());
    }

    @OnClose
    public void onClose (Session session) {
        webSocketSet.remove(this);
        log.info("[webSocket 连接断开, 总数:{}]", webSocketSet.size());
    }

    /**
     * 如果前端发送消息则可以通过日志打印消息
     * @param message
     */
    @OnMessage
    public void onMessage(String message) {
        log.info("[webSocket 消息] 收到客户端的消息, message={}", message);
    }

    /**
     * 从后台也就是从服务端向客户端发送消息(通过获取到的session发送消息)
     * @param message
     */
    public void sendMessage(String message) {
        for (WebSocket webSocket: webSocketSet) {
            log.info("[webSocket消息] 广播消息, message={}", message);
            try {
                webSocket.session.getBasicRemote().sendText(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
