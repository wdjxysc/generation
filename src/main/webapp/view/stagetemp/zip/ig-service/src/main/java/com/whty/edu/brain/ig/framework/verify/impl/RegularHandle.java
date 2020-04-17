package com.whty.edu.brain.ig.framework.verify.impl;

import java.lang.annotation.Annotation;
import java.util.regex.Pattern;

import com.whty.edu.brain.ig.framework.util.StringUtil;
import com.whty.edu.brain.ig.framework.verify.VerifyHandle;
import com.whty.edu.brain.ig.framework.verify.annotation.Regular;

/**   
 * @formatClassName:  RegularHandle
 * @Description:TODO 正则匹配
 * @author: generation
 * @date:   2020年04月17日 09:28:355
 * @Copyright: generation
 */
public class RegularHandle implements VerifyHandle {
	/**
	 * <p>Title: verify</p>   
	 * <p>Description: 校验正则匹配</p>   
	 * @param annotation
	 * @param value
	 * @return   
	 * @see com.whty.edu.brain.ig.framework.verify.VerifyHandle#verify(java.lang.annotation.Annotation, java.lang.Object)
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
