package ${packgeName}.framework.verify.annotation;

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
 * @date: ${.now?string["yyyy年MM月dd日 hh:mm:SS"]}
 * @Copyright: generation
 */
@Documented
@Retention(RUNTIME)
@Target({  FIELD, PARAMETER})
@AnnotationHandle("${packgeName}.framework.verify.impl.EnumRangeHandle")
public @interface EnumRange{
	
	String[] enums();
	
	String msg() default "参数不在范围内！";
	//校验类别，用于判断入口
	VerifyType[] vType() default {}; 
}
