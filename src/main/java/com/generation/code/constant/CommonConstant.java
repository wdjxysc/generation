/**  
 * @Title:  CommonConstant.java   
 * @Package com.generation.code.constant   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: 曾肖
 * @date:   2019年5月30日 上午11:24:35   
 * @version V1.0 
 * @Copyright: 2019
 */
package com.generation.code.constant;

/**   
 * @ClassName:  CommonConstant   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author: 曾肖 
 * @date:   2019年5月30日 上午11:24:35   
 *     
 * @Copyright: 2019
 */
public class CommonConstant {
	/**
	 * 数据库文档输出路径
	 */
	public final static String BASE_TABLE_DOWNLOAD = "http://10.5.10.61:9003/view/docs/{docname}.docx";
	/**
	 * 脚手架生成时绑定的插件
	 */
	public final static String[] PLUGINS_STORAGE = new String[] {"redis", "shiro", "pagehelper", "oval", "swagger"};
	/**
	 * 脚手架生成时初始化的工具类
	 */
	public final static String[] UTILS_STORAGE = new String[] {"word", "excel", "img", "zip", "mail"};
	/**
	 * 模板路径
	 */
	public final static String FREEMARKER_TEMP_PATH = System.getProperty("user.dir") + "/src/main/resources/freemarker/stagetemp";
	/**
	 * 
	 */
	public final static String SRC_SEPARATE = "/";
	public final static String SRC = "/src/";
	public final static String SRC_MAIN = "/src/main/";
	public final static String SRC_MAIN_JAVA = "/src/main/java/";
	public final static String SRC_MAIN_RESOURCES = "/src/main/resources/";
	public final static String SRC_MAIN_WEBAPP = "/src/main/webapp/";
	public final static String SRC_MAIN_WEBAPP_VIEW = "/src/main/webapp/view/";
	public final static String SRC_STAGETEMP_ZIP = System.getProperty("user.dir") + "/src/main/webapp/view/stagetemp/zip/";
	public final static String SRC_STAGETEMP = System.getProperty("user.dir") + "/src/main/webapp/view/stagetemp/project/";
	
	public final static String UTF8 = "utf-8";
}
