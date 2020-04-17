package ${packgeName}.framework.verify.annotation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Documented
@Retention(RUNTIME)
@Target({  FIELD, PARAMETER})
@AnnotationHandle("${packgeName}.framework.verify.impl.NotEmptyHandle")
public @interface NotEmpty {
	//提示消息
	String msg() default "参数不能为空！";
	//校验类别，用于判断入口
	VerifyType[] vType() default {}; 
}
