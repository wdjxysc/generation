/**  
 * @Title:  CommonUtil.java   
 * @Package com.generation.code.util   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: 曾肖
 * @date:   2019年5月30日 下午3:54:35   
 * @version V1.0 
 * @Copyright: 2019
 */
package com.generation.code.util;

/**   
 * @ClassName:  CommonUtil   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author: 曾肖 
 * @date:   2019年5月30日 下午3:54:35   
 *     
 * @Copyright: 2019
 */
public class CommonUtil {
	public static String concat(String...param) {
		StringBuffer sb = new StringBuffer();
		for (String item : param) {
			sb.append(item);
		}
		return sb.toString();
	}
}
