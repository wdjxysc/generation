package com.whty.edu.brain.ig.framework.verify.impl;

import java.lang.annotation.Annotation;
import java.util.Objects;

import com.whty.edu.brain.ig.framework.util.StringUtil;
import com.whty.edu.brain.ig.framework.verify.VerifyHandle;
import com.whty.edu.brain.ig.framework.verify.annotation.EnumRange;
/**   
 * @formatClassName:  EnumHandle
 * @Description:TODO 校验枚举范围
 * @author: generation
 * @date:   2020年04月17日 09:28:349
 * @Copyright: generation
 */
public class EnumRangeHandle implements VerifyHandle {

	/**   
	 * <p>Title: verify</p>   
	 * <p>Description: 校验枚举范围</p>   
	 * @param annotation
	 * @param value
	 * @return   
	 * @see com.whty.edu.brain.ig.framework.verify.VerifyHandle#verify(java.lang.annotation.Annotation, java.lang.Object)   
	 */
	@Override
	public boolean verify(Annotation annotation, Object value) {
		EnumRange anno = (EnumRange) annotation;
		String[] arr = anno.enums();
		String v = StringUtil.killNull(value);
		for (int i = 0; i < arr.length; i++) {
			if(Objects.equals(v, arr[i])) {
				return true;
			}
		}
		return false;
	}

}
