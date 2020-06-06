package com.zdf.demo.config;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.util.StringUtils;

import com.zdf.demo.service.TestServiceB;

/**
 * 第二种方式
 * @author daofu
 *
 */
public class UserBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, 
		    BeanDefinitionRegistry registry) {
		
		AnnotationAttributes annotationAttributes = AnnotationAttributes.fromMap(
	        	importingClassMetadata.getAnnotationAttributes(
	        							EnableMyOwnBeanDefinitions.class.getName()));
		
		{
			Class beanClass =TestServiceB.class;
			RootBeanDefinition beanDefinition = new RootBeanDefinition(beanClass);
			String beanName = StringUtils.uncapitalize(beanClass.getSimpleName());
            registry.registerBeanDefinition(beanName, beanDefinition);
		}
		
	}
	
}
