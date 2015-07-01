package com.gxf.nio;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class ClientChannelSelector {
	private static final int SERVER_PORT_NUM = 9999;
	private static Selector selector;
	private static SocketChannel channel;
	
	
	/**
	 * 初始化
	 * @throws IOException
	 */
	public void init() throws IOException{
		selector = Selector.open();
		InetAddress serverAddress = InetAddress.getLocalHost();
		channel = SocketChannel.open(new InetSocketAddress(serverAddress, SERVER_PORT_NUM));
		channel.configureBlocking(false);
		channel.register(selector, SelectionKey.OP_CONNECT);
	}
	
	static class ClientThread implements Runnable{
		public void run(){
			while(true){
				try {
					selector.select();
					Set<SelectionKey> keys = selector.selectedKeys();
					Iterator<SelectionKey> iterator = keys.iterator();
					while(iterator.hasNext()){
						SelectionKey key = iterator.next();
						//连接成功
//						if(key.isConnectable()){
//							System.out.println("连接成功!");
//						}
						channel.connect(new InetSocketAddress(InetAddress.getLocalHost(), SERVER_PORT_NUM));
						//发送数据给服务器
						String newDate = "new string send to server " + System.currentTimeMillis();
						ByteBuffer buffer = ByteBuffer.allocate(512);
						buffer.put(newDate.getBytes());
						
//						buffer.flip();
						
						channel.write(buffer);
						
						
						//移除
						iterator.remove();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}//class ClientThread
	
	/**
	 * 启动客户端程序
	 * @throws IOException 
	 */
	public void start() throws IOException{
		//先初始化
		init();
		//启动线程
		Thread clientThread = new Thread(new ClientThread());
		clientThread.start();
	}
	
	/**
	 * 测试程序
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String args[]) throws IOException{
		ClientChannelSelector clientChannelSelector = new ClientChannelSelector();
		clientChannelSelector.start();
	}
}
