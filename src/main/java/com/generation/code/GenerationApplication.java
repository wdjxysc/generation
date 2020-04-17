package com.generation.code;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;

import com.generation.code.chat.WebSocketConnectManager;
/**
 * @ClassName:  GenerationApplication   
 * @Description:TODO(启动入口)   
 * @author: 曾肖 
 * @date:   2019年5月30日 上午9:59:22   
 *     
 * @Copyright: 2019
 */
@SpringBootApplication
@ServletComponentScan()
public class GenerationApplication extends SpringBootServletInitializer {

	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(GenerationApplication.class);
    }
	
	
	public static void main(String[] args) {
		SpringApplication springApplication = new SpringApplication(GenerationApplication.class);
	    ConfigurableApplicationContext configurableApplicationContext = springApplication.run(args);
	    //解决WebSocket不能注入的问题
	    WebSocketConnectManager.setApplicationContext(configurableApplicationContext);
	}

}
