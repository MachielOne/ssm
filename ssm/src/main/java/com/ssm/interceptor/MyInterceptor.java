package com.ssm.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class MyInterceptor implements HandlerInterceptor {
	private static final Logger log = Logger.getLogger(MyInterceptor.class);

	/**
	 * 在DispatcherServlet之前执行
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		log.info("<<<<<<<<<<MyInterceptor preHandle executed>>>>>>>>>>>>");
		return true;
	}

	/**
	 * 在controller执行之后的DispatcherServlet之后执行
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		log.info("<<<<<<<<<<MyInterceptor postHandle executed>>>>>>>>>>>>");
	}

	/**
	 * 在页面渲染完成返回给客户端之前执行
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		log.info("<<<<<<<<<<MyInterceptor afterCompletion executed>>>>>>>>>>>>");
	}

}
