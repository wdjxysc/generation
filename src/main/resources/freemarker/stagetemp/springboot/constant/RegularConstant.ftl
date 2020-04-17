package ${packgeName}.framework.constant;

/**   
 * @formatClassName:  RegularConsts
 * @Description:TODO 正则常量
 * @author: generation
 * @date:   ${.now?string["yyyy年MM月dd日 hh:mm:SS"]}
 * @Copyright: generation
 */
public class RegularConstant {
	/**
	 * 只能输入数字
	 */
	public static String ONLY_INTEGER = "^[0-9]*$";
	/**
	 * 	只能输入由26个英文字母组成的字符串
	 */
	public static String ONLY_LETTER = "^[A-Za-z]+$";
	/**
	 * 	只能输入由26个大写英文字母组成的字符串
	 */
	public static String ONLY_UP_LETTER = "^[A-Z]+$";
	/**
	 * 只能输入由26个小写英文字母组成的字符串
	 */
	public static String ONLY_LOW_LETTER = "^[a-z]+$";
	/**
	 * 	只能输入由数字和26个英文字母组成的字符串
	 */
	public static String ONLY_LETTER_AND_INTEGER = "^[A-Za-z0-9]+$";
	/**
	 * 	邮箱
	 */
	public static String EMAIL = "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";
	/**
	 * 	域名
	 */
	public static String DNS = "[a-zA-Z0-9][-a-zA-Z0-9]{0,62}(/.[a-zA-Z0-9][-a-zA-Z0-9]{0,62})+/.?";
	/**
	 * 	网址
	 */
	public static String INTERNETURL = "[a-zA-z]+://[^\\s]* 或 ^https://([\\w-]+\\.)+[\\w-]+(/[\\w-./?%&=]*)?$";
	/**
	 * 	移动电话
	 */
	public static String MOBILE_PHONE = "^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\\d{8}$";
	/**
	 * 	电话号码
	 */
	public static String TELEPHONE = "^(\\(\\d{3,4}-)|\\d{3.4}-)?\\d{7,8}$";
	/**
	 * 	国内电话号码
	 */
	public static String INLAND_TELEPHONE = "\\d{3}-\\d{8}|\\d{4}-\\d{7}";
	
	/**
	 * 	身份证
	 */
	public static String IDCARD = "^\\d{15}|\\d{18}$";
	
	public static String IDCARD_15 = "^[1-9]\\d{7}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}$";
	
	public static String IDCARD_18 = "^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{4}$";
	/**
	 * 	邮政编码
	 */
	public static String POSTAL_CODE = "[1-9]\\d{5}(?!\\d)";
	/**
	 * 	日期：YYYY-MM-DD
	 */
	public static String DATE_YYYY_MM_DD = "(([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))-02-29)(([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))-02-29)";
	/**
	 * 	日期：YYYY/MM/DD
	 */
	public static String DATE_YYYY_MM_DD_TILTED = "(((0[1-9]|[12][0-9]|3[01])/((0[13578]|1[02]))|((0[1-9]|[12][0-9]|30)/(0[469]|11))|(0[1-9]|[1][0-9]|2[0-8])/(02))/([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3}))|(29/02/(([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00)))";
	
}
