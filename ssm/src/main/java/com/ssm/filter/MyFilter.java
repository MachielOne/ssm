package com.ssm.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.log4j.Logger;

public class MyFilter implements Filter {
	private static final Logger log = Logger.getLogger(MyFilter.class);

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// 在DispatcherServlet之前执行
		log.info("<<<<<<<<Before MyFilter doFilter executed >>>>>>>>>>");
		chain.doFilter(request, response);
		// 在视图页面返回给客户端之前执行，但是执行顺序在Interceptor之后
		log.info("<<<<<<<<<After MyFilter doFilter executed >>>>>>>>>>");
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
