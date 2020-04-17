package ${packgeName}.framework.verify.annotation;

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
 * @date: ${.now?string["yyyy年MM月dd日 hh:mm:SS"]}
 * @Copyright: generation
 */
@Documented
@Retention(RUNTIME)
@Target({  FIELD, PARAMETER})
@AnnotationHandle("${packgeName}.framework.verify.impl.MaxHandle")
public @interface Max {
	int value() default 1024;
	String msg() default "参数超过最大值！";
	//校验类别，用于判断入口
	VerifyType[] vType() default {};  
}
