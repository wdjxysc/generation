/**  
 * @Title:  ProjectAttributeVO.java   
 * @Package com.generation.code.stage.vo   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: 曾肖
 * @date:   2019年5月30日 下午1:27:45   
 * @version V1.0 
 * @Copyright: 2019
 */
package com.generation.code.stage.vo;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.generation.code.util.CommonUtil;
import com.generation.code.util.FreemarkerSpringBootUtil;

/**   
 * @ClassName:  ProjectAttributeVO   
 * @Description:TODO(脚手架属性)   
 * @author: 曾肖 
 * @date:   2019年5月30日 下午1:27:45   
 *     
 * @Copyright: 2019
 */
public class ProjectAttributeVO {
	
	private String groupId;
	/**
	 * pom
	 */
	private String artifactId;
	/**
	 * 格式化后的artifactId
	 */
	private String upArtifactId;
	/**
	 * 项目名
	 */
	private String projectName;
	/**
	 * 数据库驱动类型
	 */
	private String driver;
	/**
	 * 项目类型：springboot/springmvc
	 */
	private String projectType;
	/**
	 * 包名
	 */
	private String packgeName;
	/**
	 * 前端类型：jsp/thymeleaf
	 */
	private String frontEnd;
	/**
	 * 前端ui：layui/
	 */
	private String ui;
	/**
	 * jdk版本：1.8及以上
	 */
	private String jdkVersion;
	/**
	 * 加入插件：由PLUGINS_STORAGE中选择
	 */
	private List<String> plugins;
	/**
	 * 初始化的工具类：由UTILS_STORAGE中选择
	 */
	private List<String> utils;
	/**
	 * 加入插件：由PLUGINS_STORAGE中选择
	 */
	private String pluginsString;
	/**
	 * 初始化的工具类：由UTILS_STORAGE中选择
	 */
	private String utilsString;
	
	/**
	 * 容器
	 * in_tomcat：内置tomcat容器
	 * out_tomcat：依赖外部tomcat容器
	 * in_jetty:jetty内部容器
	 */
	private String container;
	/**
	 * 打包类型：jar/war
	 */
	private String packtype;
	/**
	 * 是否前后端分离：0，不分离。1，分离
	 */
	private int separate;
	
	/**
	 * 是否将视图层和服务层做项目分离
	 */
	private int separateService;
	/**
	 * 工程路径
	 */
	private String projectDir;
	
	/**
	 * java文件目录
	 */
	private String javaPackgeDir;
	/**
	 * 资源路径
	 */
	private String resourcesDir;
	/**
	 * 静态路径
	 */
	private String webappDir;
	/**
	 * 前端 页面后缀
	 */
	private String staticSuffix;
	/**
	 * 日志输出路径
	 */
	private String logdir;
	/**
	 * 数据库连接
	 */
	private String dburl;
	/**
	 * 用户名
	 */
	private String dbusername;
	/**
	 * 数据库密码
	 */
	private String dbpassword;
	/**
	 * 数据库名称
	 */
	private String dbname;
	/**
	 * mapper映射路径
	 */
	private String mapperDir;
	/**
	 * 是否生成dml
	 */
	private int dml;
	/**
	 * 是否生成javabean
	 */
	private int javabean;
	/**
	 * 需要自动生成的表
	 */
	private String generationTables;
	/**
	 * javabean包名
	 */
	private String beanpackge;
	/**
	 * 配置包
	 */
	private String frameworkDir;
	
