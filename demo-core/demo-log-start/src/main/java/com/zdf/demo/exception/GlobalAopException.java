package com.zdf.demo.exception;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class GlobalAopException {

	 public static final Logger logger = LoggerFactory.getLogger(GlobalAopException.class);
	 
	    @Pointcut("execution(* com.test.*.*(..))")//此处基于自身项目的路径做具体的设置
	    public void pointCut(){}
	 
	    @Around("pointCut()")
	    public Object handleControllerMethod(ProceedingJoinPoint pjp) {
	        
	        try {
	            logger.info("执行Controller开始: " + pjp.getSignature() + " 参数：" + pjp.getArgs().toString());
	          
	        } catch (Throwable throwable) {
	           
	        }
	        return null;
	    }
	
}
