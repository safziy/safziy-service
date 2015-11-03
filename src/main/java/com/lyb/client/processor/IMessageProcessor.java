package com.lyb.client.processor;

import com.lyb.client.message.IMessage;
import com.lyb.client.model.Player;

public abstract class IMessageProcessor<T extends IMessage>{
	
	@SuppressWarnings("unchecked")
	public void exec(Player player, IMessage message){
		try {
			execute(player, (T)message);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public abstract void execute(Player player, T message) throws Exception;
}
