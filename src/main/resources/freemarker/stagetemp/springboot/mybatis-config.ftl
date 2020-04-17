<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE configuration PUBLIC "-//mybatis.org//DTO Config 3.0//EN"
"http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
	<settings>
		<setting name="logImpl" value="STDOUT_LOGGING" />
	</settings>
    <#if plugins?exists>
	    <#list plugins as plugin>
	      <#if plugin=="pagehelper">
	        <!-- 配置mybatis的分页插件PageHelper -->
		    <plugins>
		        <plugin interceptor="com.github.pagehelper.PageInterceptor">
		        </plugin>
		    </plugins>
	      </#if>
	    </#list>
	    </#if>
</configuration>