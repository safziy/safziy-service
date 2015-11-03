package com.lyb.client.processor.impl;

import com.lyb.client.log.LogUtil;
import com.lyb.client.model.Player;
import com.lyb.client.model.RoleMessage;
import com.lyb.client.processor.*;
import com.lyb.client.message.protocol.*;
import com.lyb.client.message.protocol.segment.UserAccountInfoArray.UserAccountInfoArrayItem;

/**
 * 返回  服务器账号数据
 * 
 * @author codeGenerator
 * 
 */
public class Processor_1002_11 extends IMessageProcessor<Message_1002_11> {

	@Override
	public void execute(Player player, Message_1002_11 message) throws Exception {
		int loginState = message.getLoginState();
		switch (loginState) {
		case 0:
			player.setYunyingUserId(message.getYunyingUserId());
			for (UserAccountInfoArrayItem item : message.getUserAccountInfoArray().list()) {
				RoleMessage role = new RoleMessage();
				role.setUserName(item.getUserName());
				role.setCareer(item.getCareer());
				role.setLevel(item.getLevel());
				role.setOrigainalServerId(item.getOrigainalServerId());
				player.getRoleList().add(role);
			}
			player.authentication();
			break;
		case 1:
			LogUtil.error("服务器返回用户名或密码错误");
			break;
		case 2:
			LogUtil.error("服务器返回没有邀请码");
			break;
		case 3:
			LogUtil.error("服务器返回Mac地址被封");
			break;
		case 4:
			LogUtil.error("服务器返回IP被封");
			break;
		case 5:
			LogUtil.error("服务器返回没有测试资格");
			break;
		case 6:
			LogUtil.error("服务器返回暂时没有开放");
			break;
		default:
			LogUtil.error("服务器返回未知错误码");
			break;
		}
	}
}
