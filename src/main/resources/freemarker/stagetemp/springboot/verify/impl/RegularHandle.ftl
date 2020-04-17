package ${packgeName}.framework.verify.impl;

import java.lang.annotation.Annotation;
import java.util.regex.Pattern;

import ${packgeName}.framework.util.StringUtil;
import ${packgeName}.framework.verify.VerifyHandle;
import ${packgeName}.framework.verify.annotation.Regular;

/**   
 * @formatClassName:  RegularHandle
 * @Description:TODO 正则匹配
 * @author: generation
 * @date:   ${.now?string["yyyy年MM月dd日 hh:mm:SS"]}
 * @Copyright: generation
 */
public class RegularHandle implements VerifyHandle {
	/**
	 * <p>Title: verify</p>   
	 * <p>Description: 校验正则匹配</p>   
	 * @param annotation
	 * @param value
	 * @return   
	 * @see ${packgeName}.framework.verify.VerifyHandle#verify(java.lang.annotation.Annotation, java.lang.Object)
	 */
	@Override
	public boolean verify(Annotation annotation, Object value) {
		try {
			String v = StringUtil.killNull(value);
			Regular regular = (Regular)annotation;
			boolean isMatch = Pattern.matches(regular.value(), v);
			return isMatch;
		} catch (Exception e) {
			return false;
		}
	}
}
