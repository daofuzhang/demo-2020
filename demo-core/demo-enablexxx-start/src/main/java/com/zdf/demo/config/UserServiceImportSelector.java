package com.zdf.demo.config;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import com.zdf.demo.service.TestServiceA;

/**
 * 第一种方法
 * @author daofu
 *
 */
public class UserServiceImportSelector implements ImportSelector {

	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		
		return new String[] {TestServiceA.class.getName()};
	}

}
