<%@ page import="java.util.Map.Entry"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>服务器线程信息</title>
</head>
<body>
	<pre>
	<%
		for (Entry<Thread, StackTraceElement[]> entry : Thread.getAllStackTraces().entrySet()) {
			Thread thread = entry.getKey();
			StackTraceElement[] stack = entry.getValue();
			if (thread.equals(Thread.currentThread())) {
				continue;
			}
			out.print("\n线程: " + thread.getName() + "\n");
			for (StackTraceElement element : stack) {
				out.print("\t" + element + "\n");
			}
		}
	%>
</pre>
</body>
</html>