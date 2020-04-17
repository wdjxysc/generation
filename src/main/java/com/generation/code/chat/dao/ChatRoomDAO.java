/**  
 * @Title:  ChatRoomDAO.java   
 * @Package com.generation.code.chat.dao   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: 曾肖
 * @date:   2019年7月3日 下午1:51:29   
 * @version V1.0 
 * @Copyright: 2019
 */
package com.generation.code.chat.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.generation.code.chat.vo.ChatRoomVO;

/**   
 * @ClassName:  ChatRoomDAO   
 * @Description:聊天室dao操作
 * @author: 曾肖 
 * @date:   2019年7月3日 下午1:51:29   
 *     
 * @Copyright: 2019
 */
@Mapper
@Repository
public interface ChatRoomDAO {
	
	void addChatUser(ChatRoomVO chatuser);
	
	ChatRoomVO getChatUser(String ip);
}
