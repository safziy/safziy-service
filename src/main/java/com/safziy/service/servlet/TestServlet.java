package com.safziy.service.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.safziy.service.annotation.HttpMethod;
import com.safziy.service.context.SpringContext;

public class TestServlet extends AbstractServlet {

	private static final long serialVersionUID = 1L;

	@HttpMethod(post = false)
	public void test(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(Thread.currentThread().getThreadGroup().activeCount());
		System.out.println(Thread.currentThread().getName());
		final Map<Integer, String> map = new HashMap<Integer, String>();
		for (int i = 0; i < 20; i++) {
			final int index = i;
			Thread tempThread = new Thread(new Runnable() {
				@Override
				public void run() {
					for (int i = 0; i < 5; i++) {
						try {
							Thread.sleep(500);
						} catch (InterruptedException e) {
						}
						System.out.println(Thread.currentThread().getName() + " value of i is " + i);
						map.put(index, Thread.currentThread().getName());
					}
				}
			});
			SpringContext.getInstance().getSubProcessPool().submit(tempThread);
		}
		// TODO 此处有线程安全问题 有可能触发ConcurrentModificationException
		while (map.size() < 20) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
			}
		}
		System.out.println("all thread run over!");
		forward(req, resp, "ok.jsp");
	}
	
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		forward(req, resp, "ok.jsp");
	}

}
