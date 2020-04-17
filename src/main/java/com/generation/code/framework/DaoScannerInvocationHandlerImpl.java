/**  
 * @Title:  DaoScannerInvocationHandlerImpl.java   
 * @Package com.generation.code.framework   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: 曾肖
 * @date:   2019年6月5日 下午6:09:09   
 * @version V1.0 
 * @Copyright: 2019
 */
package com.generation.code.framework;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**   
 * @ClassName:  DaoScannerInvocationHandlerImpl   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author: 曾肖 
 * @date:   2019年6月5日 下午6:09:09   
 *     
 * @Copyright: 2019
 */
public class DaoScannerInvocationHandlerImpl implements InvocationHandler {
	/**
	 * 代理对象
	 */
	private Object proxyObject;
	
	/**   
	 * <p>Title: invoke</p>   
	 * <p>Description: </p>   
	 * @param proxy
	 * @param method
	 * @param args
	 * @return
	 * @throws Throwable   
	 * @see java.lang.reflect.InvocationHandler#invoke(java.lang.Object, java.lang.reflect.Method, java.lang.Object[])   
	 */
	@Override
	public Object invoke(Object proxyObject, Method method, Object[] args) throws Throwable {
		//在真实的对象执行之前我们可以添加自己的操作
        System.out.println("before invoke。。。");
        Object invoke = method.invoke(proxyObject, args);
        //在真实的对象执行之后我们可以添加自己的操作
        System.out.println("after invoke。。。");
        return invoke;
	}

	/**   
	 * @Title:  DaoScannerInvocationHandlerImpl   
	 * @Description: 默认构造函数
	 * @param:    
	 * @throws   
	 */
	public DaoScannerInvocationHandlerImpl() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @Title:  DaoScannerInvocationHandlerImpl   
	 * @Description:TODO 注入代理对象
	 * @param:  @param proxyObject  
	 * @throws
	 */
	public DaoScannerInvocationHandlerImpl(Object proxyObject) {
		this.proxyObject = proxyObject;
	}
	
	/**get/set**/
	
	public Object getProxyObject() {
		return proxyObject;
	}

	public void setProxyObject(Object proxyObject) {
		this.proxyObject = proxyObject;
	}
	
}
