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
@AnnotationHandle("${packgeName}.framework.verify.impl.MinHandle")
public @interface Min {
	int value() default 0;
	String msg() default "参数小于最小值！";
	VerifyType[] vType() default {}; 
}
