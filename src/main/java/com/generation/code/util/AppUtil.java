package com.generation.code.util;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
/**
 * @ClassName:  AppUtil   
 * @Description:TODO(主线程请求信息)   
 * @author: 曾肖 
 * @date:   2019年5月30日 上午11:09:03   
 *     
 * @Copyright: 2019
 */
@Service("appUtil")
public class AppUtil {
	/**
	 * @Title: getRequest   
	 * @Description: 获取当前request请求对象
	 * @param: @return      
	 * @return: HttpServletRequest      
	 * @throws
	 */
	public static HttpServletRequest getRequest() {
		return ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
	}
	public static HttpServletResponse getResponse() {
		return ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getResponse();
	}
	/**
	 * @Title: getVerityCode   
	 * @Description: 获取验证码
	 * @param: @param n
	 * @param: @return      
	 * @return: String      
	 * @throws
	 */
	public static String getVerityCode(int n) {
		String val = "";
		Random random = new Random();
		for (int i = 0; i < n; i++) {
			String str = random.nextInt(2) % 2 == 0 ? "num" : "char";
			if ("char".equalsIgnoreCase(str)) { 
				// 产生字母
				int nextInt = random.nextInt(2) % 2 == 0 ? 65 : 97;
				val += (char) (nextInt + random.nextInt(26));
			} else if ("num".equalsIgnoreCase(str)) { 
				// 产生数字
				val += String.valueOf(random.nextInt(10));
			}
		}
		return val;
	}
}
