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
 * 使用ServerSocketChannel,SocketChannel代替ServerSocket
 * 监听端口9999
 * @author GXF
 *
 */
public class ServerChannelSelector {
	private static final int PORT_NUM = 9999;				//端口号
	private static Selector selector;
	private static ServerSocketChannel serverChannel;
	private static ServerSocket serverSocket;
	
	/**
	 * 开始监听
	 * @throws IOException 
	 */
	public void init() throws IOException{
		//实例化selector
		selector = Selector.open();
		//实例化ServerSocketChannel
		serverChannel = ServerSocketChannel.open();
		//设置为非阻塞
		serverChannel.configureBlocking(false);
		
		//获取与通道相关联的服务器套接字
		serverSocket = serverChannel.socket();
		
		//ip
		InetAddress inetAddress = InetAddress.getLocalHost();
		InetSocketAddress inetSocketAddress = new InetSocketAddress(inetAddress, PORT_NUM);
		
		//服务器套接字绑定IP和端口
		serverSocket.bind(inetSocketAddress);
		//注册OP_ACCEPT事件
		serverChannel.register(selector, SelectionKey.OP_ACCEPT);
		
	}
	
	static class ServerThread implements Runnable{

		@Override
		public void run() {
			while(true){
				try {
					//检测是否有通道已经准备好了，没有通道准备好，处于阻塞，如果至少有一个准备好，不阻塞
					selector.select();
					//获取已选择的键集
					Set<SelectionKey> keys = selector.selectedKeys();
					Iterator<SelectionKey> iterator = keys.iterator();
					SocketChannel socketChannel;
					
					while(iterator.hasNext()){
						SelectionKey key = iterator.next();
						//新的连接
						if(key.isAcceptable()){
							ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
							SocketChannel sc = ssc.accept();
							System.out.println("收到请求!");
							//读取从客户端发送的内容
							ByteBuffer buffer = ByteBuffer.allocate(512);
							//读取到buffer中
							sc.read(buffer);
							//显示到屏幕
							buffer.flip();
							System.out.println("客户端发送的内容是:" + new String(buffer.array()));
							
							
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
	 * 启动监听线程
	 * @throws IOException 
	 */
	public void start() throws IOException{
		//先进行初始化
		init();
		
		Thread serverThread = new Thread(new ServerThread());
		serverThread.start();
	}
	
	
	/**
	 * 测试程序
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String args[]) throws IOException{
		ServerChannelSelector serverChannelSelector = new ServerChannelSelector();
		serverChannelSelector.start();
	}
}
