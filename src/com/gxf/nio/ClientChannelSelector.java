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
	 * ��ʼ��
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
						//���ӳɹ�
//						if(key.isConnectable()){
//							System.out.println("���ӳɹ�!");
//						}
						channel.connect(new InetSocketAddress(InetAddress.getLocalHost(), SERVER_PORT_NUM));
						//�������ݸ�������
						String newDate = "new string send to server " + System.currentTimeMillis();
						ByteBuffer buffer = ByteBuffer.allocate(512);
						buffer.put(newDate.getBytes());
						
//						buffer.flip();
						
						channel.write(buffer);
						
						
						//�Ƴ�
						iterator.remove();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}//class ClientThread
	
	/**
	 * �����ͻ��˳���
	 * @throws IOException 
	 */
	public void start() throws IOException{
		//�ȳ�ʼ��
		init();
		//�����߳�
		Thread clientThread = new Thread(new ClientThread());
		clientThread.start();
	}
	
	/**
	 * ���Գ���
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String args[]) throws IOException{
		ClientChannelSelector clientChannelSelector = new ClientChannelSelector();
		clientChannelSelector.start();
	}
}
