package com.lyb.client.utils;

import java.util.HashMap;
import java.util.List;

import com.lyb.client.model.ServerInfo;
import com.safziy.service.utils.HttpRequester;

public class ServerListUtils {
	public static List<ServerInfo> getAllServer(){
		String result = HttpRequester.getInstance().doPost("", new HashMap<String, Object>());
		return null;
	}
}
