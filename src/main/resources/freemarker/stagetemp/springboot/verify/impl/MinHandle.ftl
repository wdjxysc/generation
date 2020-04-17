package ${packgeName}.framework.verify.impl;

import java.lang.annotation.Annotation;
import java.math.BigDecimal;

import ${packgeName}.framework.util.StringUtil;
import ${packgeName}.framework.verify.VerifyHandle;
import ${packgeName}.framework.verify.annotation.Min;
/**   
 * @formatClassName:  MinHandle
 * @Description:TODO 校验最小值
 * @author: generation
 * @date:   ${.now?string["yyyy年MM月dd日 hh:mm:SS"]}
 * @Copyright: generation
 */
public class MinHandle implements VerifyHandle{
	/**
	 * <p>Title: verify</p>   
	 * <p>Description: 校验最小值限制</p>   
	 * @param annotation
	 * @param value
	 * @return   
	 * @see ${packgeName}.framework.verify.VerifyHandle#verify(java.lang.annotation.Annotation, java.lang.Object)
	 */
	@Override
	public boolean verify(Annotation annotation, Object value) {
		try {
			String v = StringUtil.killNull(value);
			if(StringUtil.isNumeric(v)) {
				BigDecimal val = new BigDecimal(v);
				Min min = (Min)annotation;
				Integer minVal = min.value();
				BigDecimal minBigDecimal = new BigDecimal(minVal);
				if(minBigDecimal.compareTo(val) > 0) {
					return false;
				}
			}
			//非数值类型的无需校验
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
