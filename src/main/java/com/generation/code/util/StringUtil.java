/**  
 * @Title:  StringUtil.java   
 * @Package com.whty.zhxy.framework.util   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: 曾肖
 * @date:   2019年6月20日 上午11:30:53   
 * @version V1.0 
 * @Copyright: 2019
 */
package com.generation.code.util;

import java.math.BigDecimal;
import java.util.List;
import java.util.regex.Pattern;

import org.apache.commons.collections.CollectionUtils;

/**   
 * @ClassName:  StringUtil   
 * @Description:TODO 字符串操作工具类
 * @author: 曾肖 
 * @date:   2019年6月20日 上午11:30:53   
 *     
 * @Copyright: 2019
 */
public class StringUtil {
	
	public static String killNull(Object o) {
		if(null == o) {
			return "";
		}
		return String.valueOf(o);
	}
	/**
	 * 将提示信息集合转为字符串作为返回
	 * 
	 * @param result
	 * @return
	 */
	public static String clearUp(List<String> result) {
		if (CollectionUtils.isEmpty(result)) {
			return null;
		}
		StringBuffer sb = new StringBuffer();
		for (String item : result) {
			sb.append(item);
			sb.append(";");
		}
		String r = sb.toString().substring(0, sb.length() - 1);
		return r;
	}
	/**
	 * @Title: isNumeric   
	 * @Description: TODO 校验是否为数字
	 * @param:  str
	 * @return: boolean      
	 * @throws
	 */
	public static boolean isNumeric(String str) {  
		Pattern pattern = Pattern.compile("-?[0-9]+(\\.[0-9]+)?");
		String bigStr;
		try {
			bigStr = new BigDecimal(str).toPlainString();
		} catch (Exception e) {
			//异常 说明包含非数字。
			return false;
		}
        return pattern.matcher(bigStr).matches();  
	}
	/**
	 * @Title: match   
	 * @Description: TODO 正则校验
	 * @param:  regular 正则规则
	 * @param:  p 校验对象
	 * @return: boolean      
	 * @throws
	 */
	public static boolean match(String regular, String p) {
		Pattern pattern = Pattern.compile(regular);
		return pattern.matcher(p).matches();
	}
	/**
	 * @Title: parseInt   
	 * @Description: TODO string转int
	 * @param: @param s
	 * @param: @param defaultInt
	 * @param: @return      
	 * @return: Integer      
	 * @throws
	 */
	public static Integer parseInt(String s, Integer defaultInt) {
		if(null == s) {
			return null == defaultInt ? 0 : defaultInt;
		}
		if(isNumeric(s)) {
			return Integer.valueOf(s);
		}else {
			return 0;
		}
	}
	/**
	 * @Title: parseLong   
	 * @Description: TODO string转long
	 * @param: @param s
	 * @param: @param defaultInt
	 * @param: @return      
	 * @return: Long      
	 * @throws
	 */
	public static Long parseLong(String s, Long defaultInt) {
		if(null == s) {
			return null == defaultInt ? 0L : defaultInt;
		}
		if(isNumeric(s)) {
			return Long.valueOf(s);
		}else {
			return 0L;
		}
	}
}
