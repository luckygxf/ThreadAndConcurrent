package com.gxf.net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * 使用UDP，监听9999端口
 * @author Administrator
 *
 */
public class TalkProgramTwo {
	private static int port_num_send;
	private static int port_num_receive;
	private final static int BUFFERSIZE = 1024;
	
	public static void main(String args[]) throws IOException{
		if(args.length < 2)
		{
			System.out.println("usage is java TalkProgram port_num_send port_num_receive");
			return ;
		}
		//获取端口号
		port_num_send = Integer.parseInt(args[0]);
		port_num_receive = Integer.parseInt(args[1]);
		
		//启动接收线程
		new ReceiveMessageThread(port_num_receive).start();
		
		//接收输入，发送消息
		String message_send = "";
		Scanner sc = new Scanner(System.in);
		
		do{
			message_send = sc.nextLine();
//			System.out.println(message_send);
			
			//声明socket
			try {
				DatagramSocket sendMessageSocket = new DatagramSocket();
				byte bytes[] = message_send.getBytes();
				InetAddress remoteAddress = InetAddress.getByName("127.0.0.1");
				//要发送的数据包
				DatagramPacket sendDatagramPacket = new DatagramPacket(bytes, 0, bytes.length, remoteAddress, port_num_send);
				//发送数据包
				sendMessageSocket.send(sendDatagramPacket);
				sendMessageSocket.close();
			} catch (SocketException e) {
				e.printStackTrace();
			}
		}while(!"bye".equals(message_send));
		
		sc.close();
	}
	
	/**
	 * 后台接收消息线程
	 * 监听端口号9999
	 * @author Administrator
	 *
	 */
	static class ReceiveMessageThread extends Thread{
		//端口号
		private  int portNumListening;
		private final int BUFFERSIZE = 1024;
		
		public ReceiveMessageThread(int portNumListening){
			this.portNumListening = portNumListening;
		}
		
		public void run(){
			try {
				DatagramSocket receiveSocket = new DatagramSocket(portNumListening);
				byte messageBytes[] = new byte[BUFFERSIZE];
				
				DatagramPacket receivePacket = new DatagramPacket(messageBytes, BUFFERSIZE);
				
				while(true){
					//接收消息,没有消息阻塞
					receiveSocket.receive(receivePacket);
					int length_receive = receivePacket.getLength();
					String string_receive = new String(messageBytes, 0, length_receive);
					//获取远程主机地址
					InetAddress remoteAddress = receivePacket.getAddress();
					//输出接收到消息到控制台
					System.out.println("From " + remoteAddress + " message is: " + string_receive);
				}
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
