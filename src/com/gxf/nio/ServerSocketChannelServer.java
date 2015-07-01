package com.gxf.nio;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * 测试ServerSocketChannel,监听9999端口号
 * @author GXF
 *
 */
public class ServerSocketChannelServer {
	private final int PORT_NUM = 9999;
	private static final int BUFFER_SIZE = 512;
	
	private static ServerSocketChannel serverSocketChannel;
	
	/**
	 * 初始化
	 * @throws IOException 
	 */
	public void init() throws IOException{		
		//创建serverSocket通道
		serverSocketChannel = ServerSocketChannel.open();
		//设置为非阻塞
		serverSocketChannel.configureBlocking(false);
		//ip和绑定ip到套接字
		InetAddress localAddress = InetAddress.getLocalHost();
		serverSocketChannel.socket().bind(new InetSocketAddress(localAddress, PORT_NUM));
		
	}
	
	static class ServerThread implements Runnable{

		@Override
		public void run() {
			System.out.println("服务器启动");
			while(true){
				SocketChannel socketChannel = null;
				try {
					socketChannel = serverSocketChannel.accept();
				} catch (IOException e) {
					e.printStackTrace();
				}
				if(socketChannel != null){			//读取客户端发送的消息
					ByteBuffer buffer = ByteBuffer.allocate(BUFFER_SIZE);
					try {
						socketChannel.read(buffer);
						//输出客户端发送的信息
						System.out.println("客户端发送的信息为:" + new String(buffer.array()));
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
			
		}
		
	}//class thread
	
	public void start() throws IOException{
		//初始化
		init();
		
		//启动监听线程
		Thread listenThread = new Thread(new ServerThread());
		listenThread.start();
	}
	
	public static void main(String args[]) throws IOException{
		ServerSocketChannelServer serverSocketChannel = new ServerSocketChannelServer();
		serverSocketChannel.start();
	}
}
