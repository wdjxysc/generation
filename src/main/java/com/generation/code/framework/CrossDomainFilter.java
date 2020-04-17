package com.generation.code.framework;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.annotation.Order;
/**
 * @ClassName:  CrossDomainFilter   
 * @Description:TODO(处理跨域请求限制)   
 * @author: 曾肖 
 * @date:   2019年5月30日 上午9:47:50   
 *     
 * @Copyright: 2019
 */
@Order(1)
@WebFilter(filterName = "headerfilter", urlPatterns = "/*")
public class CrossDomainFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
			HttpServletResponse res = (HttpServletResponse) response;
			// 这里最好不要写通配符，如果允许多个域请求数据的话，可以直接用逗号隔开："http://www.baidu.com,http://google.com"
			res.setHeader("Access-Control-Allow-Origin", "*");
			res.setHeader("Access-Control-Allow-Methods", "*");
			res.setHeader("Access-Control-Allow-Headers", "Content-Type, Authorization, Accept,X-Requested-With Origin Last-Modified");
			res.setHeader("XDomainRequestAllowed","1");
			chain.doFilter(request, response);
	}
	@Override
	public void destroy() {
	}
}
