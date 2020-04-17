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
@AnnotationHandle("${packgeName}.framework.verify.impl.RegularHandle")
public @interface Regular {
	String value();
	String msg() default "参数格式不正确！";
	VerifyType[] vType() default {}; 
}
