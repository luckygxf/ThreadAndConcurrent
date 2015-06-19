package com.gxf.webServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * web������
 * ʹ��Excutor��� 
 * @author Administrator
 *
 */
public class ExcutorWebServer {
	//�����˿ں�
	private static final int PORTNUM_LISTENING = 9999;
	//�̳߳ش�С
	private static final int NUM_THREADS_POOL = 100;
	
	private static Executor executor = Executors.newFixedThreadPool(NUM_THREADS_POOL);
	
	public static void main(String args[]) throws IOException{
		ServerSocket serverSocket = new ServerSocket(PORTNUM_LISTENING);
		while(true){
			final Socket clientSocket = serverSocket.accept();
			
			Runnable task = new Runnable(){
				public void run(){
					//����ͻ�������
					try {
						handlRequest(clientSocket);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}				
				}
			};
			
			executor.execute(task);
		}
	}
	
	/**
	 * �������� 
	 * @param task
	 * @throws IOException 
	 */
	public static void handlRequest(Socket clientSocket) throws IOException{
		System.out.println(clientSocket.getRemoteSocketAddress());
		//�����ͻ���http����
		BufferedReader bfr = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		String requestLine = "";
		String resourceRequest = "";
		try {
			requestLine = bfr.readLine();
			int spaceStartIndex = requestLine.indexOf(" ");
			int spaceEndIndex = requestLine.indexOf("HTTP");
			resourceRequest = requestLine.substring(spaceStartIndex, spaceEndIndex);
		} catch (IOException e) {

			e.printStackTrace();
		}
		
		//����html������ͻ������������Ӧ�ͻ�������
		PrintStream ps = new PrintStream(clientSocket.getOutputStream());
		ps.println("<html>");
		ps.println("<meta content='text/html; charset=gb2312' http-equiv='Content-Type'/>");
		ps.println("<head><title>Welcome To MyWebServer</title></head>");
		ps.println("<h1>request resource is:" + resourceRequest + "</h1>");
		ps.println("</html>");
		
		ps.flush();
		ps.close();		
		
		try {
			clientSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
