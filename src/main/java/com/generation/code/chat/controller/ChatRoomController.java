/**  
 * @Title:  ChatRoomController.java   
 * @Package com.generation.code.chat.controller   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: 曾肖
 * @date:   2019年7月2日 下午8:56:37   
 * @version V1.0 
 * @Copyright: 2019
 */
package com.generation.code.chat.controller;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.generation.code.chat.dao.ChatRoomDAO;
import com.generation.code.chat.vo.ChatRoomVO;
import com.generation.code.util.AppUtil;
import com.generation.code.util.IpUtils;

/**   
 * @ClassName:  ChatRoomController   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author: 曾肖 
 * @date:   2019年7月2日 下午8:56:37   
 *     
 * @Copyright: 2019
 */
@Controller
@RequestMapping("/chat/")
public class ChatRoomController {
	
	@Autowired
	private ChatRoomDAO chatRoomDAO;

	@RequestMapping("group.view")
	public String index() {
		return "/web/chatroom/index";
	}
	
	@RequestMapping("room.view")
	public String room(String uname) {
		ChatRoomVO c = new ChatRoomVO();
		c.setIp(AppUtil.getRequest().getRemoteHost());
		c.setName(uname);
		ChatRoomVO v = chatRoomDAO.getChatUser(AppUtil.getRequest().getRemoteHost());
		if(null == v) {
			if(StringUtils.isBlank(uname)) {
				return "/web/chatroom/startchat";
			}
			chatRoomDAO.addChatUser(c);
		}
		return "/web/chatroom/chatroom";
	}
	
	@RequestMapping("start.view")
	public String start() {
		return "/web/chatroom/startchat";
	}
}
