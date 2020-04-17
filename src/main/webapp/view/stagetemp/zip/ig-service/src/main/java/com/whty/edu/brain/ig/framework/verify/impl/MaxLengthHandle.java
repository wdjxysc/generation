package com.whty.edu.brain.ig.framework.verify.impl;

import java.lang.annotation.Annotation;

import com.whty.edu.brain.ig.framework.util.StringUtil;
import com.whty.edu.brain.ig.framework.verify.VerifyHandle;
import com.whty.edu.brain.ig.framework.verify.annotation.MaxLength;

public class MaxLengthHandle implements VerifyHandle {

	@Override
	public boolean verify(Annotation annotation, Object value) {
		MaxLength maxLength = (MaxLength) annotation;
		Integer max = maxLength.value();
		try {
			String v = StringUtil.killNull(value);
			int len = v.length();
			if(max < len) {
				return false;
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
