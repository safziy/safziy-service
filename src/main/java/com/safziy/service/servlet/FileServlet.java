package com.safziy.service.servlet;

import java.io.File;
import java.io.IOException;
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
import com.safziy.commom.utils.DateUtils;
import com.safziy.commom.utils.JSONUtils;
import com.safziy.commom.utils.XLSReaderUtils;
import com.safziy.service.listener.InitListener;

public class FileServlet extends AbstractServlet{

	private static final long serialVersionUID = 1L;
	
	public void uploadFile(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
						if (item.getName().contains(".xlsx") || item.getName().contains(".xls")) {
							String filePath = getUploadFilePath(req, item);
							File uploadFile = new File(filePath);
							item.write(uploadFile);
							List<List<Object>> data = XLSReaderUtils.getData(uploadFile);
							jsonObj.put("content",JSONUtils.list2String(data));
						} else {
							jsonObj.put("msg", "上传文件不是excel文件");
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
	
	/**
	 * 获取上传文件的路径
	 * 
	 * @param request
	 * @param item
	 * @return
	 */
	private String getUploadFilePath(HttpServletRequest request, FileItem item) {
		String totalName = item.getName();
		String name = "temp";
		if (totalName != "") {
			name = totalName.substring(totalName.lastIndexOf("\\") + 1);
			String dateStr = DateUtils.formatDate(System.currentTimeMillis(), DateUtils.SEQUENCE_UPDATE_TIME_FORMAT);
			if (name.contains(".")) {
				name = name.substring(0, name.lastIndexOf(".")) + "_" + dateStr
						+ name.substring(name.lastIndexOf("."), name.length());
			} else {
				name += "_" + dateStr;
			}
		} else {
			name = "temp";
		}
		return InitListener.UPLOAD_FILE_PATH + "/" + name;
	}

}
