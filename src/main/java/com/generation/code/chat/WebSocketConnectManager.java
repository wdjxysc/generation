/**  
 * @Title:  ChatPersonVO.java   
 * @Package com.generation.code.chat   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: 曾肖
 * @date:   2019年7月3日 上午10:47:49   
 * @version V1.0 
 * @Copyright: 2019
 */
package com.generation.code.chat;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.websocket.Session;

import org.springframework.context.ApplicationContext;

import com.generation.code.util.IpUtils;

/**   
 * @ClassName:  ChatPersonVO   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author: 曾肖 
 * @date:   2019年7月3日 上午10:47:49   
 *     
 * @Copyright: 2019
 */
public class WebSocketConnectManager {
	
	/**
	 * 	此处是解决无法注入的关键
	 */
	private static ApplicationContext applicationContext;
		
	/**
	 * 	concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象。若要实现服务端与单一客户端通信的话，可以使用Map来存放，其中Key可以为用户标识
	 */
	private static Map<String, WebSocketConnect> webSocketMap = new ConcurrentHashMap<String, WebSocketConnect>();
	/**
	 * 	聊天室分配信息
	 */
	private static Map<String, List<String>> groupWebSocketSessionId = new ConcurrentHashMap<String, List<String>>();
	
	/**
	 * @Title: getConnect   
	 * @Description: 获取连接
	 * @param: @param key
	 * @param: @return      
	 * @return: WebSocketConnect      
	 * @throws
	 */
	public static WebSocketConnect getConnect(String key) {
		return webSocketMap.get(key);
	}
	/**
	 * @Title: setConnect   
	 * @Description: 设置新增连接
	 * @param: @param key
	 * @param: @param connect      
	 * @return: void      
	 * @throws
	 */
	public static void setConnect(WebSocketConnect connect) {
		String ip = IpUtils.getIp(connect.getSession());
		if(!webSocketMap.containsKey(ip)) {
			webSocketMap.put(ip, connect);
		}
	}
	/**
	 * @Title: removeConnect   
	 * @Description: 移除连接   
	 * @param: @param connect      
	 * @return: void      
	 * @throws
	 */
	public static void removeConnect(Session session) {
		webSocketMap.remove(IpUtils.getIp(session));
	}
	/**
	 * @Title: containsKey   
	 * @Description: 校验是否已加入某个连接
	 * @param: @param key
	 * @param: @return      
	 * @return: boolean      
	 * @throws
	 */
	public static boolean containsKey(String key) {
		return webSocketMap.containsKey(key);
	}
	/**
	 * @Title: addGroup   
	 * @Description: 聊天室添加连接session
	 * @param: @param groupKey
	 * @param: @param sessionId      
	 * @return: void      
	 * @throws
	 */
	public static void addGroup(String groupKey, Session session) {
		List<String> ips = new ArrayList<String>();
		if(groupWebSocketSessionId.containsKey(groupKey)) {
			ips = groupWebSocketSessionId.get(groupKey);
		}
		ips.add(IpUtils.getIp(session));
		groupWebSocketSessionId.put(groupKey, ips);
	}
	/**
	 * @Title: removeGroupMember   
	 * @Description: 从聊天室移除
	 * @param: @param key
	 * @param: @param sessionId      
	 * @return: void      
	 * @throws
	 */
	public static void removeGroupMember(String key, Session session) {
		if(groupWebSocketSessionId.containsKey(key)) {
			groupWebSocketSessionId.get(key).remove(IpUtils.getIp(session));
		}
	}
	/**
	 * @Title: getGroup   
	 * @Description: 获取聊天室session集合
	 * @param: @param key
	 * @param: @return      
	 * @return: List<String>      
	 * @throws
	 */
	public static List<String> getGroup(String key){
		List<String> ips = groupWebSocketSessionId.get(key);
		if(org.apache.commons.collections.CollectionUtils.isEmpty(ips)) {
			ips =  new ArrayList<String>();
		}
		return ips;
	}
	public static void setApplicationContext(ApplicationContext applicationContext) {
		WebSocketConnectManager.applicationContext = applicationContext;
	}
	public static <T> T getBean(Class<T> classz) {
		return WebSocketConnectManager.applicationContext.getBean(classz);
	}
}