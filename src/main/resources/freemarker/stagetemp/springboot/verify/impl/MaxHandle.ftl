package ${packgeName}.framework.verify.impl;

import java.lang.annotation.Annotation;
import java.math.BigDecimal;

import ${packgeName}.framework.util.StringUtil;
import ${packgeName}.framework.verify.VerifyHandle;
import ${packgeName}.framework.verify.annotation.Max;

public class MaxHandle implements VerifyHandle{

	@Override
	public boolean verify(Annotation annotation, Object value) {
		try {
			String v = StringUtil.killNull(value);
			if(StringUtil.isNumeric(v)) {
				BigDecimal val = new BigDecimal(v);
				Max max = (Max)annotation;
				Integer maxVal = max.value();
				BigDecimal maxBigDecimal = new BigDecimal(maxVal);
				if(maxBigDecimal.compareTo(val) < 0) {
					return false;
				}
			}
			//非数值类型的无需校验最大值
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
