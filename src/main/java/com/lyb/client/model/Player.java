package com.lyb.client.model;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import com.lyb.client.manager.PlayerManager;
import com.lyb.client.message.protocol.Message_2_1;
import com.lyb.client.message.protocol.Message_2_11;
import com.lyb.client.message.protocol.Message_2_13;
import com.lyb.client.message.protocol.Message_2_7;

public class Player {
	private Client client;

	private String yunyingUserId;
	private List<RoleMessage> roleList = new LinkedList<RoleMessage>();
	
	private PlayerData plyerData = new PlayerData();
	private PlayerManager playerManager = new PlayerManager();

	public Player(Client client) {
		this.client = client;
	}
	
	/**
	 * 登陆游戏服务器 获取角色信息
	 */
	public void login() {
		Message_2_11 message_2_11 = new Message_2_11();
		message_2_11.setPlatformId(client.getPlatformId());
		message_2_11.setKey(client.getAccount());
		message_2_11.setPwd("0");
		// install_key=3b81401b-f1e1-49ed-a8a9-c0d7cf242ac9&mac=C0EEFB0760E2&udid=2195a60013127174&gameversion=1.1.177&
		// clienttype=A0001&clientversion=4.3&channel_id=0&networktype=wifi&clientpixel=1920x1080
		// &serial_number=19786d06&android_id=2195a60013127174&google_aid=2195a60013127174&location=cn
		// &src=lan_test&equipment=nocrack&carrier=&idfa=&simulator=0&WifiMac=&BootTime=0&unique_key=langyabang_androidcn_prod
		String dcStr = "install_key=3b81401b-f1e1-49ed-a8a9-c0d7cf242ac9&mac=C0EEFB0760E2&udid=2195a60013127174&gameversion=1.1.177&clienttype=A0001&clientversion=4.3&channel_id=0&networktype=wifi&clientpixel=1920x1080 &serial_number=19786d06&android_id=2195a60013127174&google_aid=2195a60013127174&location=cn&src=lan_test&equipment=nocrack&carrier=&idfa=&simulator=0&WifiMac=&BootTime=0&unique_key=langyabang_androidcn_prod";
		message_2_11.setDCParamStr(dcStr);
		client.write(message_2_11);
	}

	/**
	 * 请求角色登陆认证
	 */
	public void authentication() {
		Iterator<RoleMessage> it = roleList.iterator();
		if (it.hasNext()) {
			RoleMessage role = it.next();
			Message_2_1 message = new Message_2_1();
			message.setUserName("");
			message.setOrigainalServerId(role.getOrigainalServerId());
			client.write(message);
		} else {
			createRole();
		}
	}
	
	/**
	 * 请求角色登陆认证
	 */
	public void init() {
		Message_2_7 message = new Message_2_7();
		client.write(message);
	}

	/**
	 * 初始化角色完成
	 */
	public void initComplete() {
		Message_2_13 message = new Message_2_13();
		client.write(message);
	}

	/**
	 * 请求初始化角色
	 */
	public void createRole() {

	}

	public void setYunyingUserId(String yunyingUserId) {
		this.yunyingUserId = yunyingUserId;
	}

	public String getYunyingUserId() {
		return yunyingUserId;
	}

	public List<RoleMessage> getRoleList() {
		return roleList;
	}
	
	public PlayerData getPlyerData() {
		return plyerData;
	}
	
	public PlayerManager getPlayerManager() {
		return playerManager;
	}
	
}
