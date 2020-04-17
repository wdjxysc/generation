package com.whty.edu.brain.ig.framework.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.whty.edu.brain.ig.framework.config.ThreadLocalVariableHolder;

/**   
 * @formatClassName:  WebUtil
 * @Description:TODO web操作工具类
 * @author: generation
 * @date:   2020年04月17日 09:28:337
 * @Copyright: generation
 */
public class WebUtil {
	/**
	 * @Title: JudgeIsMoblie @Description: 判断是否为手机浏览器 @param: @param
	 * request @param: @return @return: boolean @throws
	 */
	public static boolean JudgeIsMoblie() {
		HttpServletRequest request = WebUtil.getHttpServletRequest();
		boolean isMoblie = false;
		String[] mobileAgents = { "iphone", "android", "ipad", "phone", "mobile", "wap", "netfront", "java",
				"opera mobi", "opera mini", "ucweb", "windows ce", "symbian", "series", "webos", "sony", "blackberry",
				"dopod", "nokia", "samsung", "palmsource", "xda", "pieplus", "meizu", "midp", "cldc", "motorola",
				"foma", "docomo", "up.browser", "up.link", "blazer", "helio", "hosin", "huawei", "novarra", "coolpad",
				"webos", "techfaith", "palmsource", "alcatel", "amoi", "ktouch", "nexian", "ericsson", "philips",
				"sagem", "wellcom", "bunjalloo", "maui", "smartphone", "iemobile", "spice", "bird", "zte-", "longcos",
				"pantech", "gionee", "portalmmm", "jig browser", "hiptop", "benq", "haier", "^lct", "320x320",
				"240x320", "176x220", "w3c ", "acs-", "alav", "alca", "amoi", "audi", "avan", "benq", "bird", "blac",
				"blaz", "brew", "cell", "cldc", "cmd-", "dang", "doco", "eric", "hipt", "inno", "ipaq", "java", "jigs",
				"kddi", "keji", "leno", "lg-c", "lg-d", "lg-g", "lge-", "maui", "maxo", "midp", "mits", "mmef", "mobi",
				"mot-", "moto", "mwbp", "nec-", "newt", "noki", "oper", "palm", "pana", "pant", "phil", "play", "port",
				"prox", "qwap", "sage", "sams", "sany", "sch-", "sec-", "send", "seri", "sgh-", "shar", "sie-", "siem",
				"smal", "smar", "sony", "sph-", "symb", "t-mo", "teli", "tim-", "tosh", "tsm-", "upg1", "upsi", "vk-v",
				"voda", "wap-", "wapa", "wapi", "wapp", "wapr", "webc", "winw", "winw", "xda", "xda-",
				"Googlebot-Mobile" };
		if (request.getHeader("User-Agent") != null) {
			String agent = request.getHeader("User-Agent");
			for (String mobileAgent : mobileAgents) {
				if (agent.toLowerCase().indexOf(mobileAgent) >= 0 && agent.toLowerCase().indexOf("windows nt") <= 0
						&& agent.toLowerCase().indexOf("macintosh") <= 0) {
					isMoblie = true;
					break;
				}
			}
		}
		return isMoblie;
	}
	/**
	 * @Title: getHttpServletRequest   
	 * @Description: 获取request对象
	 * @param: @return      
	 * @return: HttpServletRequest      
	 * @throws
	 */
	public static HttpServletRequest getHttpServletRequest() {
		return ThreadLocalVariableHolder.getHttpServletRequest();
	}
	/**
	 * @Title: getHttpServletResponse   
	 * @Description: 获取response对象
	 * @param: @return      
	 * @return: HttpServletResponse      
	 * @throws
	 */
	public static HttpServletResponse getHttpServletResponse() {
		return ThreadLocalVariableHolder.getHttpServletResponse();
	}
	/**
	 * @Title: getSession   
	 * @Description: 获取session对象
	 * @param: @return      
	 * @return: HttpSession      
	 * @throws
	 */
	public static HttpSession getSession() {
		HttpSession session = null;
		HttpServletRequest request = ThreadLocalVariableHolder.getHttpServletRequest();
		if (request != null) {
			session = request.getSession();
		}
		return session;
	}
		/**
	 * @Title: setAttribute   
	 * @Description: 设置request参数
	 * @param: k
	 * @param: v      
	 * @return: void      
	 * @throws
	 */
	public static void setAttribute(String k, String v) {
		getHttpServletRequest().setAttribute(k, v);
	}
}
