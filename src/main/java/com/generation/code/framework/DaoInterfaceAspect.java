package com.generation.code.framework;

import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.alibaba.druid.util.StringUtils;
import com.generation.code.annotation.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
/**
 * @ClassName:  DaoInterfaceAspect   
 * @Description:TODO(DAO切面，处理分页信息)   
 * @author: 曾肖 
 * @date:   2019年5月30日 上午9:47:58   
 *     
 * @Copyright: 2019
 */
@Component
@Aspect
public class DaoInterfaceAspect {
	
	private final Logger logger = LoggerFactory.getLogger(DaoInterfaceAspect.class);
	
	 /**
     * 定义拦截路径
     */
    @Pointcut("execution(* com.generation.code.*.dao..*.*(..))")
    public void executeService(){

    }

    /**
     * 拦截dao访问前
     * @param point
     */
    @Before("executeService()")
    public void doBeforeAdvice(JoinPoint point){
         Signature signature = point.getSignature();
         MethodSignature methodSignature = (MethodSignature)signature;    
         Method targetMethod = methodSignature.getMethod();
         //判断dao接口是否需要分页，若被page注解修饰，则需要分页
         logger.info("【判断是否需要分页】");
         Page page =  targetMethod.getAnnotation(Page.class);
         //当前sql需要分页
         if(page != null) { 
        	 logger.info("【分页处理】");
        	 page(point, page.pageSize());
         }
    }
    
    public void page(JoinPoint point, int pageSize) {
    	HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    	//获取入参对象
    	String requestPageSize = request.getParameter("pageSize");  
        String requestCurPage = request.getParameter("curPage");
        //若为空设置默认值
        if(StringUtils.isEmpty(requestPageSize)) {
        	requestPageSize = String.valueOf(pageSize);
        }
        if(StringUtils.isEmpty(requestCurPage)) {
        	requestCurPage = "1";
        }
        //启动分页
        PageHelper.startPage(Integer.valueOf(requestCurPage), Integer.valueOf(requestPageSize));
    }
    /**
     * 拦截dao的结束节点
     * 拿到当前查询的page对象数据
     * @param joinPoint
     * @param keys
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
	@AfterReturning(value = "execution(* com.generation.code.*.dao..*.*(..))",returning = "keys")
    public void doAfterReturning(JoinPoint joinPoint,Object keys){
    	Signature signature = joinPoint.getSignature();
    	//获取当前方法对象
        MethodSignature methodSignature = (MethodSignature)signature;    
        Method targetMethod = methodSignature.getMethod();
        //当前方法对象page注解
        Page page =  targetMethod.getAnnotation(Page.class);
        if(keys != null && page != null) {
        	//返回结果为List，进行强转
        	List<Object> result = (List<Object>)keys;
        	//组装当前dao查询的page对象
        	PageInfo pageInfo = new PageInfo<>(result);
        	HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        	PageVO pageVO = new PageVO();
        	pageVO.setCurPage(pageInfo.getPageNum());
        	pageVO.setPageSize(pageInfo.getPageSize());
        	pageVO.setTotal(pageInfo.getTotal());
        	pageVO.setTotalPage(pageInfo.getPages());
        	//将当前查询的page对象丢到request中去，待controller处理返回
        	request.setAttribute("pageInfo", pageVO);
        }
    }
}
