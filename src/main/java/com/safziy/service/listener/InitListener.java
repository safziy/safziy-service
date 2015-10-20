package com.safziy.service.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.commons.lang.time.StopWatch;

import com.safziy.service.context.SpringContext;
import com.safziy.service.log.LogUtil;

public class InitListener implements ServletContextListener {

	public void contextDestroyed(ServletContextEvent arg0) {

	}

	public void contextInitialized(ServletContextEvent arg0) {
		LogUtil.info("com.safziy.service.listener.InitListener  contextInitialized");
		StopWatch startWatch = new StopWatch();
		startWatch.start();
		
		SpringContext.getInstance().init();
		
		startWatch.stop();
		LogUtil.info("com.safziy.service.listener.InitListener  contextInitialized time  " + startWatch.getTime());
	}

}
