package com.whty.edu.brain.ig.framework.verify.annotation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
/**
 * @ClassName: EnumRange
 * @Description: 校验枚举范围
 * @author: generation
 * @date: 2020年04月17日 09:28:340
 * @Copyright: generation
 */
@Documented
@Retention(RUNTIME)
@Target({  FIELD, PARAMETER})
@AnnotationHandle("com.whty.edu.brain.ig.framework.verify.impl.EnumRangeHandle")
public @interface EnumRange{
	
	String[] enums();
	
	String msg() default "参数不在范围内！";
	//校验类别，用于判断入口
	VerifyType[] vType() default {}; 
}
