/**  
 * @Title:  StringUtils.java   
 * @Package com.pay.acceptor.framework.util   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: 曾肖
 * @date:   2019年6月10日 上午9:50:02   
 * @version V1.0 
 * @Copyright: 2019
 */
package com.generation.code.util;

/**   
 * @ClassName:  StringUtils   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author: 曾肖 
 * @date:   2019年6月10日 上午9:50:02   
 *     
 * @Copyright: 2019
 */
public class StringUtils {
	/**
	 * @Title: concat   
	 * @Description: 拼接字符串
	 * @param param
	 * @return      
	 * String      
	 * @throws
	 */
	public static String concat(String...param) {
		StringBuffer sb = new StringBuffer();
		for (String item : param) {
			sb.append(item);
		}
		return sb.toString();
	}
	/**
	 * @param <T>
	 * @Title: append   
	 * @Description: 拼接字符串，避免+号链接
	 * @param: @param params
	 * @param: @return      
	 * @return: String      
	 * @throws
	 */
	@SuppressWarnings("unchecked")
	public static <T> String append(T...params) {
		if(null == params || params.length < 1) {
			return "";
		}
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < params.length; i++) {
			sb.append(params[i]);
		}
		return sb.toString();
	}
	
	public static <T> String killNull(T param) {
		if(null  == param) {
			return "";
		}
		return param.toString();
	};
}
