package com.Service;
import com.Entity.poistion;
import com.Utils.WebSocketCustomEncoding;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
@ServerEndpoint(value = "/test",encoders = WebSocketCustomEncoding.class)
@Component
@Slf4j
public class WebsocketService {
    /**
     * 存放所有在线的客户端
     */
    private static Map<String, Session> clients = new ConcurrentHashMap<>();
static String id=null;
    @OnOpen
    public void onOpen(Session session) {
        log.info("有新的客户端连接了: {}", session.getId());
       id=session.getId();
        //将新用户存入在线的组
        clients.put(session.getId(), session);
    }

    /**
     * 客户端关闭
     * @param session session
     */
    @OnClose
    public void onClose(Session session) {
        log.info("有用户断开了, id为:{}", session.getId());
        //将掉线的用户移除在线的组里
        clients.remove(session.getId());
    }

    /**
     * 发生错误
     * @param throwable e
     */
    @OnError
    public void onError(Throwable throwable) {
        throwable.printStackTrace();
    }

    /**
     * 收到客户端发来消息
     * @param message  消息对象
     */
    @OnMessage
    public void onMessage(String message) {
        log.info("服务端收到客户端发来的消息: {}", message);
        this.sendAll(message);
    }


    public void sendMessage(Session session, poistion p) throws IOException {
        if(session != null){
            try {
                log.info("推送开始");

                session.getBasicRemote().sendObject(p);
                System.out.println(p);
                log.info("推送结束");
            } catch (EncodeException e) {
                e.printStackTrace();
            }
        }
    }

    /**

     *
     */
    public void sendInfo(poistion p){

        Session session = clients.get(id);
        log.info(session.getId());

        try {
            sendMessage(session, p);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 群发消息
     * @param message 消息内容
     */
    private void sendAll(String message) {
        for (Map.Entry<String, Session> sessionEntry : clients.entrySet()) {
            sessionEntry.getValue().getAsyncRemote().sendText(message);
        }
    }
}