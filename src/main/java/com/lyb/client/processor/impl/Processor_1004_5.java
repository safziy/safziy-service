package com.lyb.client.processor.impl;

import com.lyb.client.message.protocol.Message_1004_5;
import com.lyb.client.model.Player;
import com.lyb.client.processor.IMessageProcessor;

/**
 * 返回 英雄志
 * 
 * @author codeGenerator
 * 
 */
public class Processor_1004_5 extends IMessageProcessor<Message_1004_5> {

	@Override
	public void execute(Player player, Message_1004_5 message) throws Exception {
		// 22:08:27,888 DEBUG commonLogger:15 - Receive [1004_5
		// ]yXZStrongPointArray:[{iD:21010101, strongPointId:21010101, count:0,
		// totalCount:15, state:1, starLevel:3}, {iD:21020101,
		// strongPointId:21020101, count:0, totalCount:15, state:1,
		// starLevel:3}, {iD:21030101, strongPointId:21030101, count:0,
		// totalCount:15, state:1, starLevel:3}, {iD:21040101,
		// strongPointId:21040101, count:0, totalCount:14, state:1,
		// starLevel:3}, {iD:21050101, strongPointId:21050101, count:0,
		// totalCount:9, state:1, starLevel:3}, {iD:21060101,
		// strongPointId:21060101, count:0, totalCount:6, state:1, starLevel:3},
		// {iD:21070101, strongPointId:21070101, count:0, totalCount:3, state:1,
		// starLevel:3}]
	}
}
