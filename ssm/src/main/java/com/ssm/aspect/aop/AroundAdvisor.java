package com.ssm.aspect.aop;

import java.util.Arrays;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AroundAdvisor {
	private static final Logger log = Logger.getLogger(AroundAdvisor.class);

	@Before(value = "execution(* com.ssm.service.*.*(..))")
	public void beforeMethod(JoinPoint jp) {
		String methodName = jp.getSignature().getName();
		log.info("<<<<<<<<<<<<<<<<the method 【" + methodName + "】 前置通知 ---->>>>>>>>>>>>>>>>>>>");
	}

	@AfterReturning(value = "execution(* com.ssm.service.*.*(..))", returning = "result")
	public void returningMethod(JoinPoint jp, Object result) {
		String methodName = jp.getSignature().getName();
		log.info("<<<<<<<<<<<<<<<<the method 【" + methodName + "】 返回通知----- >>>>>>>>>>>>>>>>>>>\\n" + result);
	}

	@After("execution(* com.ssm.service.*.*(..))")
	public void afterMethod(JoinPoint jp) {
		log.info("后置通知----->>>>this is a afterMethod advice...");
	}

	/* @Around(value = "execution(* com.ssm.service.*.*(..))") */
	public Object aroundMethod(ProceedingJoinPoint jp) {
		String methodName = jp.getSignature().getName();
		Object result = null;
		try {
			log.info("环绕通知中的前置通知----->>>>>the method 【" + methodName + "】 begins with " + Arrays.asList(jp.getArgs()));
			// 执行目标方法
			result = jp.proceed();
			log.info("环绕通知中的返回通知----->>>>>the method 【" + methodName + "】 ends with " + result);
		} catch (Throwable e) {
			log.info("环绕通知中的异常通知----------->>>>the method 【" + methodName + "】 occurs exception " + e);
		}
		log.info("环绕通知中的后置通知-->>>>end");
		return result;
	}

	@AfterThrowing(value = "execution(* com.ssm.service.*.*(..))", throwing = "e")
	public void afterThorwingMethod(JoinPoint jp, Exception e) {
		String methodName = jp.getSignature().getName();
		log.info("异常通知----->>the method 【" + methodName + "】 occurs exception: " + e);
	}

}
