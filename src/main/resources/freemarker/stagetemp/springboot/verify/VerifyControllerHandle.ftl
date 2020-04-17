package ${packgeName}.framework.verify;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import ${packgeName}.framework.config.SpringContextHolder;
import ${packgeName}.framework.exception.CommonDefineException;
import ${packgeName}.framework.verify.annotation.AnnotationHandle;
import ${packgeName}.framework.verify.annotation.VerifyType;

/**   
 * @formatClassName:  VerifyControllerHandle
 * @Description:TODO controller接口参数校验通用校验入口
 * @author: generation
 * @date:   ${.now?string["yyyy年MM月dd日 hh:mm:SS"]}
 * @Copyright: generation
 */
public class VerifyControllerHandle {

	private final Logger logger = LoggerFactory.getLogger(VerifyControllerHandle.class);

	private List<String> verifyResult;

	/**
	 * 校验参数信息
	 * 
	 * @param verify
	 * @param param
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<String> verify(${packgeName}.framework.verify.annotation.Verify verify, Object param, boolean collect) throws CommonDefineException {
		try {
			verifyResult = new ArrayList<String>();
			// 注解校验类别
			VerifyType verifyType = verify.value();
			// 参数所属类型
			Class paramClass = param.getClass();
			// 参数所属类型包含属性
			Field[] fields = paramClass.getDeclaredFields();
			// 遍历所有属性
			for (Field f : fields) {
				// 属性名
				String fieldName = f.getName();
				// 将变量名首字母大写，得到变量的get方法
				char[] cs = fieldName.toCharArray();
				cs[0] -= 32;
				String getMethod = "get" + String.valueOf(cs);
				// 获取属性所含注解
				Annotation[] annotations = f.getAnnotations();
				// 得到get方法并执行得到属性值
				Method method = null;
				Object value = null;
				try {
					method = paramClass.getMethod(getMethod);
				} catch (Exception e) {
					logger.error("获取方法异常：【{}】", getMethod);
					//给出所属类型的初始对象
					value = f.getType().newInstance();
				}
				// 属性值
				value = method.invoke(param);
				// 遍历修饰属性的注解
				for (Annotation annotation : annotations) {
					Class currentAnnotationClass = annotation.annotationType();
					// 匹配校验类型，若校验类型不匹配，则不予校验
					Method verifyTypeMethod = currentAnnotationClass.getMethod("vType");
					VerifyType[] itemVerifyType = (VerifyType[]) verifyTypeMethod.invoke(annotation);
					if (!arrayContain(itemVerifyType, verifyType)) {
						//校验场景不匹配，切换到下一个注解进行校验
						continue;
					}
					//获取当前注解的校验实现类
					AnnotationHandle handle = (AnnotationHandle) currentAnnotationClass.getAnnotation(AnnotationHandle.class);
					if(null == handle || StringUtils.isBlank(handle.value())) {
						logger.info("annotationVerify:当前注解【{}】未指定校验方法", currentAnnotationClass.getClass().getName());
						continue;
					}
					// 执行校验方法
					String handleClass = handle.value();
					Method annotationMethod = null;
					try {
						annotationMethod = Class.forName(handleClass).getMethod("verify", new Class[] {Annotation.class, Object.class});
					} catch (ClassNotFoundException e) {
						logger.info("annotationVerify:当前注解指定的校验实现类不存在， ClassNotFoundException【{}】", handleClass);
						continue;
					} catch(NoSuchMethodException e) {
						logger.info("annotationVerify:当前注解指定的校验实现类【{}】需继承${packgeName}.framework.verify.VerifyHandle，实现verify方法", handleClass);
						continue;
					}
					//类用@Service标记了，即加入了spring上下文，则直接取上下文（便于使用其他上下文实例，如dao/mapper操作），一般业务场景使用newInstance即可
					Service service = Class.forName(handleClass).getAnnotation(org.springframework.stereotype.Service.class);
					Object handleInstance = null;
					if(null == service) {
						//新实例
						handleInstance = Class.forName(handleClass).newInstance();
					}else {
						//取上下文
						handleInstance = SpringContextHolder.getBean(Class.forName(handleClass));
					}
					if(null == handleInstance) {
						logger.info("校验实现实例【{}】获取为Null", handleClass);
						continue;
					}
					// 获取校验结果
					Boolean verifyFlag = (Boolean) annotationMethod.invoke(handleInstance, new Object[] {annotation, value});
					if (!verifyFlag) {
						// 若校验不通过，则收集校验提示信息
						Method msgMethod = currentAnnotationClass.getMethod("msg");
						String msg = (String) msgMethod.invoke(annotation);
						addVerifyResult(msg);
						if(!collect) {
							//遇见错误直接返回
							return verifyResult;
						}
					}
				}
			}
			// 返回所有字段的校验提示信息
			return verifyResult;
		} catch (Exception ex) {
			logger.error("参数校验异常", ex);
		}
		return null;
	}

	/**
	 * 将提示信息集合转为字符串作为返回
	 * 
	 * @param result
	 * @return
	 */
	public static String clearUp(List<String> result) {
		if (CollectionUtils.isEmpty(result)) {
			return null;
		}
		StringBuffer sb = new StringBuffer();
		for (String item : result) {
			sb.append(item);
			sb.append(";");
		}
		String r = sb.toString().substring(0, sb.length() - 1);
		return r;
	}

	/**
	 * @Title: arrayContain   
	 * @Description: TODO 校验场景是否匹配
	 * @param: @param itemVerifyType
	 * @param: @param item
	 * @param: @return      
	 * @return: boolean      
	 * @throws
	 */
	public static boolean arrayContain(VerifyType[] itemVerifyType, VerifyType item) {
		if(null == itemVerifyType) {
			return false;
		}
		for (VerifyType v : itemVerifyType) {
			if (item.getType().equals(v.getType())) {
				return true;
			}
		}
		return false;
	}

	public List<String> getVerifyResult() {
		return verifyResult;
	}

	public void setVerifyResult(List<String> verifyResult) {
		this.verifyResult = verifyResult;
	}

	public void addVerifyResult(String item) {
		verifyResult.add(item);
	}
}
