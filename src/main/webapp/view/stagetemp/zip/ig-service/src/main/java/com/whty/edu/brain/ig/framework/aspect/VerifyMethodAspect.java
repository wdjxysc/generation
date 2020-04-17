package com.whty.edu.brain.ig.framework.aspect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.whty.edu.brain.ig.framework.annotation.ApiParamsVerify;
import com.whty.edu.brain.ig.framework.config.ResponseModel;
import com.whty.edu.brain.ig.framework.exception.CommonDefineException;
import com.whty.edu.brain.ig.framework.util.WebUtil;
import com.whty.edu.brain.ig.framework.verify.VerifyControllerHandle;
import com.whty.edu.brain.ig.framework.verify.VerifyHandle;
import com.whty.edu.brain.ig.framework.verify.annotation.AnnotationHandle;
import com.whty.edu.brain.ig.framework.verify.annotation.Verify;


/**   
 * @formatClassName:  VerifyMethodAspect
 * @Description:TODO 切面处理接口参数校验   
 * @author: generation
 * @date:   2020年04月17日 09:28:367
 * @Copyright: generation
 */
@Component
@Aspect
@Order(1)
public class VerifyMethodAspect {

	private static final Logger log = LoggerFactory.getLogger(VerifyMethodAspect.class);
	
	/**
	 * 	Verify注解包路径
	 */
	public static String VERIFY_PACKAGE = "com.whty.edu.brain.ig.framework.verify.annotation.Verify";
	/**
	 * 	DataMessage包路径，用于返回封装的json消息
	 */
	public static String DATAMESSAGE_PACKAGE = "com.whty.edu.brain.ig.framework.config.ResponseModel";
	/**
	 * 	String包路径
	 */
	public static String STRING_PACKAGE = "java.lang.String";
	/**
	 * 	web返回时返回的校验提醒内容的key值，可用于局部刷新等
	 */
	public static String VERIFY_WARN_KEY = "verify_warn";
	/**
	 * 	各个注解校验方法名
	 */
	public static String VERIFY_METHOD_NAME = "verify";
	/**
	 * 	异常校验提示
	 */
	public static String VERIFY_ERROR_MSG = "参数校验异常";
	/**
	 * 	校验提示key
	 */
	public static String VERIFY_MSG_KEY = "msg";
	
	/**
	 * @Title: around   
	 * @Description: TODO 处理ApiParamsVerify注解标记的参数校验
	 * @param: @param point
	 * @param: @return      
	 * @return: Object      
	 * @throws
	 */
	@Around("@annotation(com.whty.edu.brain.ig.framework.annotation.ApiParamsVerify)")
    public Object around(ProceedingJoinPoint point) {
    	//返回值
    	Object result = null;
    	List<String> verifyResult = new ArrayList<String>();
        Signature signature = point.getSignature();
		MethodSignature methodSignature = (MethodSignature)signature;
	    Method currentMethod = methodSignature.getMethod();
	    String returnType = currentMethod.getReturnType().getName();
	    ApiParamsVerify apiParamsVerify = currentMethod.getAnnotation(com.whty.edu.brain.ig.framework.annotation.ApiParamsVerify.class);
        Parameter[] parameters = currentMethod.getParameters();
        Object[] objs = point.getArgs();
    	try {
            int argsLength = objs.length;
            for(int i = 0;i < argsLength;i++) {
        		Object item = objs[i];
        		Parameter parameter = parameters[i];
        		Annotation[] annotations = parameter.getDeclaredAnnotations();
        		if(null == annotations) {
        			continue;
        		}
        		//校验参数信息
        		for(Annotation aItem : annotations) {
        			//进行参数校验：优先匹配@Verify，若出现@Verify和@NotEmpty(之类)的注解同时作用域一个入参，只执行@Verify
        			if(VERIFY_PACKAGE.equals(aItem.annotationType().getName())) {
        				//若需要参数校验【verify注解修饰】，则遍历参数属性检验
        				com.whty.edu.brain.ig.framework.verify.annotation.Verify v = (Verify)aItem;
        				VerifyControllerHandle verifyHandle = new VerifyControllerHandle();
        				try {
        					verifyResult = verifyHandle.verify(v, item, apiParamsVerify.collect());
    					} catch (Exception e) {
    						//校验异常
    						log.error("参数校验异常", e);
    					}
        				break;
        			}else if(VerifyHandle.PARAM_VERIFY_ANNOTATIONS.contains(aItem.annotationType().getName())) {
        				//注解直接作用于参数，直接开始进行校验
        				AnnotationHandle handle = aItem.annotationType().getAnnotation(AnnotationHandle.class);
        				String handleClass = handle.value();
        				Method annotationMethod = Class.forName(handleClass).getMethod(VERIFY_METHOD_NAME, new Class[] {Annotation.class, Object.class});
        				Object handleInstance = Class.forName(handleClass).newInstance();
        				// 获取校验结果
    					Boolean itemVerifyResult = (Boolean) annotationMethod.invoke(handleInstance, new Object[] {aItem, item});
    					if(!itemVerifyResult) {
    						// 若校验不通过，则收集校验提示信息
    						Method msgMethod = aItem.getClass().getMethod(VERIFY_MSG_KEY);
    						String msg = (String) msgMethod.invoke(aItem);
    						verifyResult.add(msg);
    					}
    					break;
        			}
        		}
        		//无需收集验证错误信息，则直接返回
        		if(CollectionUtils.isNotEmpty(verifyResult) && !apiParamsVerify.collect()) {
        			break;
        		}
            }
    	} catch (Exception e) {
			log.error("控制层入参校验切面处理异常：", e);
		}
    	//执行方法 / 处理校验错误信息
    	try {
    		if(CollectionUtils.isNotEmpty(verifyResult)) {
    			//若校验不通过
				if(STRING_PACKAGE.equals(returnType)) {
					//返回视图:一般视图访问为查询，查询不对入参进行限制
					//执行方法
		            result = point.proceed();
		            WebUtil.setAttribute(VERIFY_WARN_KEY, JSONObject.toJSONString(verifyResult));
				}else if(DATAMESSAGE_PACKAGE.equals(returnType)) {
					//DataMessage方式返回数据
					return ResponseModel.fail(verifyResult);
				}else {
					//如remote接口中，返回类型直接为自定义类或集合等，直接将校验错误信息进行返回
					return verifyResult;
				}
			}else {
				//无错误执行方法
				result = point.proceed();
			}
		} catch (Throwable e) {
			log.error("请求执行异常：", e);
			if(STRING_PACKAGE.equals(returnType)) {
				throw new CommonDefineException("访问异常");
			}else {
				throw new CommonDefineException("请求异常");
			}
		}
    	return result;
    }
}
