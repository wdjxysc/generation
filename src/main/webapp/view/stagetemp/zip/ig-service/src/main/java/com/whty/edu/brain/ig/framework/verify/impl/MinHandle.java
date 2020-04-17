package com.whty.edu.brain.ig.framework.verify.impl;

import java.lang.annotation.Annotation;
import java.math.BigDecimal;

import com.whty.edu.brain.ig.framework.util.StringUtil;
import com.whty.edu.brain.ig.framework.verify.VerifyHandle;
import com.whty.edu.brain.ig.framework.verify.annotation.Min;
/**   
 * @formatClassName:  MinHandle
 * @Description:TODO 校验最小值
 * @author: generation
 * @date:   2020年04月17日 09:28:352
 * @Copyright: generation
 */
public class MinHandle implements VerifyHandle{
	/**
	 * <p>Title: verify</p>   
	 * <p>Description: 校验最小值限制</p>   
	 * @param annotation
	 * @param value
	 * @return   
	 * @see com.whty.edu.brain.ig.framework.verify.VerifyHandle#verify(java.lang.annotation.Annotation, java.lang.Object)
	 */
	@Override
	public boolean verify(Annotation annotation, Object value) {
		try {
			String v = StringUtil.killNull(value);
			if(StringUtil.isNumeric(v)) {
				BigDecimal val = new BigDecimal(v);
				Min min = (Min)annotation;
				Integer minVal = min.value();
				BigDecimal minBigDecimal = new BigDecimal(minVal);
				if(minBigDecimal.compareTo(val) > 0) {
					return false;
				}
			}
			//非数值类型的无需校验
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
