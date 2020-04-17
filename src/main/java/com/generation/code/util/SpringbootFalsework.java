/**  
 * @Title:  SpringbootFalsework.java   
 * @Package com.generation.code.util   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: 曾肖
 * @date:   2019年7月8日 下午4:12:27   
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

import com.generation.code.constant.CommonConstant;
import com.generation.code.framework.LoggerUtil;

import freemarker.template.Configuration;
import freemarker.template.Template;

/**   
 * @ClassName:  SpringbootFalsework   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author: 曾肖 
 * @date:   2019年7月8日 下午4:12:27   
 *     
 * @Copyright: 2019
 */
public class SpringbootFalsework {
	
	
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
	public SpringbootFalsework(Map<String, Object> map) {
		this.groupId = String.valueOf(map.get("groupId"));
		this.artifactId = String.valueOf(map.get("artifactId"));
		this.dburl = String.valueOf(map.get("dburl"));
		this.dbname = String.valueOf(map.get("dbname"));
		this.dbpasswor = String.valueOf(map.get("dbpassowrd"));
		this.packgeName = String.valueOf(map.get("packgename"));
		this.dbPackgeName = String.valueOf(map.get("dbpackgename"));
		this.tables = String.valueOf(map.get("tables"));
		this.database = String.valueOf(map.get("database"));
	}
	/**
	 * @Title: build   
	 * @Description: 构建工程
	 * void      
	 * @throws
	 */
	public void build() throws Exception{
		//创建工程目录
		String projectDir = CommonUtil.concat(CommonConstant.SRC_STAGETEMP, this.artifactId);
		this.projectDir = projectDir;
		File file = new File(projectDir);
		if(file.exists()) {
			projectDir = CommonUtil.concat(projectDir, String.valueOf(System.currentTimeMillis()));
			file = new File(projectDir);
		}
		file.mkdir();
		initDir();
		pom();
		applicationRunClass();
		String[] utils = {"StringUtil", "FileToZip", "FileUtil", "MailUtil", "WebUtil"};
		for (int i = 0; i < utils.length; i++) {
			util(utils[i]);
		}
		String[] verifyAnnotations = {"AnnotationHandle", "EnumRange", "Max", "MaxLength", "Min", "MinLength", "NotEmpty", "Regular", "Verify", "VerifyType"};
		for (int i = 0; i < verifyAnnotations.length; i++) {
			verifyAnnotation(verifyAnnotations[i]);
		}
		String[] verifyAnnotationImpls = {"EnumRangeHandle", "MaxHandle", "MaxLengthHandle", "MinHandle", "MinLengthHandle", "NotEmptyHandle", "RegularHandle"};
		for (int i = 0; i < verifyAnnotationImpls.length; i++) {
			verifyAnnotationImpl(verifyAnnotationImpls[i]);
		}
		verifyControllerHandle();
		verifyHandle();
		String[] annotations = {"ApiParamsVerify"};
		for (int i = 0; i < annotations.length; i++) {
			annotation(annotations[i]);
		}
		String[] aspects = {"VerifyMethodAspect"};
		for (int i = 0; i < aspects.length; i++) {
			aspects(aspects[i]);
		}
		String[] configs = {"ResponseModel", "SpringContextHolder", "ThreadLocalVariableFilter", "ThreadLocalVariableHolder"};
		for (int i = 0; i < configs.length; i++) {
			configs(configs[i]);
		}
		String[] constants = {"RegularConstant"};
		for (int i = 0; i < constants.length; i++) {
			constants(constants[i]);
		}
		String[] exceptions = {"CommonDefineException", "CommonDefineExceptionHandle"};
		for (int i = 0; i < exceptions.length; i++) {
			exceptions(exceptions[i]);
		}
		appIndexController();
		appIndexView();
		mybatisConfigXml();
		logbackSpringXml();
		applicationProperties();
		javabean();
	}
	/**
	* @Title: pom  
	* TODO 生成pom文件
	* @throws Exception
	* @throws
	 */
	public void pom() throws Exception{
		LoggerUtil.info("开始生成工程");
		LoggerUtil.info("pom-------------begin");
		Writer out = null;
		Template template = configuration.getTemplate("springboot/pom.ftl");
		File docFile = new File(CommonUtil.concat(projectDir, "/pom.xml"));
		out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(docFile), CommonConstant.UTF8));
		Map<String, String> attribute = new HashMap<String, String>();
		attribute.put("groupId", groupId);
		attribute.put("artifactId", artifactId);
		template.process(attribute, out);
		out.close();
		LoggerUtil.info("pom-------------end");
		LoggerUtil.info("启动Application.java-------------begin");
	}
	/**
	* @Title: applicationRunClass  
	* TODO 生成启动文件
	* @throws Exception
	* @throws
	 */
	public void applicationRunClass() throws Exception{
		Writer out = null;
		Template template = configuration.getTemplate("springboot/DemoApplication.ftl");
		File docFile = new File(CommonUtil.concat(srcMainJavaDir, groupId.replaceAll("\\.", "/"), CommonConstant.SRC_SEPARATE, getUpArtifactId(), "Application.java"));
		out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(docFile), CommonConstant.UTF8));
		Map<String, String> attribute = new HashMap<String, String>();
		attribute.put("upArtifactId", getUpArtifactId());
		attribute.put("packge", groupId);
		attribute.put("packgename", packgeName);
		template.process(attribute, out);
		out.close();
	}
	public void appIndexController() throws Exception{
		Writer out = null;
		Template template = configuration.getTemplate("springboot/IndexController.ftl");
		File docFile = new File(CommonUtil.concat(srcMainJavaDir, groupId.replaceAll("\\.", "/"), CommonConstant.SRC_SEPARATE, packgeName, CommonConstant.SRC_SEPARATE, "IndexController.java"));
		out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(docFile), CommonConstant.UTF8));
		Map<String, String> attribute = new HashMap<String, String>();
		attribute.put("upArtifactId", getUpArtifactId());
		attribute.put("packgeName", groupId);
		attribute.put("beanpackge", packgeName);
		template.process(attribute, out);
		out.close();
	}
	public void appIndexView() throws Exception{
		Writer out = null;
		Template template = configuration.getTemplate("springboot/index.ftl");
		File docFile = new File(CommonUtil.concat(srcMainWebappViewDir, CommonConstant.SRC_SEPARATE, "index.html"));
		out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(docFile), CommonConstant.UTF8));
		template.process(null, out);
		out.close();
	}
	public void mybatisConfigXml() throws Exception{
		Writer out = null;
		Template template = configuration.getTemplate("springboot/mybatis-config.ftl");
		File docFile = new File(CommonUtil.concat(srcMainResourceDir, "mybatis-config.xml"));
		out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(docFile), CommonConstant.UTF8));
		template.process(null, out);
		out.close();
	}
	public void logbackSpringXml() throws Exception{
		Writer out = null;
		Template template = configuration.getTemplate("springboot/logback-spring.ftl");
		File docFile = new File(CommonUtil.concat(srcMainResourceDir, "logback-spring.xml"));
		out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(docFile), CommonConstant.UTF8));
		template.process(this, out);
		out.close();
	}
	
	public void applicationProperties() throws Exception{
		Writer out = null;
		Template template = configuration.getTemplate("springboot/applicationProperties.ftl");
		File docFile = new File(CommonUtil.concat(srcMainResourceDir, "application.properties"));
		out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(docFile), CommonConstant.UTF8));
		Map<String, String> attribute = new HashMap<String, String>();
		attribute.put("mapperDir", "classpath*:" + groupId.replaceAll("\\.", "/") + "/**/dao/mapper/*xml");
		attribute.put("dburl", dburl);
		attribute.put("dbusername", dbname);
		attribute.put("dbpassword", dbpasswor);
		template.process(attribute, out);
		out.close();
	}
	/**
	* @Title: util  
	* TODO 生成工具类
	* @param fileName
	* @throws Exception
	* @throws
	 */
	public void util(String fileName) throws Exception {
		Writer out = null;
		Template template = configuration.getTemplate(CommonUtil.concat("springboot/util/", fileName, ".ftl"));
		File docFile = new File(CommonUtil.concat(srcMainJavaFrameworkUtilDir, fileName, ".java"));
		out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(docFile), CommonConstant.UTF8));
		Map<String, String> attribute = new HashMap<String, String>();
		attribute.put("packge", groupId);
		template.process(attribute, out);
		out.close();
	}
	/**
	* @Title: verifyAnnotation  
	* TODO 生成校验注解
	* @param annoName
	* @throws Exception
	* @throws
	 */
	public void verifyAnnotation(String annoName) throws Exception{
		Writer out = null;
		Template template = configuration.getTemplate(CommonUtil.concat("springboot/verify/annotation/", annoName, ".ftl"));
		File docFile = new File(CommonUtil.concat(srcMainJavaFrameworkVerifyAnnotationDir, annoName, ".java"));
		out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(docFile), CommonConstant.UTF8));
		Map<String, String> attribute = new HashMap<String, String>();
		attribute.put("packgeName", groupId);
		template.process(attribute, out);
		out.close();
	}
	/**
	* @Title: verifyAnnotationImpl  
	* TODO 生成校验注解实现
	* @param implName
	* @throws Exception
	* @throws
	 */
	public void verifyAnnotationImpl(String implName) throws Exception{
		Writer out = null;
		Template template = configuration.getTemplate(CommonUtil.concat("springboot/verify/impl/", implName, ".ftl"));
		File docFile = new File(CommonUtil.concat(srcMainJavaFrameworkVerifyImplDir, implName, ".java"));
		out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(docFile), CommonConstant.UTF8));
		Map<String, String> attribute = new HashMap<String, String>();
		attribute.put("packgeName", groupId);
		template.process(attribute, out);
		out.close();
	}
	/**
	* @Title: verifyControllerHandle  
	* TODO 生成注解遍历校验类
	* @throws Exception
	* @throws
	 */
	public void verifyControllerHandle() throws Exception{
		Writer out = null;
		Template template = configuration.getTemplate(CommonUtil.concat("springboot/verify/VerifyControllerHandle.ftl"));
		File docFile = new File(CommonUtil.concat(srcMainJavaFrameworkVerifyDir, "VerifyControllerHandle.java"));
		out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(docFile), CommonConstant.UTF8));
		Map<String, String> attribute = new HashMap<String, String>();
		attribute.put("packgeName", groupId);
		template.process(attribute, out);
		out.close();
	}
	/**
	* @Title: verifyHandle  
	* TODO 生成注解校验接口类
	* @throws Exception
	* @throws
	 */
	public void verifyHandle() throws Exception{
		Writer out = null;
		Template template = configuration.getTemplate(CommonUtil.concat("springboot/verify/VerifyHandle.ftl"));
		File docFile = new File(CommonUtil.concat(srcMainJavaFrameworkVerifyDir, "VerifyHandle.java"));
		out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(docFile), CommonConstant.UTF8));
		Map<String, String> attribute = new HashMap<String, String>();
		attribute.put("packgeName", groupId);
		template.process(attribute, out);
		out.close();
	}
	/**
	* @Title: annotation  
	* TODO 生成注解
	* @param annotationName
	* @throws Exception
	* @throws
	 */
	public void annotation(String annotationName) throws Exception{
		Writer out = null;
		Template template = configuration.getTemplate(CommonUtil.concat("springboot/annotation/", annotationName, ".ftl"));
		File docFile = new File(CommonUtil.concat(srcMainJavaFrameworkAnnotationDir, annotationName, ".java"));
		out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(docFile), CommonConstant.UTF8));
		Map<String, String> attribute = new HashMap<String, String>();
		attribute.put("packgeName", groupId);
		template.process(attribute, out);
		out.close();
	}
	/**
	* @Title: aspects  
	* TODO 生成切面
	* @param aspectName
	* @throws Exception
	* @throws
	 */
	public void aspects(String aspectName) throws Exception{
		Writer out = null;
		Template template = configuration.getTemplate(CommonUtil.concat("springboot/aspect/", aspectName, ".ftl"));
		File docFile = new File(CommonUtil.concat(srcMainJavaFrameworkAspectDir, aspectName, ".java"));
		out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(docFile), CommonConstant.UTF8));
		Map<String, String> attribute = new HashMap<String, String>();
		attribute.put("packgeName", groupId);
		template.process(attribute, out);
		out.close();
	}
	/**
	* @Title: configs  
	* TODO 配置文件生成
	* @param configName
	* @throws Exception
	* @throws
	 */
	public void configs(String configName) throws Exception{
		Writer out = null;
		Template template = configuration.getTemplate(CommonUtil.concat("springboot/config/", configName, ".ftl"));
		File docFile = new File(CommonUtil.concat(srcMainJavaFrameworkConfigDir, configName, ".java"));
		out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(docFile), CommonConstant.UTF8));
		Map<String, String> attribute = new HashMap<String, String>();
		attribute.put("packgeName", groupId);
		template.process(attribute, out);
		out.close();
	}
	/**
	* @Title: constants  
	* TODO 生成常量文件
	* @param constantName
	* @throws Exception
	* @throws
	 */
	public void constants(String constantName) throws Exception{
		Writer out = null;
		Template template = configuration.getTemplate(CommonUtil.concat("springboot/constant/", constantName, ".ftl"));
		File docFile = new File(CommonUtil.concat(srcMainJavaFrameworkConstantDir, constantName, ".java"));
		out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(docFile), CommonConstant.UTF8));
		Map<String, String> attribute = new HashMap<String, String>();
		attribute.put("packgeName", groupId);
		template.process(attribute, out);
		out.close();
	}
	/**
	* @Title: exceptions  
	* TODO 异常处理类
	* @param exceptionName
	* @throws Exception
	* @throws
	 */
	public void exceptions(String exceptionName) throws Exception{
		Writer out = null;
		Template template = configuration.getTemplate(CommonUtil.concat("springboot/exception/", exceptionName, ".ftl"));
		File docFile = new File(CommonUtil.concat(srcMainJavaFrameworkExceptionDir, exceptionName, ".java"));
		out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(docFile), CommonConstant.UTF8));
		Map<String, String> attribute = new HashMap<String, String>();
		attribute.put("packgeName", groupId);
		template.process(attribute, out);
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
	public void javabean() throws Exception{
		List<String> tablelist = Arrays.asList(tables.split(","));
		JdbcUtils.initMysql(dburl, dbname, dbpasswor, database);
		ExecutorService exec = Executors.newFixedThreadPool(tablelist.size());
		List<FutureTask<Map<String, List<Map<String, Object>>>>> taskList = new ArrayList<FutureTask<Map<String, List<Map<String, Object>>>>>();
		for (int i = 0; i < tablelist.size(); i++) {
			final String table = tablelist.get(i);
			final String dbName = new String(database);
			FutureTask<Map<String, List<Map<String, Object>>>> futureTask = new FutureTask<Map<String, List<Map<String, Object>>>>(new Callable<Map<String, List<Map<String, Object>>>>() {
				@Override
				public Map<String, List<Map<String, Object>>> call() throws Exception {
					List<Map<String, Object>> l = JdbcUtils.list("select * from information_schema.columns where table_schema = ? and table_name = ?", new String[] {dbName, table});
					Map<String, List<Map<String, Object>>> m = new HashMap<String, List<Map<String, Object>>>(1);
					m.put(table, l);
					return m;
				}
			});
			taskList.add(futureTask);
			exec.submit(futureTask);
		}
		//key:表名，value:字段集合
		Map<String, List<Map<String, Object>>> r = new HashMap<String, List<Map<String, Object>>>(tablelist.size());
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
			javabeanSingle(k, r.get(k));
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
	public void javabeanSingle(String k, List<Map<String, Object>> columns) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		String className = new String(k);
		if(className.startsWith("t_")) {
			className = className.substring(2, className.length());
		}
		map.put("packagename", CommonUtil.concat(groupId,"." , packgeName,".", dbPackgeName));
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
		map.put("groupId", groupId);
		//加载模板文件
		Template template = configuration.getTemplate("springboot/project/vo.ftl");
		//生成数据
		// 将变量名首字母大写，得到变量的get方法
		char[] cs = fieldFormat(className).toCharArray();
		cs[0] -= 32;
		map.put("formatClassName", String.valueOf(cs));
		File docFile = new File(CommonUtil.concat(srcMainJavaProjectDbVODir, String.valueOf(cs), "VO.java"));
		Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(docFile), CommonConstant.UTF8));
		template.process(map, out);
		out.close();
		//mapper
		//加载模板文件
		Template mapperTemplate = configuration.getTemplate("springboot/project/mapper.ftl");
		//生成数据
		File mapperFile = new File(CommonUtil.concat(srcMainJavaProjectDbMapperDir, String.valueOf(cs), "Mapper.xml"));
		Writer out2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(mapperFile), CommonConstant.UTF8));
		mapperTemplate.process(map, out2);
		out2.close();
		//dao
		//加载模板文件
		Template daoTemplate = configuration.getTemplate("springboot/project/dao.ftl");
		//生成数据
		File daoFile = new File(CommonUtil.concat(srcMainJavaProjectDbDAODir, String.valueOf(cs), "DAO.java"));
		Writer out3 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(daoFile), CommonConstant.UTF8));
		daoTemplate.process(map, out3);
		out3.close();
		//service
		//加载模板文件
		Template serviceTemplate = configuration.getTemplate("springboot/project/service.ftl");
		//生成数据
		File serviceFile = new File(CommonUtil.concat(srcMainJavaProjectDbServiceDir, String.valueOf(cs), "Service.java"));
		Writer out4 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(serviceFile), CommonConstant.UTF8));
		serviceTemplate.process(map, out4);
		out4.close();
		//impl
		//加载模板文件
		Template serviceImplTemplate = configuration.getTemplate("springboot/project/impl.ftl");
		//生成数据
		File serviceImplFile = new File(CommonUtil.concat(srcMainJavaProjectDbServiceImplDir, String.valueOf(cs), "ServiceImpl.java"));
		Writer out5 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(serviceImplFile), CommonConstant.UTF8));
		serviceImplTemplate.process(map, out5);
		out5.close();
		//controller
		//加载模板文件
		Template controllerTemplate = configuration.getTemplate("springboot/project/controller.ftl");
		//生成数据
		File controllerFile = new File(CommonUtil.concat(srcMainJavaProjectDbControllerDir, String.valueOf(cs), "Controller.java"));
		Writer out6 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(controllerFile), CommonConstant.UTF8));
		controllerTemplate.process(map, out6);
		out6.close();
	}
	
	
	private String groupId;
	
	private String artifactId;
	
	private String packgeName;
	
	private String dbPackgeName;
	
	private String projectDir;
	
	private String dburl;
	
	private String dbname;
	
	private String dbpasswor;
	
	private String tables;
	
	private String srcDir;
	
	private String srcMainDir;
	
	private String srcMainJavaDir;
	
	private String srcMainJavaFrameworkDir;
	
	private String srcMainJavaFrameworkUtilDir;
	
	private String srcMainJavaFrameworkAspectDir;
	
	private String srcMainJavaFrameworkAnnotationDir;
	
	private String srcMainJavaFrameworkConfigDir;
	
	private String srcMainJavaFrameworkConstantDir;
	
	private String srcMainJavaFrameworkExceptionDir;
	
	private String srcMainJavaFrameworkVerifyDir;
	
	private String srcMainJavaFrameworkVerifyAnnotationDir;
	
	private String srcMainJavaFrameworkVerifyImplDir;
	
	private String srcMainJavaFrameworkLocalthread;
	
	private String srcMainJavaProjectDir;
	
	private String srcMainJavaProjectDbDir;
	
	private String srcMainJavaProjectDbVODir;
	
	private String srcMainJavaProjectDbControllerDir;
	
	private String srcMainJavaProjectDbDAODir;
	
	private String srcMainJavaProjectDbServiceDir;
	
	private String srcMainJavaProjectDbMapperDir;
	
	private String srcMainJavaProjectDbServiceImplDir;
	
	private String srcMainResourceDir;
	
	private String srcMainWebappDir;
	
	private String srcMainWebappViewDir;
	
	private String mainpackge;
	
	private String packgeFrameworkUtil;
	
	private String packgeFrameworkAspect;
	
	private String packgeFrameworkAnnotation;
	
	private String packgeFrameworkConfig;
	
	private String packgeFrameworkConstant;
	
	private String packgeFrameworkException;
	
	private String packgeFrameworkVerify;
	
	private String packgeFrameworkVerifyAnnotation;
	
	private String packgeFrameworkVerifyImpl;
	
	private String packgeFrameworkLocalthread;
	
	private String packgeVO;
	
	private String packgeController;
	
	private String packgeDAO;
	
	private String packgeMapper;
	
	private String packgeService;
	
	private String packgeServiceImpl;
	
	private String database;
	
	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getArtifactId() {
		return artifactId;
	}

	public void setArtifactId(String artifactId) {
		this.artifactId = artifactId;
	}

	public String getPackgeName() {
		return packgeName;
	}

	public void setPackgeName(String packgeName) {
		this.packgeName = packgeName;
	}

	public String getDbPackgeName() {
		return dbPackgeName;
	}

	public void setDbPackgeName(String dbPackgeName) {
		this.dbPackgeName = dbPackgeName;
	}

	public static Configuration getConfiguration() {
		return configuration;
	}

	public static void setConfiguration(Configuration configuration) {
		SpringbootFalsework.configuration = configuration;
	}
	public String getProjectDir() {
		return projectDir;
	}
	public void setProjectDir(String projectDir) {
		this.projectDir = projectDir;
	}
	public String getSrcDir() {
		return srcDir;
	}
	public void setSrcDir(String srcDir) {
		this.srcDir = srcDir;
	}
	public String getSrcMainDir() {
		return srcMainDir;
	}
	public void setSrcMainDir(String srcMainDir) {
		this.srcMainDir = srcMainDir;
	}
	public String getSrcMainJavaDir() {
		return srcMainJavaDir;
	}
	public void setSrcMainJavaDir(String srcMainJavaDir) {
		this.srcMainJavaDir = srcMainJavaDir;
	}
	public String getSrcMainJavaFrameworkDir() {
		return srcMainJavaFrameworkDir;
	}
	public void setSrcMainJavaFrameworkDir(String srcMainJavaFrameworkDir) {
		this.srcMainJavaFrameworkDir = srcMainJavaFrameworkDir;
	}
	public String getSrcMainJavaFrameworkUtilDir() {
		return srcMainJavaFrameworkUtilDir;
	}
	public void setSrcMainJavaFrameworkUtilDir(String srcMainJavaFrameworkUtilDir) {
		this.srcMainJavaFrameworkUtilDir = srcMainJavaFrameworkUtilDir;
	}
	public String getSrcMainJavaFrameworkAspectDir() {
		return srcMainJavaFrameworkAspectDir;
	}
	public void setSrcMainJavaFrameworkAspectDir(String srcMainJavaFrameworkAspectDir) {
		this.srcMainJavaFrameworkAspectDir = srcMainJavaFrameworkAspectDir;
	}
	public String getSrcMainJavaFrameworkAnnotationDir() {
		return srcMainJavaFrameworkAnnotationDir;
	}
	public void setSrcMainJavaFrameworkAnnotationDir(String srcMainJavaFrameworkAnnotationDir) {
		this.srcMainJavaFrameworkAnnotationDir = srcMainJavaFrameworkAnnotationDir;
	}
	public String getSrcMainJavaFrameworkConfigDir() {
		return srcMainJavaFrameworkConfigDir;
	}
	public void setSrcMainJavaFrameworkConfigDir(String srcMainJavaFrameworkConfigDir) {
		this.srcMainJavaFrameworkConfigDir = srcMainJavaFrameworkConfigDir;
	}
	public String getSrcMainJavaFrameworkConstantDir() {
		return srcMainJavaFrameworkConstantDir;
	}
	public void setSrcMainJavaFrameworkConstantDir(String srcMainJavaFrameworkConstantDir) {
		this.srcMainJavaFrameworkConstantDir = srcMainJavaFrameworkConstantDir;
	}
	public String getSrcMainJavaFrameworkExceptionDir() {
		return srcMainJavaFrameworkExceptionDir;
	}
	public void setSrcMainJavaFrameworkExceptionDir(String srcMainJavaFrameworkExceptionDir) {
		this.srcMainJavaFrameworkExceptionDir = srcMainJavaFrameworkExceptionDir;
	}
	public String getSrcMainJavaFrameworkVerifyDir() {
		return srcMainJavaFrameworkVerifyDir;
	}
	public void setSrcMainJavaFrameworkVerifyDir(String srcMainJavaFrameworkVerifyDir) {
		this.srcMainJavaFrameworkVerifyDir = srcMainJavaFrameworkVerifyDir;
	}
	public String getSrcMainJavaFrameworkVerifyAnnotationDir() {
		return srcMainJavaFrameworkVerifyAnnotationDir;
	}
	public void setSrcMainJavaFrameworkVerifyAnnotationDir(String srcMainJavaFrameworkVerifyAnnotationDir) {
		this.srcMainJavaFrameworkVerifyAnnotationDir = srcMainJavaFrameworkVerifyAnnotationDir;
	}
	public String getSrcMainJavaFrameworkVerifyImplDir() {
		return srcMainJavaFrameworkVerifyImplDir;
	}
	public void setSrcMainJavaFrameworkVerifyImplDir(String srcMainJavaFrameworkVerifyImplDir) {
		this.srcMainJavaFrameworkVerifyImplDir = srcMainJavaFrameworkVerifyImplDir;
	}
	public String getSrcMainJavaFrameworkLocalthread() {
		return srcMainJavaFrameworkLocalthread;
	}
	public void setSrcMainJavaFrameworkLocalthread(String srcMainJavaFrameworkLocalthread) {
		this.srcMainJavaFrameworkLocalthread = srcMainJavaFrameworkLocalthread;
	}
	public String getSrcMainJavaProjectDir() {
		return srcMainJavaProjectDir;
	}
	public void setSrcMainJavaProjectDir(String srcMainJavaProjectDir) {
		this.srcMainJavaProjectDir = srcMainJavaProjectDir;
	}
	public String getSrcMainJavaProjectDbDir() {
		return srcMainJavaProjectDbDir;
	}
	public void setSrcMainJavaProjectDbDir(String srcMainJavaProjectDbDir) {
		this.srcMainJavaProjectDbDir = srcMainJavaProjectDbDir;
	}
	public String getSrcMainJavaProjectDbVODir() {
		return srcMainJavaProjectDbVODir;
	}
	public void setSrcMainJavaProjectDbVODir(String srcMainJavaProjectDbVODir) {
		this.srcMainJavaProjectDbVODir = srcMainJavaProjectDbVODir;
	}
	public String getSrcMainJavaProjectDbControllerDir() {
		return srcMainJavaProjectDbControllerDir;
	}
	public void setSrcMainJavaProjectDbControllerDir(String srcMainJavaProjectDbControllerDir) {
		this.srcMainJavaProjectDbControllerDir = srcMainJavaProjectDbControllerDir;
	}
	public String getSrcMainJavaProjectDbDAODir() {
		return srcMainJavaProjectDbDAODir;
	}
	public void setSrcMainJavaProjectDbDAODir(String srcMainJavaProjectDbDAODir) {
		this.srcMainJavaProjectDbDAODir = srcMainJavaProjectDbDAODir;
	}
	public String getSrcMainJavaProjectDbServiceDir() {
		return srcMainJavaProjectDbServiceDir;
	}
	public void setSrcMainJavaProjectDbServiceDir(String srcMainJavaProjectDbServiceDir) {
		this.srcMainJavaProjectDbServiceDir = srcMainJavaProjectDbServiceDir;
	}
	public String getSrcMainJavaProjectDbMapperDir() {
		return srcMainJavaProjectDbMapperDir;
	}
	public void setSrcMainJavaProjectDbMapperDir(String srcMainJavaProjectDbMapperDir) {
		this.srcMainJavaProjectDbMapperDir = srcMainJavaProjectDbMapperDir;
	}
	public String getSrcMainJavaProjectDbServiceImplDir() {
		return srcMainJavaProjectDbServiceImplDir;
	}
	public void setSrcMainJavaProjectDbServiceImplDir(String srcMainJavaProjectDbServiceImplDir) {
		this.srcMainJavaProjectDbServiceImplDir = srcMainJavaProjectDbServiceImplDir;
	}
	public String getSrcMainResourceDir() {
		return srcMainResourceDir;
	}
	public void setSrcMainResourceDir(String srcMainResourceDir) {
		this.srcMainResourceDir = srcMainResourceDir;
	}
	public String getSrcMainWebappDir() {
		return srcMainWebappDir;
	}
	public void setSrcMainWebappDir(String srcMainWebappDir) {
		this.srcMainWebappDir = srcMainWebappDir;
	}
	public String getSrcMainWebappViewDir() {
		return srcMainWebappViewDir;
	}
	public void setSrcMainWebappViewDir(String srcMainWebappViewDir) {
		this.srcMainWebappViewDir = srcMainWebappViewDir;
	}
	public String getPackgeFrameworkUtil() {
		return packgeFrameworkUtil;
	}
	public void setPackgeFrameworkUtil(String packgeFrameworkUtil) {
		this.packgeFrameworkUtil = packgeFrameworkUtil;
	}
	public String getPackgeFrameworkAspect() {
		return packgeFrameworkAspect;
	}
	public void setPackgeFrameworkAspect(String packgeFrameworkAspect) {
		this.packgeFrameworkAspect = packgeFrameworkAspect;
	}
	public String getPackgeFrameworkAnnotation() {
		return packgeFrameworkAnnotation;
	}
	public void setPackgeFrameworkAnnotation(String packgeFrameworkAnnotation) {
		this.packgeFrameworkAnnotation = packgeFrameworkAnnotation;
	}
	public String getPackgeFrameworkConfig() {
		return packgeFrameworkConfig;
	}
	public void setPackgeFrameworkConfig(String packgeFrameworkConfig) {
		this.packgeFrameworkConfig = packgeFrameworkConfig;
	}
	public String getPackgeFrameworkConstant() {
		return packgeFrameworkConstant;
	}
	public void setPackgeFrameworkConstant(String packgeFrameworkConstant) {
		this.packgeFrameworkConstant = packgeFrameworkConstant;
	}
	public String getPackgeFrameworkException() {
		return packgeFrameworkException;
	}
	public void setPackgeFrameworkException(String packgeFrameworkException) {
		this.packgeFrameworkException = packgeFrameworkException;
	}
	public String getPackgeFrameworkVerify() {
		return packgeFrameworkVerify;
	}
	public void setPackgeFrameworkVerify(String packgeFrameworkVerify) {
		this.packgeFrameworkVerify = packgeFrameworkVerify;
	}
	public String getPackgeFrameworkVerifyAnnotation() {
		return packgeFrameworkVerifyAnnotation;
	}
	public void setPackgeFrameworkVerifyAnnotation(String packgeFrameworkVerifyAnnotation) {
		this.packgeFrameworkVerifyAnnotation = packgeFrameworkVerifyAnnotation;
	}
	public String getPackgeFrameworkVerifyImpl() {
		return packgeFrameworkVerifyImpl;
	}
	public void setPackgeFrameworkVerifyImpl(String packgeFrameworkVerifyImpl) {
		this.packgeFrameworkVerifyImpl = packgeFrameworkVerifyImpl;
	}
	public String getPackgeFrameworkLocalthread() {
		return packgeFrameworkLocalthread;
	}
	public void setPackgeFrameworkLocalthread(String packgeFrameworkLocalthread) {
		this.packgeFrameworkLocalthread = packgeFrameworkLocalthread;
	}
	public String getPackgeVO() {
		return packgeVO;
	}
	public void setPackgeVO(String packgeVO) {
		this.packgeVO = packgeVO;
	}
	public String getPackgeController() {
		return packgeController;
	}
	public void setPackgeController(String packgeController) {
		this.packgeController = packgeController;
	}
	public String getPackgeDAO() {
		return packgeDAO;
	}
	public void setPackgeDAO(String packgeDAO) {
		this.packgeDAO = packgeDAO;
	}
	public String getPackgeMapper() {
		return packgeMapper;
	}
	public void setPackgeMapper(String packgeMapper) {
		this.packgeMapper = packgeMapper;
	}
	public String getPackgeService() {
		return packgeService;
	}
	public void setPackgeService(String packgeService) {
		this.packgeService = packgeService;
	}
	public String getPackgeServiceImpl() {
		return packgeServiceImpl;
	}
	public void setPackgeServiceImpl(String packgeServiceImpl) {
		this.packgeServiceImpl = packgeServiceImpl;
	}
	public String getMainpackge() {
		return mainpackge;
	}
	public void setMainpackge(String mainpackge) {
		this.mainpackge = mainpackge;
	}
	public String getDburl() {
		return dburl;
	}
	public void setDburl(String dburl) {
		this.dburl = dburl;
	}
	public String getDbname() {
		return dbname;
	}
	public void setDbname(String dbname) {
		this.dbname = dbname;
	}
	public String getDbpasswor() {
		return dbpasswor;
	}
	public void setDbpasswor(String dbpasswor) {
		this.dbpasswor = dbpasswor;
	}
	
	public String getTables() {
		return tables;
	}
	public void setTables(String tables) {
		this.tables = tables;
	}
	public String getDatabase() {
		return database;
	}
	public void setDatabase(String database) {
		this.database = database;
	}
	public void initDir() {
		this.srcDir = CommonUtil.concat(projectDir, CommonConstant.SRC);
		this.srcMainDir = CommonUtil.concat(projectDir, CommonConstant.SRC_MAIN);
		this.srcMainJavaDir = CommonUtil.concat(projectDir, CommonConstant.SRC_MAIN_JAVA);
		this.mainpackge = groupId;
		this.srcMainJavaFrameworkDir = CommonUtil.concat(projectDir, CommonConstant.SRC_MAIN_JAVA, groupId.replaceAll("\\.", "/"), "/framework/");
		this.srcMainJavaFrameworkUtilDir = CommonUtil.concat(projectDir, CommonConstant.SRC_MAIN_JAVA, groupId.replaceAll("\\.", "/"), "/framework/util/");
		this.srcMainJavaFrameworkAspectDir = CommonUtil.concat(projectDir, CommonConstant.SRC_MAIN_JAVA, groupId.replaceAll("\\.", "/"), "/framework/aspect/");
		this.srcMainJavaFrameworkAnnotationDir = CommonUtil.concat(projectDir, CommonConstant.SRC_MAIN_JAVA, groupId.replaceAll("\\.", "/"), "/framework/annotation/");
		this.srcMainJavaFrameworkConfigDir = CommonUtil.concat(projectDir, CommonConstant.SRC_MAIN_JAVA, groupId.replaceAll("\\.", "/"), "/framework/config/");
		this.srcMainJavaFrameworkConstantDir = CommonUtil.concat(projectDir, CommonConstant.SRC_MAIN_JAVA, groupId.replaceAll("\\.", "/"), "/framework/constant/");
		this.srcMainJavaFrameworkExceptionDir = CommonUtil.concat(projectDir, CommonConstant.SRC_MAIN_JAVA, groupId.replaceAll("\\.", "/"), "/framework/exception/");
		this.srcMainJavaFrameworkVerifyDir = CommonUtil.concat(projectDir, CommonConstant.SRC_MAIN_JAVA, groupId.replaceAll("\\.", "/"), "/framework/verify/");
		this.srcMainJavaFrameworkVerifyAnnotationDir = CommonUtil.concat(projectDir, CommonConstant.SRC_MAIN_JAVA, groupId.replaceAll("\\.", "/"), "/framework/verify/annotation/");
		this.srcMainJavaFrameworkVerifyImplDir = CommonUtil.concat(projectDir, CommonConstant.SRC_MAIN_JAVA, groupId.replaceAll("\\.", "/"), "/framework/verify/impl/");
		this.srcMainJavaFrameworkLocalthread = CommonUtil.concat(projectDir, CommonConstant.SRC_MAIN_JAVA, groupId.replaceAll("\\.", "/"), "/framework/localthread/");
		this.srcMainJavaProjectDir = CommonUtil.concat(projectDir, CommonConstant.SRC_MAIN_JAVA, groupId.replaceAll("\\.", "/"), CommonConstant.SRC_SEPARATE, packgeName, CommonConstant.SRC_SEPARATE);
		this.srcMainJavaProjectDbDir = CommonUtil.concat(projectDir, CommonConstant.SRC_MAIN_JAVA, groupId.replaceAll("\\.", "/"), CommonConstant.SRC_SEPARATE, packgeName, CommonConstant.SRC_SEPARATE, dbPackgeName, CommonConstant.SRC_SEPARATE);
		this.srcMainJavaProjectDbVODir = CommonUtil.concat(projectDir, CommonConstant.SRC_MAIN_JAVA, groupId.replaceAll("\\.", "/"), CommonConstant.SRC_SEPARATE, packgeName, CommonConstant.SRC_SEPARATE, dbPackgeName, CommonConstant.SRC_SEPARATE, "vo/");
		this.srcMainJavaProjectDbControllerDir = CommonUtil.concat(projectDir, CommonConstant.SRC_MAIN_JAVA, groupId.replaceAll("\\.", "/"), CommonConstant.SRC_SEPARATE, packgeName, CommonConstant.SRC_SEPARATE, dbPackgeName, CommonConstant.SRC_SEPARATE, "controller/");
		this.srcMainJavaProjectDbServiceDir = CommonUtil.concat(projectDir, CommonConstant.SRC_MAIN_JAVA, groupId.replaceAll("\\.", "/"), CommonConstant.SRC_SEPARATE, packgeName, CommonConstant.SRC_SEPARATE, dbPackgeName, CommonConstant.SRC_SEPARATE, "service/");
		this.srcMainJavaProjectDbServiceImplDir = CommonUtil.concat(projectDir, CommonConstant.SRC_MAIN_JAVA, groupId.replaceAll("\\.", "/"), CommonConstant.SRC_SEPARATE, packgeName, CommonConstant.SRC_SEPARATE, dbPackgeName, CommonConstant.SRC_SEPARATE, "service/impl/");
		this.srcMainJavaProjectDbDAODir = CommonUtil.concat(projectDir, CommonConstant.SRC_MAIN_JAVA, groupId.replaceAll("\\.", "/"), CommonConstant.SRC_SEPARATE, packgeName, CommonConstant.SRC_SEPARATE, dbPackgeName, CommonConstant.SRC_SEPARATE, "dao/");
		this.srcMainJavaProjectDbMapperDir = CommonUtil.concat(projectDir, CommonConstant.SRC_MAIN_JAVA, groupId.replaceAll("\\.", "/"), CommonConstant.SRC_SEPARATE, packgeName, CommonConstant.SRC_SEPARATE, dbPackgeName, CommonConstant.SRC_SEPARATE, "dao/mapper/");
		this.srcMainResourceDir = CommonUtil.concat(projectDir, CommonConstant.SRC_MAIN_RESOURCES);
		this.srcMainWebappDir = CommonUtil.concat(projectDir, CommonConstant.SRC_MAIN_WEBAPP);
		this.srcMainWebappViewDir = CommonUtil.concat(projectDir, CommonConstant.SRC_MAIN_WEBAPP_VIEW);
		new File(CommonUtil.concat(projectDir, CommonConstant.SRC)).mkdir();
		new File(CommonUtil.concat(projectDir, CommonConstant.SRC_MAIN)).mkdir();
		new File(CommonUtil.concat(projectDir, CommonConstant.SRC_MAIN_JAVA)).mkdir();
		String[] groupArrs = groupId.split("\\.");
		String newDir = "";
		for (int i = 0; i < groupArrs.length; i++) {
			newDir = newDir + groupArrs[i] + CommonConstant.SRC_SEPARATE;
			new File(CommonUtil.concat(projectDir, CommonConstant.SRC_MAIN_JAVA, newDir)).mkdir();
		}
		new File(CommonUtil.concat(projectDir, CommonConstant.SRC_MAIN_JAVA, groupId.replaceAll("\\.", "/"), "/framework/")).mkdir();
		new File(CommonUtil.concat(projectDir, CommonConstant.SRC_MAIN_JAVA, groupId.replaceAll("\\.", "/"), "/framework/util/")).mkdir();
		new File(CommonUtil.concat(projectDir, CommonConstant.SRC_MAIN_JAVA, groupId.replaceAll("\\.", "/"), "/framework/aspect/")).mkdir();
		new File(CommonUtil.concat(projectDir, CommonConstant.SRC_MAIN_JAVA, groupId.replaceAll("\\.", "/"), "/framework/annotation/")).mkdir();
		new File(CommonUtil.concat(projectDir, CommonConstant.SRC_MAIN_JAVA, groupId.replaceAll("\\.", "/"), "/framework/config/")).mkdir();
		new File(CommonUtil.concat(projectDir, CommonConstant.SRC_MAIN_JAVA, groupId.replaceAll("\\.", "/"), "/framework/constant/")).mkdir();
		new File(CommonUtil.concat(projectDir, CommonConstant.SRC_MAIN_JAVA, groupId.replaceAll("\\.", "/"), "/framework/exception/")).mkdir();
		new File(CommonUtil.concat(projectDir, CommonConstant.SRC_MAIN_JAVA, groupId.replaceAll("\\.", "/"), "/framework/verify/")).mkdir();
		new File(CommonUtil.concat(projectDir, CommonConstant.SRC_MAIN_JAVA, groupId.replaceAll("\\.", "/"), "/framework/verify/annotation/")).mkdir();
		new File(CommonUtil.concat(projectDir, CommonConstant.SRC_MAIN_JAVA, groupId.replaceAll("\\.", "/"), "/framework/verify/impl/")).mkdir();
		new File(CommonUtil.concat(projectDir, CommonConstant.SRC_MAIN_JAVA, groupId.replaceAll("\\.", "/"), "/framework/localthread/")).mkdir();
		new File(CommonUtil.concat(projectDir, CommonConstant.SRC_MAIN_JAVA, groupId.replaceAll("\\.", "/"), CommonConstant.SRC_SEPARATE, packgeName, CommonConstant.SRC_SEPARATE)).mkdir();
		new File(CommonUtil.concat(projectDir, CommonConstant.SRC_MAIN_JAVA, groupId.replaceAll("\\.", "/"), CommonConstant.SRC_SEPARATE, packgeName, CommonConstant.SRC_SEPARATE, dbPackgeName, CommonConstant.SRC_SEPARATE)).mkdir();
		new File(CommonUtil.concat(projectDir, CommonConstant.SRC_MAIN_JAVA, groupId.replaceAll("\\.", "/"), CommonConstant.SRC_SEPARATE, packgeName, CommonConstant.SRC_SEPARATE, dbPackgeName, CommonConstant.SRC_SEPARATE, "vo/")).mkdir();
		new File(CommonUtil.concat(projectDir, CommonConstant.SRC_MAIN_JAVA, groupId.replaceAll("\\.", "/"), CommonConstant.SRC_SEPARATE, packgeName, CommonConstant.SRC_SEPARATE, dbPackgeName, CommonConstant.SRC_SEPARATE, "controller/")).mkdir();
		new File(CommonUtil.concat(projectDir, CommonConstant.SRC_MAIN_JAVA, groupId.replaceAll("\\.", "/"), CommonConstant.SRC_SEPARATE, packgeName, CommonConstant.SRC_SEPARATE, dbPackgeName, CommonConstant.SRC_SEPARATE, "service/")).mkdir();
		new File(CommonUtil.concat(projectDir, CommonConstant.SRC_MAIN_JAVA, groupId.replaceAll("\\.", "/"), CommonConstant.SRC_SEPARATE, packgeName, CommonConstant.SRC_SEPARATE, dbPackgeName, CommonConstant.SRC_SEPARATE, "service/impl/")).mkdir();
		new File(CommonUtil.concat(projectDir, CommonConstant.SRC_MAIN_JAVA, groupId.replaceAll("\\.", "/"), CommonConstant.SRC_SEPARATE, packgeName, CommonConstant.SRC_SEPARATE, dbPackgeName, CommonConstant.SRC_SEPARATE, "dao/")).mkdir();
		new File(CommonUtil.concat(projectDir, CommonConstant.SRC_MAIN_JAVA, groupId.replaceAll("\\.", "/"), CommonConstant.SRC_SEPARATE, packgeName, CommonConstant.SRC_SEPARATE, dbPackgeName, CommonConstant.SRC_SEPARATE, "dao/mapper/")).mkdir();
		new File(CommonUtil.concat(projectDir, CommonConstant.SRC_MAIN_RESOURCES)).mkdir();
		new File(CommonUtil.concat(projectDir, CommonConstant.SRC_MAIN_WEBAPP)).mkdir();
		new File(CommonUtil.concat(projectDir, CommonConstant.SRC_MAIN_WEBAPP_VIEW)).mkdir();
	}
	
	public String getUpArtifactId() {
		String upArtifactId = artifactId;
		String s = FreemarkerSpringBootUtil.fieldFormat(artifactId);
		char[] cs = s.toCharArray();
		cs[0] -= 32;
		upArtifactId = String.valueOf(cs);
		return upArtifactId;
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
