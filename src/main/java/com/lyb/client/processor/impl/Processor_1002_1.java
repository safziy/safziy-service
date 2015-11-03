package com.lyb.client.processor.impl;

import com.lyb.client.model.Player;
import com.lyb.client.processor.*;
import com.lyb.client.message.protocol.*;

/**
 * 返回 登录认证
 * 
 * @author codeGenerator
 * 
 */
public class Processor_1002_1 extends IMessageProcessor<Message_1002_1> {

	@Override
	public void execute(Player player, Message_1002_1 message) throws Exception {
		int loginState = message.getLoginState();
		switch (loginState) {
		case 2:
			player.init();
			break;
		default:
			break;
		}
	}
}
