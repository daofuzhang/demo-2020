package com.zdf.demo.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zdf.demo.model.Result;


@ControllerAdvice
public class GlobalControllerException {

	private static final Logger logger = LoggerFactory.getLogger(GlobalControllerException.class);

	@ResponseBody
	@ExceptionHandler(value = Exception.class)
	public Result javaExceptionHandler(Exception ex) {// APIResponse是项目中对外统一的出口封装，可以根据自身项目的需求做相应更改
		logger.error("捕获到Exception异常", ex);
		return new Result("E",  ex.getMessage().toString());
	}
	
}
