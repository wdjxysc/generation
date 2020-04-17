package ${packge};

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
/**
 * @ClassName:  ${upArtifactId}Application   
 * @Description:TODO(启动入口)   
 * @author: generation
 * @date:   ${.now?string["yyyy年MM月dd日 hh:mm:SS"]}
 * @Copyright: generation
 */
@SpringBootApplication
@ServletComponentScan()
@MapperScan("${packge}.${packgename}.*.dao")
public class ${upArtifactId}Application extends SpringBootServletInitializer{

	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(${upArtifactId}Application.class);
    }

	public static void main(String[] args) {
		SpringApplication.run(${upArtifactId}Application.class, args);
	}

}