/**  
 * @Title:  PackageScannerClass.java   
 * @Package com.generation.code.framework   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: 曾肖
 * @date:   2019年6月5日 下午3:46:46   
 * @version V1.0 
 * @Copyright: 2019
 */
package com.generation.code.framework;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

import com.generation.code.annotation.Page;

/**   
 * @ClassName:  PackageScannerClass   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author: 曾肖 
 * @date:   2019年6月5日 下午3:46:46   
 *     
 * @Copyright: 2019
 */
public class PackageScannerClass{
	
	/**
	 * 类加载器
	 */
	public static ClassLoader loader;
	
	static {
		loader = PackageScannerClass.class.getClassLoader();
	}
	/**
	 * @Title: scanner   
	 * @Description: TODO 扫描指定包，得到包内的所有class
	 * @param: @param basePackage
	 * @param: @param nameList
	 * @param: @return      
	 * @return: List<String>      
	 * @throws
	 */
	public static List<String> scanner(String basePackage, List<String> nameList) {
		String splash = basePackage.replaceAll("\\.", "/");
		URL url = loader.getResource(splash);
		String fileUrl = url.getFile();
		int pos = fileUrl.indexOf('!');
		if (-1 != pos) {
			fileUrl = fileUrl.substring(5, pos);
		}
		List<String> names = null;
		File file = new File(fileUrl);
		names = Arrays.asList(file.list());
		for (String name : names) {
			if(name.endsWith(".class")) {
				StringBuilder sb = new StringBuilder(basePackage);
				sb.append('.');
				int poss = name.indexOf('.');
				if (-1 != poss) {
					sb.append(name.substring(0, poss));
				}else {
					sb.append(name);
				}
				nameList.add(sb.toString());
			}else {
				scanner(basePackage + "." + name, nameList);
			}
		}
		return nameList;
	}
	
	
	public static void getDaoPageMethod(String className) {
		try {
			Class<?> cl = Class.forName(className);
			Method[] methods = cl.getMethods();
			for (int i = 0; i < methods.length; i++) {
				Method method = methods[i];
				Page page = method.getAnnotation(com.generation.code.annotation.Page.class);
				if(null != page) {
					page.pageSize();
				}
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	public String getBeanName(String className) {
		if(Character.isLowerCase(className.charAt(0))) {
			return className;
		}else {
			return (new StringBuilder()).append(Character.toLowerCase(className.charAt(0))).append(className.substring(1)).toString();
		}
	}
}
