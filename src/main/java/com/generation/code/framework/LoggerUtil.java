package com.generation.code.framework;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * @ClassName:  LoggerUtil   
 * @Description:TODO(日志工具类)   
 * @author: 曾肖 
 * @date:   2019年5月30日 上午9:48:31   
 *     
 * @Copyright: 2019
 */
public class LoggerUtil {
	
	public static void info(String txt) {
		String className = Thread.currentThread().getStackTrace()[2].getClassName();
		try {
			Logger logger = LoggerFactory.getLogger(Class.forName(className));
			logger.info(txt);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public static void error(String txt, Exception ex) {
		String className = Thread.currentThread().getStackTrace()[2].getClassName();
		try {
			Logger logger = LoggerFactory.getLogger(Class.forName(className));
			logger.error(txt, ex);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public static void error(String txt) {
		String className = Thread.currentThread().getStackTrace()[2].getClassName();
		try {
			Logger logger = LoggerFactory.getLogger(Class.forName(className));
			logger.error(txt);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public static void debug(String txt) {
		String className = Thread.currentThread().getStackTrace()[2].getClassName();
		try {
			Logger logger = LoggerFactory.getLogger(Class.forName(className));
			logger.debug(txt);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
