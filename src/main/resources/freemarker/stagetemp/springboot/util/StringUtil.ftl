package ${packge}.framework.util;

import java.math.BigDecimal;
import java.util.List;
import java.util.regex.Pattern;

import org.apache.commons.collections.CollectionUtils;
/**   
 * @formatClassName:  StringUtil
 * @Description:TODO 字符串操作工具类
 * @author: generation
 * @date:   ${.now?string["yyyy年MM月dd日 hh:mm:SS"]}
 * @Copyright: generation
 */
public class StringUtil {
	/**
	 * 拼接字符串
	 *
	 */
	public static String concat(String...param) {
		StringBuffer sb = new StringBuffer();
		for (String item : param) {
			sb.append(item);
		}
		return sb.toString();
	}
	/**
	 * @Title: killNull   
	 * @Description: obj转string
	 * @param o
	 * @return      
	 * String      
	 * @throws
	 */
	public static String killNull(Object o) {
		if(null == o) {
			return "";
		}
		return String.valueOf(o);
	}
	/**
	 * 将提示信息集合转为字符串作为返回
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
