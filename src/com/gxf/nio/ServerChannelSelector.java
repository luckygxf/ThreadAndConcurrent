package com.gxf.nio;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * ʹ��ServerSocketChannel,SocketChannel����ServerSocket
 * �����˿�9999
 * @author GXF
 *
 */
public class ServerChannelSelector {
	private static final int PORT_NUM = 9999;				//�˿ں�
	private static Selector selector;
	private static ServerSocketChannel serverChannel;
	private static ServerSocket serverSocket;
	
	/**
	 * ��ʼ����
	 * @throws IOException 
	 */
	public void init() throws IOException{
		//ʵ����selector
		selector = Selector.open();
		//ʵ����ServerSocketChannel
		serverChannel = ServerSocketChannel.open();
		//����Ϊ������
		serverChannel.configureBlocking(false);
		
		//��ȡ��ͨ��������ķ������׽���
		serverSocket = serverChannel.socket();
		
		//ip
		InetAddress inetAddress = InetAddress.getLocalHost();
		InetSocketAddress inetSocketAddress = new InetSocketAddress(inetAddress, PORT_NUM);
		
		//�������׽��ְ�IP�Ͷ˿�
		serverSocket.bind(inetSocketAddress);
		//ע��OP_ACCEPT�¼�
		serverChannel.register(selector, SelectionKey.OP_ACCEPT);
		
	}
	
	static class ServerThread implements Runnable{

		@Override
		public void run() {
			while(true){
				try {
					//����Ƿ���ͨ���Ѿ�׼�����ˣ�û��ͨ��׼���ã��������������������һ��׼���ã�������
					selector.select();
					//��ȡ��ѡ��ļ���
					Set<SelectionKey> keys = selector.selectedKeys();
					Iterator<SelectionKey> iterator = keys.iterator();
					SocketChannel socketChannel;
					
					while(iterator.hasNext()){
						SelectionKey key = iterator.next();
						//�µ�����
						if(key.isAcceptable()){
							ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
							SocketChannel sc = ssc.accept();
							System.out.println("�յ�����!");
							//��ȡ�ӿͻ��˷��͵�����
							ByteBuffer buffer = ByteBuffer.allocate(512);
							//��ȡ��buffer��
							sc.read(buffer);
							//��ʾ����Ļ
							buffer.flip();
							System.out.println("�ͻ��˷��͵�������:" + new String(buffer.array()));
							
							
						}//if
						
						iterator.remove();
					}
					
					
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		}
		
	}//class ServerThread
	
	/**
	 * ���������߳�
	 * @throws IOException 
	 */
	public void start() throws IOException{
		//�Ƚ��г�ʼ��
		init();
		
		Thread serverThread = new Thread(new ServerThread());
		serverThread.start();
	}
	
	
	/**
	 * ���Գ���
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String args[]) throws IOException{
		ServerChannelSelector serverChannelSelector = new ServerChannelSelector();
		serverChannelSelector.start();
	}
}
