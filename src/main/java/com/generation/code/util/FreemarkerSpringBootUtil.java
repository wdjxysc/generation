/**  
 * @Title:  FreemarkerUtil.java   
 * @Package com.generation.code.util   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: 曾肖
 * @date:   2019年5月30日 下午2:55:19   
 * @version V1.0 
 * @Copyright: 2019
 */
package com.generation.code.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

import org.apache.commons.collections.CollectionUtils;

import com.generation.code.constant.CommonConstant;
import com.generation.code.constant.ConnectTypeConstant;
import com.generation.code.framework.LoggerUtil;
import com.generation.code.stage.vo.ProjectAttributeVO;

import freemarker.template.Configuration;
import freemarker.template.Template;

/**   
 * @ClassName:  FreemarkerUtil   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author: 曾肖 
 * @date:   2019年5月30日 下午2:55:19   
 *     
 * @Copyright: 2019
 */
public class FreemarkerSpringBootUtil {
	
	
	/**
	 * 创建freeMarker配置实例
	 */
	public static Configuration configuration = new Configuration(Configuration.VERSION_2_3_28);
	
	
	static {
		try {
			//模板路径文件夹
			configuration.setDirectoryForTemplateLoading(new File(CommonConstant.FREEMARKER_TEMP_PATH));
			configuration.setDefaultEncoding("UTF-8");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * @Title: createProject   
	 * @Description: TODO(创建工程)   
	 * @param: @param projectAttribute
	 * @param: @throws Exception      
	 * @return: void      
	 * @throws
	 */
	public static void createProject(ProjectAttributeVO projectAttribute) throws Exception{
		String projectDir = CommonUtil.concat(CommonConstant.SRC_STAGETEMP, projectAttribute.getUpArtifactId());
		File file = new File(projectDir);
		if(file.exists()) {
			projectDir = CommonUtil.concat(projectDir, String.valueOf(System.currentTimeMillis()));
			file = new File(projectDir);
		}
		//创建工程目录
		file.mkdir();
		//创建src/main
		new File(CommonUtil.concat(projectDir, CommonConstant.SRC)).mkdir();
		new File(CommonUtil.concat(projectDir, CommonConstant.SRC_MAIN)).mkdir();
		new File(CommonUtil.concat(projectDir, CommonConstant.SRC_MAIN_JAVA)).mkdir();
		new File(CommonUtil.concat(projectDir, CommonConstant.SRC_MAIN_RESOURCES)).mkdir();
		new File(CommonUtil.concat(projectDir, CommonConstant.SRC_MAIN_WEBAPP)).mkdir();
		new File(CommonUtil.concat(projectDir, CommonConstant.SRC_MAIN_WEBAPP_VIEW)).mkdir();
		//根据包名创建java子目录
		String packges = projectAttribute.getPackgeName();
		String[] packgeArr = packges.split("\\.");
		String packgeDir = projectDir + CommonConstant.SRC_MAIN_JAVA;
		for (int i = 0; i < packgeArr.length; i++) {
			packgeDir += packgeArr[i] + CommonConstant.SRC_SEPARATE;
			new File(packgeDir).mkdir();
		}
		String frameworkDir = packgeDir + "framework/";
		String javaBusinessDir = packgeDir + "project/";
		new File(frameworkDir).mkdir();
		new File(javaBusinessDir).mkdir();
		//设置路径
		projectAttribute.setFrameworkDir(frameworkDir);
		projectAttribute.setJavaPackgeDir(javaBusinessDir);
		projectAttribute.setResourcesDir(CommonUtil.concat(projectDir, CommonConstant.SRC_MAIN_RESOURCES, CommonConstant.SRC_SEPARATE));
		projectAttribute.setWebappDir(CommonUtil.concat(projectDir, CommonConstant.SRC_MAIN_WEBAPP, CommonConstant.SRC_SEPARATE));
		projectAttribute.setProjectDir(projectDir);
		//开始执行文件生成
		LoggerUtil.info("开始生成工程");
		LoggerUtil.info("pom-------------begin");
		pom(projectAttribute);
		LoggerUtil.info("pom-------------end");
		LoggerUtil.info("启动Application.java-------------begin");
		applicationClass(projectAttribute);
		LoggerUtil.info("启动Application.java-------------end");
		LoggerUtil.info("application.properties-------------begin");
		applicationProperties(projectAttribute);
		LoggerUtil.info("application.properties-------------end");
		LoggerUtil.info("logback-spring-------------begin");
		logbackSpring(projectAttribute);
		LoggerUtil.info("logback-spring-------------end");
		LoggerUtil.info("logback-spring-------------begin");
		mybatisConfig(projectAttribute);
		LoggerUtil.info("logback-spring-------------end");
		if(projectAttribute.getJavabean() == 1 || projectAttribute.getDml() == 1) {
			LoggerUtil.info("生成javabean-------------begin");
			javabean(projectAttribute);
			LoggerUtil.info("生成javabean-------------end");
		}
		//swaggerConfiguration
		if(CollectionUtils.isNotEmpty(projectAttribute.getPlugins())) {
			if(projectAttribute.getPlugins().contains("swagger")) {
				LoggerUtil.info("生成swagger配置-------------begin");
				swaggerConfiguration(projectAttribute);
				LoggerUtil.info("生成swagger配置-------------end");
			}
		}
		if(CollectionUtils.isNotEmpty(projectAttribute.getUtils())) {
			if(projectAttribute.getUtils().contains("zip")) {
				LoggerUtil.info("生成zip工具类-------------begin");
				fileToZip(projectAttribute);
				LoggerUtil.info("生成zip工具类-------------end");
			}
			if(projectAttribute.getUtils().contains("mail")) {
				LoggerUtil.info("生成mail工具类-------------begin");
				mailUtil(projectAttribute);
				LoggerUtil.info("生成mail工具类-------------end");
			}
		}
		LoggerUtil.info("index.view-------------begin");
		viewIndex(projectAttribute);
		LoggerUtil.info("index.view-------------end");
		LoggerUtil.info("工程生成完成：" + projectAttribute.getProjectDir());
		String zip = CommonUtil.concat(CommonConstant.SRC_STAGETEMP_ZIP, CommonConstant.SRC_SEPARATE, projectAttribute.getUpArtifactId(), ".zip");
		FileOutputStream fos1 = new FileOutputStream(new File(zip));
		FileToZip.toZip(projectAttribute.getProjectDir(), fos1,true);
		LoggerUtil.info("删除" + projectDir);
		FileUtil.delete(projectDir);
	}
	/**
	 * @Title: pom   
	 * @Description: TODO(生成pom文件)   
	 * @param: @param projectAttribute
	 * @param: @throws Exception      
	 * @return: void      
	 * @throws
	 */
	public static void pom(ProjectAttributeVO projectAttribute) throws Exception{
		Writer out = null;
		//加载模板文件
		Template template = configuration.getTemplate(projectAttribute.getProjectType() + "/pom.ftl");
		//生成数据
		File docFile = new File(projectAttribute.getProjectDir() + "/pom.xml");
		out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(docFile), CommonConstant.UTF8));
		template.process(projectAttribute, out);
		out.close();
	}
	/**
	* @Title: mybatisConfig  
	* TODO MyBatis配置文件生成
	* @param projectAttribute
	* @throws Exception
	* @throws
	 */
	public static void mybatisConfig(ProjectAttributeVO projectAttribute)  throws Exception{
		Writer out = null;
		//加载模板文件
		Template template = configuration.getTemplate(projectAttribute.getProjectType() + "/mybatis-config.ftl");
		//生成数据
		File docFile = new File(CommonUtil.concat(projectAttribute.getResourcesDir(), "mybatis-config.xml"));
		out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(docFile), CommonConstant.UTF8));
		template.process(projectAttribute, out);
		out.close();
	}
	/**
	 * @Title: applicationClass   
	 * @Description: TODO(生成springboot运行文件)   
	 * @param: @param projectAttribute
	 * @param: @throws Exception      
	 * @return: void      
	 * @throws
	 */
	public static void applicationClass(ProjectAttributeVO projectAttribute) throws Exception{
		Writer out = null;
		//加载模板文件
		Template template = configuration.getTemplate(projectAttribute.getProjectType() + "/DemoApplication.ftl");
		//生成数据
		//创建src/main
		File docFile = new File(CommonUtil.concat(projectAttribute.getJavaPackgeDir(), projectAttribute.getUpArtifactId(), "Application.java"));
		out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(docFile), CommonConstant.UTF8));
		template.process(projectAttribute, out);
		out.close();
	}
	/**
	 * @Title: viewIndex   
	 * @Description: TODO(根据配置的前端主题生成前端主页)   
	 * @param: @param projectAttribute
	 * @param: @throws Exception      
	 * @return: void      
	 * @throws
	 */
	public static void viewIndex(ProjectAttributeVO projectAttribute)  throws Exception{
		//加载模板文件
		Template template = configuration.getTemplate(projectAttribute.getProjectType() + "/indexController.ftl");
		//生成数据
		//创建src/main
		File docFile = new File(CommonUtil.concat(projectAttribute.getJavaPackgeDir(), projectAttribute.getBeanpackge(), "/IndexController.java"));
		Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(docFile), CommonConstant.UTF8));
		template.process(projectAttribute, out);
		out.close();
		Template indexTemplate = configuration.getTemplate(projectAttribute.getProjectType() + "/index.ftl");
		File indexFile = new File(CommonUtil.concat(projectAttribute.getProjectDir() , "/src/main/webapp/view/index.", projectAttribute.getStaticSuffix()));
		Writer out1 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(indexFile), CommonConstant.UTF8));
		indexTemplate.process(projectAttribute, out1);
		out1.close();
	}
	/**
	 * @Title: logbackSpring   
	 * @Description: TODO(生成日志配置文件)   
	 * @param: @param projectAttribute
	 * @param: @throws Exception      
	 * @return: void      
	 * @throws
	 */
	public static void logbackSpring(ProjectAttributeVO projectAttribute) throws Exception{
		Writer out = null;
		//加载模板文件
		Template template = configuration.getTemplate(projectAttribute.getProjectType() + "/logback-spring.ftl");
		//生成数据
		File docFile = new File(CommonUtil.concat(projectAttribute.getResourcesDir(), "logback-spring.xml"));
		out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(docFile), CommonConstant.UTF8));
		template.process(projectAttribute, out);
		out.close();
	}
	/**
	 * @Title: applicationProperties   
	 * @Description: TODO(生成项目主配置文件)   
	 * @param: @param projectAttribute
	 * @param: @throws Exception      
	 * @return: void      
	 * @throws
	 */
	public static void applicationProperties(ProjectAttributeVO projectAttribute) throws Exception{
		Writer out = null;
		//加载模板文件
		Template template = configuration.getTemplate(projectAttribute.getProjectType() + "/applicationProperties.ftl");
		//生成数据
		File docFile = new File(CommonUtil.concat(projectAttribute.getResourcesDir(), "application.properties"));
		out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(docFile), CommonConstant.UTF8));
		template.process(projectAttribute, out);
		out.close();
	}
	/**
	 * @Title: javabean   
	 * @Description: TODO(生成javabean文件)   
	 * @param: @param projectAttribute
	 * @param: @throws Exception      
	 * @return: void      
	 * @throws
	 */
	public static void javabean(ProjectAttributeVO projectAttribute) throws Exception{
		new File(CommonUtil.concat(projectAttribute.getJavaPackgeDir())).mkdir();
		new File(CommonUtil.concat(projectAttribute.getJavaPackgeDir(), projectAttribute.getBeanpackge())).mkdir();
		String[] arr = projectAttribute.getGenerationTables().split(",");
		List<String> tables = Arrays.asList(arr);
		if(ConnectTypeConstant.MYSQL.equals(projectAttribute.getDriver())) {
			JdbcUtils.initMysql(projectAttribute.getDburl(), projectAttribute.getDbusername(), projectAttribute.getDbpassword(), projectAttribute.getDbname());
		}
		ExecutorService exec = Executors.newFixedThreadPool(tables.size());
		List<FutureTask<Map<String, List<Map<String, Object>>>>> taskList = new ArrayList<FutureTask<Map<String, List<Map<String, Object>>>>>();
		for (int i = 0; i < tables.size(); i++) {
			final String table = tables.get(i);
			FutureTask<Map<String, List<Map<String, Object>>>> futureTask = new FutureTask<Map<String, List<Map<String, Object>>>>(new Callable<Map<String, List<Map<String, Object>>>>() {
				@Override
				public Map<String, List<Map<String, Object>>> call() throws Exception {
					List<Map<String, Object>> l = JdbcUtils.list("select * from information_schema.columns where table_schema = ? and table_name = ?", new String[] {JdbcUtils.getDbname(), table});
					Map<String, List<Map<String, Object>>> m = new HashMap<String, List<Map<String, Object>>>(1);
					m.put(table, l);
					return m;
				}
			});
			taskList.add(futureTask);
			exec.submit(futureTask);
		}
		//key:表名，value:字段集合
		Map<String, List<Map<String, Object>>> r = new HashMap<String, List<Map<String, Object>>>(tables.size());
		for (int i = 0; i < taskList.size(); i++) {
			try {
				String key = "";
				Map<String, List<Map<String, Object>>> item = taskList.get(i).get();
				for(String ikey : item.keySet()) {
					key = ikey;
					break;
				}
				r.put(key, item.get(key));
			} catch (Exception e) {}
		}
		for(String k : r.keySet()) {
			javabeanSingle(k, r.get(k), projectAttribute);
		}
	}
	/**
	 * @Title: javabeanSingle   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @param columns
	 * @param: @param projectAttribute      
	 * @return: void      
	 * @throws
	 */
	public static void javabeanSingle(String k, List<Map<String, Object>> columns, ProjectAttributeVO projectAttribute) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		String className = new String(k);
		if(className.startsWith("t_")) {
			className = className.substring(2, className.length());
		}
		map.put("packagename", CommonUtil.concat(projectAttribute.getPackgeName(), ".", projectAttribute.getBeanpackge()));
		map.put("classname", className);
		map.put("tableName", k);
		List<String> imports = new ArrayList<String>();
		List<Map<String, String>> attributes = new ArrayList<Map<String, String>>();
		for (int i = 0; i < columns.size(); i++) {
			Map<String, Object> item = columns.get(i);
			Map<String, String> attr = new HashMap<String, String>();
			String name = String.valueOf(item.get("COLUMN_NAME"));
			String dbtype = String.valueOf(item.get("COLUMN_TYPE"));
			String type = convertJavaType(imports, String.valueOf(item.get("COLUMN_TYPE")));
			String desc = String.valueOf(item.get("COLUMN_COMMENT"));
			attr.put("name", fieldFormat(name));
			attr.put("dbname", name);
			attr.put("type", type);
			attr.put("desc", desc.replaceAll("\r\n|\r|\n", ""));
			attr.put("dbtype", dbtype.split("\\(")[0].toUpperCase(Locale.ENGLISH));
			attributes.add(attr);
		}
		map.put("imports", imports);
		map.put("attributes", attributes);
		map.put("plugins", projectAttribute.getPlugins());
		//加载模板文件
		Template template = configuration.getTemplate(projectAttribute.getProjectType() + "/vo.ftl");
		//生成数据
		// 将变量名首字母大写，得到变量的get方法
		char[] cs = fieldFormat(className).toCharArray();
		cs[0] -= 32;
		map.put("formatClassName", String.valueOf(cs));
		String vosrc = CommonUtil.concat(projectAttribute.getJavaPackgeDir(), projectAttribute.getBeanpackge(), CommonConstant.SRC_SEPARATE, "/vo/");
		if(!new File(vosrc).exists()) {
			new File(vosrc).mkdir();
		}
		File docFile = new File(CommonUtil.concat(vosrc, String.valueOf(cs), "VO.java"));
		Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(docFile), CommonConstant.UTF8));
		template.process(map, out);
		out.close();
		if(projectAttribute.getDml() == 1) {
			Template responseModeTemplate = configuration.getTemplate(projectAttribute.getProjectType() + "/ResponseModel.ftl");
			String configDir = CommonUtil.concat(projectAttribute.getFrameworkDir(), "/config/");
			if(!new File(configDir).exists()) {
				new File(configDir).mkdir();
			}
			map.put("configpackge", projectAttribute.getPackgeName());
			File responseModelFile = new File(CommonUtil.concat(configDir, "ResponseModel.java"));
			Writer out1 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(responseModelFile), CommonConstant.UTF8));
			responseModeTemplate.process(projectAttribute, out1);
			out1.close();
			String daodir = CommonUtil.concat(projectAttribute.getJavaPackgeDir(), projectAttribute.getBeanpackge(), CommonConstant.SRC_SEPARATE, "/dao/");
			if(!new File(daodir).exists()) {
				new File(daodir).mkdir();
			}
			String mapperdir = CommonUtil.concat(projectAttribute.getJavaPackgeDir(), projectAttribute.getBeanpackge(), CommonConstant.SRC_SEPARATE, "/dao/mapper/");
			if(!new File(mapperdir).exists()) {
				new File(mapperdir).mkdir();
			}
			String servicedir = CommonUtil.concat(projectAttribute.getJavaPackgeDir(), projectAttribute.getBeanpackge(), CommonConstant.SRC_SEPARATE, "/service/");
			if(!new File(servicedir).exists()) {
				new File(servicedir).mkdir();
			}
			String impldir = CommonUtil.concat(projectAttribute.getJavaPackgeDir(), projectAttribute.getBeanpackge(), CommonConstant.SRC_SEPARATE, "/service/impl/");
			if(!new File(impldir).exists()) {
				new File(impldir).mkdir();
			}
			String controllerdir = CommonUtil.concat(projectAttribute.getJavaPackgeDir(), projectAttribute.getBeanpackge(), CommonConstant.SRC_SEPARATE, "/controller/");
			if(!new File(controllerdir).exists()) {
				new File(controllerdir).mkdir();
			}
			//mapper
			//加载模板文件
			Template mapperTemplate = configuration.getTemplate(projectAttribute.getProjectType() + "/mapper.ftl");
			//生成数据
			File mapperFile = new File(CommonUtil.concat(mapperdir, String.valueOf(cs), "Mapper.xml"));
			Writer out2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(mapperFile), CommonConstant.UTF8));
			mapperTemplate.process(map, out2);
			out2.close();
			//dao
			//加载模板文件
			Template daoTemplate = configuration.getTemplate(projectAttribute.getProjectType() + "/dao.ftl");
			//生成数据
			File daoFile = new File(CommonUtil.concat(daodir, String.valueOf(cs), "DAO.java"));
			Writer out3 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(daoFile), CommonConstant.UTF8));
			daoTemplate.process(map, out3);
			out3.close();
			//service
			//加载模板文件
			Template serviceTemplate = configuration.getTemplate(projectAttribute.getProjectType() + "/service.ftl");
			//生成数据
			File serviceFile = new File(CommonUtil.concat(servicedir, String.valueOf(cs), "Service.java"));
			Writer out4 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(serviceFile), CommonConstant.UTF8));
			serviceTemplate.process(map, out4);
			out4.close();
			//impl
			//加载模板文件
			Template serviceImplTemplate = configuration.getTemplate(projectAttribute.getProjectType() + "/impl.ftl");
			//生成数据
			File serviceImplFile = new File(CommonUtil.concat(impldir, String.valueOf(cs), "ServiceImpl.java"));
			Writer out5 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(serviceImplFile), CommonConstant.UTF8));
			serviceImplTemplate.process(map, out5);
			out5.close();
			//controller
			//加载模板文件
			Template controllerTemplate = configuration.getTemplate(projectAttribute.getProjectType() + "/controller.ftl");
			//生成数据
			File controllerFile = new File(CommonUtil.concat(controllerdir, String.valueOf(cs), "Controller.java"));
			Writer out6 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(controllerFile), CommonConstant.UTF8));
			controllerTemplate.process(map, out6);
			out6.close();
		}
	}
	/**
	 * @Title: swaggerConfiguration   
	 * @Description: TODO 生成swaggerConfiguration
	 * @param: @param projectAttribute
	 * @param: @throws Exception      
	 * @return: void      
	 * @throws
	 */
	public static void swaggerConfiguration(ProjectAttributeVO projectAttribute) throws Exception {
		Writer out = null;
		//加载模板文件
		Template template = configuration.getTemplate(projectAttribute.getProjectType() + "/SwaggerConfiguration.ftl");
		//生成数据
		//创建src/main
		String configDir = CommonUtil.concat(projectAttribute.getFrameworkDir(), "/config/");
		if(!new File(configDir).exists()) {
			new File(configDir).mkdir();
		}
		File docFile = new File(CommonUtil.concat(configDir, "SwaggerConfiguration.java"));
		out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(docFile), CommonConstant.UTF8));
		template.process(projectAttribute, out);
		out.close();
	}
	/**
	 * @Title: fileToZip   
	 * @Description: TODO(压缩工具类)   
	 * @param: @param projectAttribute
	 * @param: @throws Exception      
	 * @return: void      
	 * @throws
	 */
	public static void fileToZip(ProjectAttributeVO projectAttribute) throws Exception{
		Writer out = null;
		//加载模板文件
		Template template = configuration.getTemplate(projectAttribute.getProjectType() + "/FileToZip.ftl");
		//生成数据
		//创建src/main
		String utilDir = CommonUtil.concat(projectAttribute.getFrameworkDir(), "/util/");
		if(!new File(utilDir).exists()) {
			new File(utilDir).mkdir();
		}
		File docFile = new File(CommonUtil.concat(utilDir, "FileToZip.java"));
		out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(docFile), CommonConstant.UTF8));
		template.process(projectAttribute, out);
		out.close();
	}
	/**
	 * @Title: fileToZip   
	 * @Description: TODO(邮件发送类)   
	 * @param: @param projectAttribute
	 * @param: @throws Exception      
	 * @return: void      
	 * @throws
	 */
	public static void mailUtil(ProjectAttributeVO projectAttribute) throws Exception{
		Writer out = null;
		//加载模板文件
		Template template = configuration.getTemplate(projectAttribute.getProjectType() + "/mailUtil.ftl");
		//生成数据
		//创建src/main
		String utilDir = CommonUtil.concat(projectAttribute.getFrameworkDir(), "/util/");
		if(!new File(utilDir).exists()) {
			new File(utilDir).mkdir();
		}
		File docFile = new File(CommonUtil.concat(utilDir, "MailUtil.java"));
		out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(docFile), CommonConstant.UTF8));
		template.process(projectAttribute, out);
		out.close();
	}
	/**
	 * @Title: convertJavaType   
	 * @Description: TODO(类型匹配)   
	 * @param: @param imports
	 * @param: @param type
	 * @param: @return      
	 * @return: String      
	 * @throws
	 */
	public static String convertJavaType(List<String> imports, String type) {
		type = (type.split("\\(")[0]).trim().toUpperCase(Locale.ENGLISH);
		if("VARCHAR".equals(type) || "BLOB".equals(type) || "TEXT".equals(type)) {
			return "String";
		}
		if("BIGINT".equals(type)) {
			return "Long";
		}
		if("DATE".equals(type) || "DATETIME".equals(type) || "TIMESTAMP".equals(type)) {
			if(!imports.contains("java.util.Date")) {
				imports.add("java.util.Date");
			}
			return "Date";
		}
		if("INT".equals(type) || "SMALLINT".equals(type) || "TINYINT".equals(type)) {
			return "Integer";
		}
		if("DOUBLE".equals(type) || "DECIMAL".equals(type) || "FLOAT".equals(type)) {
			if(!imports.contains("java.math.BigDecimal")) {
				imports.add("java.math.BigDecimal");
			}
			return "BigDecimal";
		}
		return type;
	}
	/**
	 * @Title: fieldFormat   
	 * @Description: TODO(字段名格式化)   
	 * @param: @param column
	 * @param: @return      
	 * @return: String      
	 * @throws
	 */
	public static String fieldFormat(String column) {
		List<String> list = new ArrayList<String>();
		if(column.contains("_")) {
			list = Arrays.asList(column.split("_"));
		}else if(column.contains("-")) {
			list = Arrays.asList(column.split("-"));
		}else if(column.contains(".")) {
			list = Arrays.asList(column.split("\\."));
		}else {
			list.add(column);
		}
		StringBuffer sb = new StringBuffer();
		sb.append(list.get(0));
		for (int i = 1; i < list.size(); i++) {
			char[] cs = list.get(i).toCharArray();
			cs[0] -= 32;
			sb.append(String.valueOf(cs));
		}
		return sb.toString(); 
	}
}
