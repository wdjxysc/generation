/**  
 * @Title:  WebSocketConfig.java   
 * @Package com.chat.room.framework   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: 曾肖
 * @date:   2019年6月28日 下午4:09:13   
 * @version V1.0 
 * @Copyright: 2019
 */
package com.generation.code.chat;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**   
 * @ClassName:  WebSocketConfig   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author: 曾肖 
 * @date:   2019年6月28日 下午4:09:13   
 *     
 * @Copyright: 2019
 */
@Configuration
public class WebSocketConfig {
	@Bean  
    public ServerEndpointExporter serverEndpointExporter() {  
        return new ServerEndpointExporter();  
    }  
}
