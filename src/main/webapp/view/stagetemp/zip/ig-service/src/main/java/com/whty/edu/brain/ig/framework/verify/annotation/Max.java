package com.whty.edu.brain.ig.framework.verify.annotation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * @ClassName: Max
 * @Description: 校验最大值
 * @author: generation
 * @date: 2020年04月17日 09:28:342
 * @Copyright: generation
 */
@Documented
@Retention(RUNTIME)
@Target({  FIELD, PARAMETER})
@AnnotationHandle("com.whty.edu.brain.ig.framework.verify.impl.MaxHandle")
public @interface Max {
	int value() default 1024;
	String msg() default "参数超过最大值！";
	//校验类别，用于判断入口
	VerifyType[] vType() default {};  
}
