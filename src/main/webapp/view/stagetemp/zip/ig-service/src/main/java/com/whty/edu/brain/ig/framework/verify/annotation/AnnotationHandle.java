package com.whty.edu.brain.ig.framework.verify.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * @ClassName: AnnotationHandle
 * @Description:用于指定当前校验注解对应的实现类
 * @author: generation
 * @date: 2020年04月17日 09:28:339
 * @Copyright: generation
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.ANNOTATION_TYPE)
public @interface AnnotationHandle {
	public String value();
}
