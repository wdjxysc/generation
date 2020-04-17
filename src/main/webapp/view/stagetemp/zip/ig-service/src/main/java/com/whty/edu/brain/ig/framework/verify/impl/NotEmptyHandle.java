package com.whty.edu.brain.ig.framework.verify.impl;
import java.lang.annotation.Annotation;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;

import com.whty.edu.brain.ig.framework.util.StringUtil;
import com.whty.edu.brain.ig.framework.verify.VerifyHandle;

public class NotEmptyHandle implements VerifyHandle {
	
	/**
	 * <p>Title: verify</p>   
	 * <p>Description: 非空校验</p>   
	 * @param annotation
	 * @param value
	 * @return   
	 * @see com.whty.edu.brain.ig.framework.verify.VerifyHandle#verify(java.lang.annotation.Annotation, java.lang.Object)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public boolean verify(Annotation annotation, Object value) {
		if(value == null)  return false;
		//若为集合
		if(value instanceof java.util.List) {
			return CollectionUtils.isNotEmpty((List)value);
		}
		//字符串非空校验
		String v = StringUtil.killNull(value);
		if("".equals(v)) return false;
		if(v.trim().isEmpty())  return false;
		return true;
	}

}
