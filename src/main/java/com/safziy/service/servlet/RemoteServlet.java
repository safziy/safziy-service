package com.safziy.service.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.json.JSONObject;

import com.safziy.commom.service.log.LogUtil;
import com.safziy.service.remote.JavaClassExecuter;

public class RemoteServlet extends AbstractServlet {

	private static final long serialVersionUID = 1L;

	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("res", 0);
		try {
			List<FileItem> items = upload.parseRequest(req);
			Iterator<FileItem> itr = items.iterator();
			while (itr.hasNext()) {
				FileItem item = (FileItem) itr.next();
				if (!item.isFormField()) {
					if (!(item.getName() == null || item.getName().trim().equals(""))) {
						if (item.getName().contains(".class")) {
							InputStream is = item.getInputStream();
							byte[] b = new byte[is.available()];
							is.read(b);
							is.close();
							String result = JavaClassExecuter.execute(b);
							jsonObj.put("result", result);
						} else {
							jsonObj.put("msg", "上传文件不是class文件");
						}
					} else {
						jsonObj.put("msg", "没有上传上传文件");
					}
				}
			}
		} catch (Exception e) {
			LogUtil.error(e);
			jsonObj.put("msg", "上传文件失败");
		}
		success(resp, jsonObj.toString());
	}

}
