package com.safziy.service.servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.time.StopWatch;

import com.safziy.commom.service.log.LogUtil;
import com.safziy.service.annotation.HttpMethod;

public class AbstractServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private static final String GET = "get";
	private static final String POST = "post";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		executeMethod(req, resp, GET);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		executeMethod(req, resp, POST);
	}

	private void executeMethod(HttpServletRequest req, HttpServletResponse resp, String getOrPost)
			throws ServletException, IOException {
		StopWatch servletWatch = new StopWatch();
		servletWatch.start();
		String methodName = getString(req, "method", "execute");
		try {
			Method method = getClass().getMethod(methodName,
					new Class<?>[] { HttpServletRequest.class, HttpServletResponse.class });
			HttpMethod httpMethod = method.getAnnotation(HttpMethod.class);
			if (httpMethod == null) {
				method.invoke(this, new Object[] { req, resp });
			} else if (getOrPost.equals(GET) && httpMethod.get()) {
				method.invoke(this, new Object[] { req, resp });
			} else if (getOrPost.equals(POST) && httpMethod.post()) {
				method.invoke(this, new Object[] { req, resp });
			} else {
				requestNotFound(resp);
			}
		} catch (Exception e) {
			requestNotFound(resp);
		}
		servletWatch.stop();
		LogUtil.info(getClass().getSimpleName() + " func= " + methodName + "  execute time " + servletWatch.getTime());
	}

	protected void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		requestNotFound(resp);
	}

	protected void forward(HttpServletRequest req, HttpServletResponse resp, String path) throws ServletException,
			IOException {
		RequestDispatcher rd = req.getRequestDispatcher(path);
		rd.forward(req, resp);
	}

	protected void redirect(HttpServletRequest req, HttpServletResponse resp, String path) throws ServletException,
			IOException {
		resp.sendRedirect(path);
	}

	protected void requestNotFound(HttpServletResponse resp) {
		write(resp, HttpServletResponse.SC_NOT_FOUND, "");
	}

	protected void success(HttpServletResponse resp, String message) {
		write(resp, HttpServletResponse.SC_OK, message);
	}

	protected void write(HttpServletResponse resp, int stateCode, String message) {
		try {
			resp.setCharacterEncoding("UTF8");
			resp.setStatus(stateCode);
			resp.getWriter().write(message);
			resp.getWriter().flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	protected String getString(HttpServletRequest req, String paramName) {
		return req.getParameter(paramName);
	}

	protected String getString(HttpServletRequest req, String paramName, String defaultValue) {
		String value = req.getParameter(paramName);
		if (value == null || value.length() == 0) {
			value = defaultValue;
		}
		return value;
	}

}
