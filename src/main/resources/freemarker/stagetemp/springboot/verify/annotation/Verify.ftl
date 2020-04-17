package ${packgeName}.framework.verify.annotation;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Documented
@Retention(RUNTIME)
@Target({ METHOD, PARAMETER})
public @interface Verify {
	/**
	 * @Title: value   
	 * @Description: 校验适用场景
	 * @param: @return      
	 * @return: VerifyType      
	 * @throws
	 */
	VerifyType value();
}
