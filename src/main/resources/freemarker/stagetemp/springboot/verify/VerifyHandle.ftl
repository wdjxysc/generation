package ${packgeName}.framework.verify;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
/**   
 * @formatClassName:  VerifyHandle
 * @Description:TODO 注解校验内容接口
 * @author: generation
 * @date:   ${.now?string["yyyy年MM月dd日 hh:mm:SS"]}
 * @Copyright: generation
 */
public interface VerifyHandle {
	/**
	 * 	注解若直接作用于入参上，则需要在此注册
	 */
	@SuppressWarnings("serial")
	public static ArrayList<String> PARAM_VERIFY_ANNOTATIONS = new ArrayList<String>() {{
			add("${packgeName}.framework.verify.annotation.EnumRange");
			add("${packgeName}.framework.verify.annotation.Max");
			add("${packgeName}.framework.verify.annotation.MaxLength");
			add("${packgeName}.framework.verify.annotation.Min");
			add("${packgeName}.framework.verify.annotation.MinLength");
			add("${packgeName}.framework.verify.annotation.NotEmpty");
			add("${packgeName}.framework.verify.annotation.Regular");
	}};
	
	/**
	 * @Title: verity   
	 * @Description: TODO 每个注解需要一个对应的实现来说明具体是怎么校验数据的
	 * @param: annotation
	 * @param: value
	 * @return: boolean 校验通过返回true
	 * @throws
	 */
	boolean verify(Annotation annotation, Object value);
	
}
