package com.zdf.demo.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zdf.demo.model.ErrorInfo;

@ControllerAdvice
public class GlobalControllerException {

	private static final Logger logger = LoggerFactory.getLogger(GlobalControllerException.class);

	@ResponseBody
	@ExceptionHandler(value = Exception.class)
	public ErrorInfo javaExceptionHandler(Exception ex) {// APIResponse����Ŀ�ж���ͳһ�ĳ��ڷ�װ�����Ը���������Ŀ����������Ӧ����
		logger.error("����Exception�쳣", ex);
		return new ErrorInfo("E",  ex.getMessage());
	}
}