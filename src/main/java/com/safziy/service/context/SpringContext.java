package com.safziy.service.context;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.safziy.commom.service.log.LogUtil;
import com.safziy.comom.service.threadpool.ControlCenter;

public class SpringContext {
	private static class LazyHolder {
		public static final SpringContext holder = new SpringContext();
	}

	public static final SpringContext getInstance() {
		return LazyHolder.holder;
	}

	private ApplicationContext applicationContext;

	public void init() {
		LogUtil.info("com.safziy.service.context.SpringContext  init ");
		this.applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
	}

	public ControlCenter getSubProcessPool() {
		return (ControlCenter) applicationContext.getBean("SubProcessPool");
	}

}
