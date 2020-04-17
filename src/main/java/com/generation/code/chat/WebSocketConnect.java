/**  
 * @Title:  WebSocketConnect.java   
 * @Package com.chat.room.framework   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: 曾肖
 * @date:   2019年6月28日 下午3:42:14   
 * @version V1.0 
 * @Copyright: 2019
 */
package com.generation.code.chat;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.generation.code.chat.dao.ChatRoomDAO;
import com.generation.code.chat.vo.ChatRoomVO;
import com.generation.code.util.IpUtils;

/**   
 * @ClassName:  WebSocketConnect   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author: 曾肖 
 * @date:   2019年6月28日 下午3:42:14   
 *     
 * @Copyright: 2019
 */
@Component
@ServerEndpoint("/chat/{flag}")
public class WebSocketConnect {
	
    private static WebSocketConnect groupWebSocket;
    /**
     * 	记录群聊分组
     */
    public static String groupKey = "group";
    
    //与某个客户端的连接会话，需要通过它来给客户端发送数据
    private Session session;
    
    @OnOpen
    public void onOpen(Session session){
    	this.session = session;
    	WebSocketConnectManager.addGroup(groupKey, session);
    	WebSocketConnectManager.setConnect(this);
    	List<String> list = WebSocketConnectManager.getGroup(groupKey);
    	JSONObject sendMessage = new JSONObject();
    	//提醒上线了
    	sendMessage.put("type", "notice");
    	if(list.size() > 1) {
    		for (int i = 0; i < list.size(); i++) {
        		String ip = list.get(i);
    			if(ip.equals(IpUtils.getIp(session))) {
    				//加载已有人员
    				sendMessage.put("type", "init");
    				List<String> onlineUserIps = list.stream().filter(s -> !s.equals(ip)).collect(Collectors.toList());
    				List<ChatRoomVO> userList = new ArrayList<>();
    				for (int j = 0; j < onlineUserIps.size(); j++) {
    					ChatRoomVO chatRoomUser = WebSocketConnectManager.getBean(ChatRoomDAO.class).getChatUser(onlineUserIps.get(j));
    					userList.add(chatRoomUser);
    				}
    				sendMessage.put("users", userList);
    				try {
    					WebSocketConnectManager.getConnect(ip).sendMessage(sendMessage.toJSONString());
    				} catch (IOException e) {
    					e.printStackTrace();
    				}
    				continue;
    			}
        		sendMessage.put("ip", IpUtils.getIp(session));
        		sendMessage.put("uname", WebSocketConnectManager.getBean(ChatRoomDAO.class).getChatUser(IpUtils.getIp(session)).getName());
        		try {
    				WebSocketConnectManager.getConnect(ip).sendMessage(sendMessage.toJSONString());
    			} catch (IOException e) {
    				e.printStackTrace();
    			}
        	}
    	}
    }
    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose(Session session){
    	WebSocketConnectManager.removeConnect(session);
    	WebSocketConnectManager.removeGroupMember(groupKey, session);
    }
    
    /**
     * 收到客户端消息后调用的方法
     * @param message 客户端发送过来的消息
     * @param session 可选的参数
     */
    @OnMessage
    public void onMessage(String message, Session session) {
    	String flag = session.getPathParameters().get("flag");
        //群发消息
        try {
        	if(groupKey.equals(flag)) {
        		JSONObject sendMessage = new JSONObject();
        		sendMessage.put("message", message);
        		sendMessage.put("fromip", IpUtils.getIp(session));
        		sendMessage.put("fromname", WebSocketConnectManager.getBean(ChatRoomDAO.class).getChatUser(IpUtils.getIp(session)).getName());
        		List<String> list = WebSocketConnectManager.getGroup(flag);
        		sendMessage.put("groupcount", list.size());
        		for (int i = 0; i < list.size(); i++) {
        			String ip = list.get(i);
					if(ip.equals(IpUtils.getIp(session))) {
						continue;
					}
					WebSocketConnectManager.getConnect(ip).sendMessage(sendMessage.toJSONString());
				}
        	}else {
        		
        	}
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    /**
     * 发生错误时调用
     * @param session
     * @param error
     */
    @OnError
    public void onError(Session session, Throwable error){
    	WebSocketConnectManager.removeConnect(session);
    	WebSocketConnectManager.removeGroupMember(groupKey, session);
        error.printStackTrace();
    }
	/**
     * 这个方法与上面几个方法不一样。没有用注解，是根据自己需要添加的方法。
     * @param message
     * @throws IOException
     */
    public void sendMessage(String message) throws IOException{
        this.session.getBasicRemote().sendText(message);
    }

	public WebSocketConnect getGroupWebSocket() {
		return groupWebSocket;
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}
	
}
