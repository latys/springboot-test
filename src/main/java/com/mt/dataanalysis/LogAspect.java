package com.mt.dataanalysis;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
public class LogAspect {

	private Logger logger = LoggerFactory.getLogger(LogAspect.class);
	
	 @Pointcut("execution(public * com.mt.dataanalysis.Service.*.*(..))")
	 public void LogAspect(){}
	 
	  @Before("LogAspect()")
	    public void doBefore(JoinPoint joinPoint) throws Throwable {
	        // 接收到请求，记录请求内容
	        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
	        HttpServletRequest request = attributes.getRequest();

	        // 记录下请求内容
	        logger.info("URL : " + request.getRequestURL().toString());
//	        logger.info("HTTP_METHOD : " + request.getMethod());
//	        logger.info("IP : " + request.getRemoteAddr());
//	        logger.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
//	        logger.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));
	    }


}
