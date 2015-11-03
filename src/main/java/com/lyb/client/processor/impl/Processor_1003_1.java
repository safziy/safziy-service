package com.lyb.client.processor.impl;

import com.lyb.client.message.protocol.Message_1003_1;
import com.lyb.client.model.Player;
import com.lyb.client.processor.IMessageProcessor;

/**
 * 返回 玩家基本信息
 * 
 * @author codeGenerator
 * 
 */
public class Processor_1003_1 extends IMessageProcessor<Message_1003_1> {

	@Override
	public void execute(Player player, Message_1003_1 message) throws Exception {
		// 22:08:27,884 DEBUG commonLogger:15 - Receive [1003_1
		// ]yunyingUserId:f555, userId:2003100012751, userName:莫欺少年穷,
		// career:9000, vip:21420, familyId:2003100000532, familyPositionId:1,
		// familyName:aa1, familyLevel:1, nobility:5,
		// generalIdTableArray:[{configId:28}, {configId:22}, {configId:77},
		// {configId:89}, {configId:10}], lastStrongPointId:10001175, state:3,
		// stage:99999, step:0, level:45, experience:1805, transforId:18,
		// zodiacId:10908
		
		player.getPlyerData().setUserId(message.getUserId());
		player.getPlyerData().setUserName(message.getUserName());
		player.getPlyerData().setCareer(message.getCareer());
		player.getPlyerData().setVip(message.getVip());
		player.getPlyerData().setFamilyId(message.getFamilyId());
		player.getPlyerData().setFamilyPositionId(message.getFamilyPositionId());
		player.getPlyerData().setFamilyName(message.getFamilyName());
		player.getPlyerData().setFamilyLevel(message.getFamilyLevel());
		player.getPlyerData().setNobility(message.getNobility());
		player.getPlyerData().setLastStrongPointId(message.getLastStrongPointId());
		player.getPlyerData().setState(message.getState());
		player.getPlyerData().setStage(message.getStage());
		player.getPlyerData().setStep(message.getStep());
		player.getPlyerData().setLevel(message.getLevel());
		player.getPlyerData().setExperience(message.getExperience());
		player.getPlyerData().setStransforId(message.getTransforId());
		player.getPlyerData().setZodiacId(message.getZodiacId());
		
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
		// 22:08:27,891 DEBUG commonLogger:15 - Receive [1003_2 ]
	}
}
