package com.whty.edu.brain.ig.framework.config;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**   
 * @formatClassName:  ThreadLocalVariableFilter
 * @Description:TODO 线程本地变量过滤器
 * @author: generation
 * @date:   2020年04月17日 09:28:373
 * @Copyright: generation
 */
@WebFilter(urlPatterns = {"/*"}, filterName = "ThreadLocalVariableFilter")
public class ThreadLocalVariableFilter implements Filter {

	@Override
	public void destroy() {}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		ThreadLocalVariableHolder.setHttpServletRequest(request);
		ThreadLocalVariableHolder.setHttpServletResponse(response);
		chain.doFilter(servletRequest, servletResponse);
	}

	@Override
	public void init(FilterConfig config) throws ServletException {}

}
