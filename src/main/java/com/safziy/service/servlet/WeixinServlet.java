package com.safziy.service.servlet;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.safziy.commom.utils.SignUtils;
import com.safziy.service.constant.WeixinConstants;

public class WeixinServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String signature = req.getParameter("signature");
		String timestamp = req.getParameter("timestamp");
		String nonce = req.getParameter("nonce");
		String echostr = req.getParameter("echostr");

		String[] arr = new String[] { WeixinConstants.MY_TOKEN, timestamp, nonce };
		Arrays.sort(arr);
		StringBuilder sb = new StringBuilder();
		for (String str : arr) {
			sb.append(str);
		}
		String signStr = SignUtils.SHA1(sb.toString());
		String result = "";
		if (signStr.equals(signature)) {
			result = echostr;
		}
		resp.getWriter().write(result);
		resp.getWriter().flush();

	}

}
