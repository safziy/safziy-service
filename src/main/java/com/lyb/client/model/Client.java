package com.lyb.client.model;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

import com.lyb.client.message.IMessage;
import com.lyb.client.net.ClientChannelInitializer;

public class Client {
	private String serverIp;
	private int platformId;
	private String account;
	
	private Channel channel;
	Player player;

	public Client(String serverIp, int platformId, String account) {
		this.serverIp = serverIp;
		this.platformId = platformId;
		this.account = account;
	}

	public void start() {
		EventLoopGroup group = new NioEventLoopGroup(1);
		try {
			Bootstrap bootstrap = new Bootstrap();
			bootstrap.group(group).channel(NioSocketChannel.class).handler(new ClientChannelInitializer(this));
			ChannelFuture f = bootstrap.connect(serverIp, 8081).sync();
			f.channel().closeFuture().sync();
		} catch (InterruptedException e) {
			group.shutdownGracefully();
		}
	}
	
	public void setChannel(Channel channel) {
		this.channel = channel;
	}
	
	public void play(){
		player = new Player(this);
		player.login();
	}
	
	public void write(IMessage message){
		channel.write(message);
		channel.flush();
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public int getPlatformId() {
		return platformId;
	}
	
	public String getAccount() {
		return account;
	}

}
