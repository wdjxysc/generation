package ${packgeName}.framework.verify.impl;

import java.lang.annotation.Annotation;

import ${packgeName}.framework.util.StringUtil;
import ${packgeName}.framework.verify.VerifyHandle;
import ${packgeName}.framework.verify.annotation.MinLength;
/**
 * @ClassName:  MinLengthHandle   
 * @Description:TODO
 * @author: 曾肖 
 * @date:   2019年6月20日 下午4:31:22   
 * @Copyright: 2019
 */
public class MinLengthHandle implements VerifyHandle {
	/**
	 * <p>Title: verify</p>   
	 * <p>Description: 校验最小长度限制</p>   
	 * @param annotation
	 * @param value
	 * @return   
	 * @see ${packgeName}.framework.verify.VerifyHandle#verify(java.lang.annotation.Annotation, java.lang.Object)
	 */
	@Override
	public boolean verify(Annotation annotation, Object value) {
		MinLength minLength = (MinLength) annotation;
		Integer min = minLength.value();
		try {
			String v = StringUtil.killNull(value);
			int len = v.length();
			if(min > len) {
				return false;
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
}
