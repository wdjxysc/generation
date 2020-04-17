package com.whty.edu.brain.ig.framework.annotation;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

 /**   
 * @formatClassName:  ApiParamsVerify
 * @Description:TODO 标记当前方法需要进行参数校验
 * @author: generation
 * @date:   2020年04月17日 09:28:363
 * @Copyright: generation
 */
@Documented
@Retention(RUNTIME)
@Target({METHOD})
public @interface ApiParamsVerify {
	
	boolean collect() default true; 
	
}
