package com.gxf.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ʹ��TCP socket����һ���˿ں�9999���������������������
 * @author Administrator
 *
 */
public class ListenPort {
	public static void main(String args[]){
		//�����̼߳����˿ں�9999
		HandleRequest handleRequest = new HandleRequest();
		handleRequest.start();
	}
}

/**
 * ����ͻ��˷��͵���Ϣ
 * @author Administrator
 *
 */
class HandleRequest extends Thread{
	private ServerSocket serverSocket;
	
	public HandleRequest(){
		try {
			serverSocket  = new ServerSocket(9999);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void run(){
		while(true){
			try {
				System.out.println("start listen at port 9999");
				Socket client = serverSocket.accept();
				System.out.println(client.getInetAddress());
				
				//��ʼ�����ͻ��˵�http����
				InputStream is = client.getInputStream();
				BufferedReader in = new BufferedReader(new InputStreamReader(is));
				
				String inputContent = in.readLine();
				System.out.println("inputContent = " + inputContent);
				
				//��ͻ�������������Ϣ��html
				OutputStream os = client.getOutputStream();
				PrintStream out = new PrintStream(os);
				out.println("<html>");
				out.println("<meta content='text/html; charset=gb2312' http-equiv='Content-Type'/>");
				out.println("<head><title>Welcome To MyWebServer</title></head>");
				out.println("<h1>welcome to guanxianseng webserver</h1>");
				out.println("</html>");
				
				out.flush();
				out.close();
				
				client.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}