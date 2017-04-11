package com.common;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;

public class SpringContextHolder implements ApplicationContextAware {
	
	private static ConfigurableApplicationContext applicationContext;

	@SuppressWarnings("static-access")
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = (ConfigurableApplicationContext)applicationContext;
	}

	public static ConfigurableApplicationContext getApplicationContext() {
		checkApplicationContext();
		return applicationContext;
	}

	private static void checkApplicationContext() {
		if(applicationContext == null){
			throw new IllegalStateException("applicaitonContext未注入,请在applicationContext.xml中定义springContextHolder");
		}
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T getBean(String beanID){
		checkApplicationContext();
		return (T)applicationContext.getBean(beanID);
	}
	
	

}