	public String getFrameworkDir() {
		return frameworkDir;
	}
	public void setFrameworkDir(String frameworkDir) {
		this.frameworkDir = frameworkDir;
	}
	public String getUpArtifactId() {
		String s = FreemarkerSpringBootUtil.fieldFormat(artifactId);
		char[] cs = s.toCharArray();
		cs[0] -= 32;
		upArtifactId = String.valueOf(cs);
		return upArtifactId;
	}
	public void setUpArtifactId(String upArtifactId) {
		this.upArtifactId = upArtifactId;
	}
	public String getPluginsString() {
		return pluginsString;
	}
	public void setPluginsString(String pluginsString) {
		this.pluginsString = pluginsString;
	}
	public String getUtilsString() {
		return utilsString;
	}
	public void setUtilsString(String utilsString) {
		this.utilsString = utilsString;
	}
	public String getBeanpackge() {
		return beanpackge;
	}
	public void setBeanpackge(String beanpackge) {
		this.beanpackge = beanpackge;
	}
	public String getGenerationTables() {
		return generationTables;
	}
	public void setGenerationTables(String generationTables) {
		this.generationTables = generationTables;
	}
	public int getDml() {
		return dml;
	}
	public void setDml(int dml) {
		this.dml = dml;
	}
	public int getJavabean() {
		return javabean;
	}
	public void setJavabean(int javabean) {
		this.javabean = javabean;
	}
	public String getResourcesDir() {
		return resourcesDir;
	}
	public void setResourcesDir(String resourcesDir) {
		this.resourcesDir = resourcesDir;
	}
	public String getWebappDir() {
		return webappDir;
	}
	public void setWebappDir(String webappDir) {
		this.webappDir = webappDir;
	}
	public String getMapperDir() {
		mapperDir = CommonUtil.concat("classpath*:", this.packgeName.replaceAll("\\.", "/"), "/**/dao/mapper/*.xml");
		return mapperDir;
	}
	public void setMapperDir(String mapperDir) {
		this.mapperDir = mapperDir;
	}
	public String getDburl() {
		return dburl;
	}
	public void setDburl(String dburl) {
		this.dburl = dburl;
	}
	public String getDbusername() {
		return dbusername;
	}
	public void setDbusername(String dbusername) {
		this.dbusername = dbusername;
	}
	public String getDbpassword() {
		return dbpassword;
	}
	public void setDbpassword(String dbpassword) {
		this.dbpassword = dbpassword;
	}
	public String getDbname() {
		return dbname;
	}
	public void setDbname(String dbname) {
		this.dbname = dbname;
	}
	public String getLogdir() {
		return logdir;
	}
	public void setLogdir(String logdir) {
		this.logdir = logdir;
	}
	public String getStaticSuffix() {
		if(StringUtils.isNotBlank(frontEnd)) {
			if("jsp".equals(frontEnd)) {
				return "jsp";
			}else {
				return "html";
			}
		}
		return staticSuffix;
	}
	public void setStaticSuffix(String staticSuffix) {
		this.staticSuffix = staticSuffix;
	}
	public String getJavaPackgeDir() {
		return javaPackgeDir;
	}
	public void setJavaPackgeDir(String javaPackgeDir) {
		this.javaPackgeDir = javaPackgeDir;
	}
	public String getProjectDir() {
		return projectDir;
	}
	public void setProjectDir(String projectDir) {
		this.projectDir = projectDir;
	}
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
	public int getSeparate() {
		return separate;
	}
	public void setSeparate(int separate) {
		this.separate = separate;
	}
	public int getSeparateService() {
		return separateService;
	}
	public void setSeparateService(int separateService) {
		this.separateService = separateService;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getDriver() {
		return driver;
	}
	public void setDriver(String driver) {
		this.driver = driver;
	}
	public String getProjectType() {
		return projectType;
	}
	public void setProjectType(String projectType) {
		this.projectType = projectType;
	}
	public String getPackgeName() {
		return packgeName;
	}
	public void setPackgeName(String packgeName) {
		this.packgeName = packgeName;
	}
	public String getFrontEnd() {
		return frontEnd;
	}
	public void setFrontEnd(String frontEnd) {
		this.frontEnd = frontEnd;
	}
	public String getUi() {
		return ui;
	}
	public void setUi(String ui) {
		this.ui = ui;
	}
	public String getJdkVersion() {
		return jdkVersion;
	}
	public void setJdkVersion(String jdkVersion) {
		this.jdkVersion = jdkVersion;
	}
	public List<String> getPlugins() {
		if(StringUtils.isNotBlank(pluginsString)) {
			plugins = Arrays.asList(pluginsString.split(","));
		}
		return plugins;
	}
	public void setPlugins(List<String> plugins) {
		this.plugins = plugins;
	}
	public List<String> getUtils() {
		if(StringUtils.isNotBlank(utilsString)) {
			utils = Arrays.asList(utilsString.split(","));
		}
		return utils;
	}
	public void setUtils(List<String> utils) {
		this.utils = utils;
	}
	public String getContainer() {
		return container;
	}
	public void setContainer(String container) {
		this.container = container;
	}
	public String getPacktype() {
		return packtype;
	}
	public void setPacktype(String packtype) {
		this.packtype = packtype;
	}
	@Override
	public String toString() {
		return "ProjectAttributeVO [groupId=" + groupId + ", artifactId=" + artifactId + ", projectName=" + projectName
				+ ", driver=" + driver + ", projectType=" + projectType + ", packgeName=" + packgeName + ", frontEnd="
				+ frontEnd + ", ui=" + ui + ", jdkVersion=" + jdkVersion
				+ ", plugins=" + plugins + ", utils=" + utils + ", container=" + container + ", packtype=" + packtype
				+ ", separate=" + separate + ", separateService=" + separateService + ", projectDir=" + projectDir
				+ ", javaPackgeDir=" + javaPackgeDir + ", resourcesDir=" + resourcesDir + ", webappDir=" + webappDir
				+ ", staticSuffix=" + staticSuffix + ", logdir=" + logdir + ", dburl=" + dburl + ", dbusername="
				+ dbusername + ", dbpassword=" + dbpassword + ", dbname=" + dbname + ", mapperDir=" + mapperDir
				+ ", dml=" + dml + ", javabean=" + javabean + ", generationTables=" + generationTables + "]";
	}
	
}
