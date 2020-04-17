package com.whty.edu.brain.ig;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
/**
 * @ClassName:  IgServiceApplication   
 * @Description:TODO(启动入口)   
 * @author: generation
 * @date:   2020年04月17日 09:28:322
 * @Copyright: generation
 */
@SpringBootApplication
@ServletComponentScan()
@MapperScan("com.whty.edu.brain.ig.service.*.dao")
public class IgServiceApplication extends SpringBootServletInitializer{

	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(IgServiceApplication.class);
    }

	public static void main(String[] args) {
		SpringApplication.run(IgServiceApplication.class, args);
	}

}