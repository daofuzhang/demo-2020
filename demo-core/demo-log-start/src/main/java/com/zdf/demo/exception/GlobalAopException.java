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
	 
	    @Pointcut("execution(* com.test.*.*(..))")//�˴�����������Ŀ��·�������������
	    public void pointCut(){}
	 
	    @Around("pointCut()")
	    public Object handleControllerMethod(ProceedingJoinPoint pjp) {
	        
	        try {
	            logger.info("ִ��Controller��ʼ: " + pjp.getSignature() + " ������" + pjp.getArgs().toString());
	          
	        } catch (Throwable throwable) {
	           
	        }
	        return null;
	    }
	
}
