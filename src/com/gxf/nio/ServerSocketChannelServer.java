package com.gxf.nio;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * ����ServerSocketChannel,����9999�˿ں�
 * @author GXF
 *
 */
public class ServerSocketChannelServer {
	private final int PORT_NUM = 9999;
	private static final int BUFFER_SIZE = 512;
	
	private static ServerSocketChannel serverSocketChannel;
	
	/**
	 * ��ʼ��
	 * @throws IOException 
	 */
	public void init() throws IOException{		
		//����serverSocketͨ��
		serverSocketChannel = ServerSocketChannel.open();
		//����Ϊ������
		serverSocketChannel.configureBlocking(false);
		//ip�Ͱ�ip���׽���
		InetAddress localAddress = InetAddress.getLocalHost();
		serverSocketChannel.socket().bind(new InetSocketAddress(localAddress, PORT_NUM));
		
	}
	
	static class ServerThread implements Runnable{

		@Override
		public void run() {
			System.out.println("����������");
			while(true){
				SocketChannel socketChannel = null;
				try {
					socketChannel = serverSocketChannel.accept();
				} catch (IOException e) {
					e.printStackTrace();
				}
				if(socketChannel != null){			//��ȡ�ͻ��˷��͵���Ϣ
					ByteBuffer buffer = ByteBuffer.allocate(BUFFER_SIZE);
					try {
						socketChannel.read(buffer);
						//����ͻ��˷��͵���Ϣ
						System.out.println("�ͻ��˷��͵���ϢΪ:" + new String(buffer.array()));
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
			
		}
		
	}//class thread
	
	public void start() throws IOException{
		//��ʼ��
		init();
		
		//���������߳�
		Thread listenThread = new Thread(new ServerThread());
		listenThread.start();
	}
	
	public static void main(String args[]) throws IOException{
		ServerSocketChannelServer serverSocketChannel = new ServerSocketChannelServer();
		serverSocketChannel.start();
	}
}
