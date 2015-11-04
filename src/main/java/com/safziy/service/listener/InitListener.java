package com.safziy.service.listener;

import java.io.File;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.commons.lang.time.StopWatch;

import com.safziy.commom.service.log.LogUtil;
import com.safziy.service.context.SpringContext;

public class InitListener implements ServletContextListener {
	
	public static String UPLOAD_FILE_PATH = "/data/safziy-service/upload_file/";

	public void contextDestroyed(ServletContextEvent arg0) {

	}

	public void contextInitialized(ServletContextEvent arg0) {
		LogUtil.info("com.safziy.service.listener.InitListener  contextInitialized");
		StopWatch startWatch = new StopWatch();
		startWatch.start();
		
		SpringContext.getInstance().init();
		File file = new File(UPLOAD_FILE_PATH);
		if(!file.exists()){
			file.mkdirs();
		}
		
		startWatch.stop();
		LogUtil.info("com.safziy.service.listener.InitListener  contextInitialized time  " + startWatch.getTime());
	}

}
