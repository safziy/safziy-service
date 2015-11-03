package com.lyb.client.processor.impl;

import com.lyb.client.model.Player;
import com.lyb.client.processor.*;
import com.lyb.client.message.protocol.*;

/**
 * 返回 登陆结束
 * 
 * @author codeGenerator
 * 
 */
public class Processor_1003_2 extends IMessageProcessor<Message_1003_2> {

	@Override
	public void execute(Player player, Message_1003_2 message) throws Exception {
		player.initComplete();
	}
}
