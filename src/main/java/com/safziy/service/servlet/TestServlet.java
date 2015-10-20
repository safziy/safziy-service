package com.safziy.service.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.safziy.service.annotation.HttpMethod;

public class TestServlet extends AbstractServlet {

	private static final long serialVersionUID = 1L;

	@HttpMethod(post = false)
	public void test(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		forward(req, resp, "ok.jsp");
	}
	
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		forward(req, resp, "ok.jsp");
	}

}
