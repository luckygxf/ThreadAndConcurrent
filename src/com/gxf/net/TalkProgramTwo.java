package com.gxf.net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * ʹ��UDP������9999�˿�
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
		//��ȡ�˿ں�
		port_num_send = Integer.parseInt(args[0]);
		port_num_receive = Integer.parseInt(args[1]);
		
		//���������߳�
		new ReceiveMessageThread(port_num_receive).start();
		
		//�������룬������Ϣ
		String message_send = "";
		Scanner sc = new Scanner(System.in);
		
		do{
			message_send = sc.nextLine();
//			System.out.println(message_send);
			
			//����socket
			try {
				DatagramSocket sendMessageSocket = new DatagramSocket();
				byte bytes[] = message_send.getBytes();
				InetAddress remoteAddress = InetAddress.getByName("127.0.0.1");
				//Ҫ���͵����ݰ�
				DatagramPacket sendDatagramPacket = new DatagramPacket(bytes, 0, bytes.length, remoteAddress, port_num_send);
				//�������ݰ�
				sendMessageSocket.send(sendDatagramPacket);
				sendMessageSocket.close();
			} catch (SocketException e) {
				e.printStackTrace();
			}
		}while(!"bye".equals(message_send));
		
		sc.close();
	}
	
	/**
	 * ��̨������Ϣ�߳�
	 * �����˿ں�9999
	 * @author Administrator
	 *
	 */
	static class ReceiveMessageThread extends Thread{
		//�˿ں�
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
					//������Ϣ,û����Ϣ����
					receiveSocket.receive(receivePacket);
					int length_receive = receivePacket.getLength();
					String string_receive = new String(messageBytes, 0, length_receive);
					//��ȡԶ��������ַ
					InetAddress remoteAddress = receivePacket.getAddress();
					//������յ���Ϣ������̨
					System.out.println("From " + remoteAddress + " message is: " + string_receive);
				}
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
