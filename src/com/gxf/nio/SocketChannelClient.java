package com.gxf.nio;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * 测试SocketChannel
 * @author GXF
 *
 */
public class SocketChannelClient {
	//服务器监听端口号
	private static final int SERVER_PORT_NUM = 9999;
	private static SocketChannel socketChannel;
	private static final int BUFFER_SIZE = 512;
	
	public void init() throws IOException{
		//初始化套接字通道
		socketChannel = SocketChannel.open();		
	}
	
	public void sendMessageToServer() throws IOException{
		//先连接服务器
		SocketAddress remoteAddress = new InetSocketAddress(InetAddress.getLocalHost(), SERVER_PORT_NUM);
		if(socketChannel.connect(remoteAddress)){
			System.out.println("连接成功！");
		}
		else{
			System.out.println("连接失败！");
		}//else
		
		//构造消息，发送消息
		String message = "current time " + System.currentTimeMillis();
		ByteBuffer buffer = ByteBuffer.allocate(BUFFER_SIZE);
		buffer.put(message.getBytes());
		
		buffer.flip();
		while(buffer.hasRemaining()){
			socketChannel.write(buffer);
		}//while
		
		System.out.println("发送完成!");
		
	}
	
	public static void main(String args[]) throws IOException{
		SocketChannelClient socketChannelClient = new SocketChannelClient();
		socketChannelClient.init();
		socketChannelClient.sendMessageToServer();
	}
}
