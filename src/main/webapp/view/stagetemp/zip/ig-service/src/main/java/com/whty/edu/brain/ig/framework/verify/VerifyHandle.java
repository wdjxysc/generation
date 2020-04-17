package com.whty.edu.brain.ig.framework.verify;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
/**   
 * @formatClassName:  VerifyHandle
 * @Description:TODO 注解校验内容接口
 * @author: generation
 * @date:   2020年04月17日 09:28:362
 * @Copyright: generation
 */
public interface VerifyHandle {
	/**
	 * 	注解若直接作用于入参上，则需要在此注册
	 */
	@SuppressWarnings("serial")
	public static ArrayList<String> PARAM_VERIFY_ANNOTATIONS = new ArrayList<String>() {{
			add("com.whty.edu.brain.ig.framework.verify.annotation.EnumRange");
			add("com.whty.edu.brain.ig.framework.verify.annotation.Max");
			add("com.whty.edu.brain.ig.framework.verify.annotation.MaxLength");
			add("com.whty.edu.brain.ig.framework.verify.annotation.Min");
			add("com.whty.edu.brain.ig.framework.verify.annotation.MinLength");
			add("com.whty.edu.brain.ig.framework.verify.annotation.NotEmpty");
			add("com.whty.edu.brain.ig.framework.verify.annotation.Regular");
	}};
	
	/**
	 * @Title: verity   
	 * @Description: TODO 每个注解需要一个对应的实现来说明具体是怎么校验数据的
	 * @param: annotation
	 * @param: value
	 * @return: boolean 校验通过返回true
	 * @throws
	 */
	boolean verify(Annotation annotation, Object value);
	
}
