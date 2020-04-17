package com.generation.code.annotation;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
/**
 * @ClassName:  Page   
 * @Description:TODO(分页注解)   
 * @author: 曾肖 
 * @date:   2019年5月30日 上午9:49:20   
 *     
 * @Copyright: 2019
 */
@Documented
@Retention(RUNTIME)
@Target({METHOD})
public @interface Page {
	int pageSize() default 10;
}
