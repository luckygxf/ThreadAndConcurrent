package com.gxf.nio;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * ����SocketChannel
 * @author GXF
 *
 */
public class SocketChannelClient {
	//�����������˿ں�
	private static final int SERVER_PORT_NUM = 9999;
	private static SocketChannel socketChannel;
	private static final int BUFFER_SIZE = 512;
	
	public void init() throws IOException{
		//��ʼ���׽���ͨ��
		socketChannel = SocketChannel.open();		
	}
	
	public void sendMessageToServer() throws IOException{
		//�����ӷ�����
		SocketAddress remoteAddress = new InetSocketAddress(InetAddress.getLocalHost(), SERVER_PORT_NUM);
		if(socketChannel.connect(remoteAddress)){
			System.out.println("���ӳɹ���");
		}
		else{
			System.out.println("����ʧ�ܣ�");
		}//else
		
		//������Ϣ��������Ϣ
		String message = "current time " + System.currentTimeMillis();
		ByteBuffer buffer = ByteBuffer.allocate(BUFFER_SIZE);
		buffer.put(message.getBytes());
		
		buffer.flip();
		while(buffer.hasRemaining()){
			socketChannel.write(buffer);
		}//while
		
		System.out.println("�������!");
		
	}
	
	public static void main(String args[]) throws IOException{
		SocketChannelClient socketChannelClient = new SocketChannelClient();
		socketChannelClient.init();
		socketChannelClient.sendMessageToServer();
	}
}
