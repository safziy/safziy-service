package com.lyb.client.utils;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import org.json.JSONObject;

import com.lyb.client.model.ServerInfo;
import com.safziy.service.utils.HttpRequester;
import com.safziy.service.utils.ValidateUtils;

public class ServerListUtils {
	public static List<ServerInfo> getAllServer() {
		List<ServerInfo> list = new LinkedList<ServerInfo>();
		String result = HttpRequester.getInstance().doPost("", new HashMap<String, Object>());
		JSONObject json = new JSONObject(result);
		if (ValidateUtils.isNotEqual(json.getInt("ret"), 1)) {
			return list;
		}
		return null;
	}
}
