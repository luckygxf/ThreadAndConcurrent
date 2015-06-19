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
 * web服务器
 * 使用Excutor框架 
 * @author Administrator
 *
 */
public class ExcutorWebServer {
	//监听端口号
	private static final int PORTNUM_LISTENING = 9999;
	//线程池大小
	private static final int NUM_THREADS_POOL = 100;
	
	private static Executor executor = Executors.newFixedThreadPool(NUM_THREADS_POOL);
	
	public static void main(String args[]) throws IOException{
		ServerSocket serverSocket = new ServerSocket(PORTNUM_LISTENING);
		while(true){
			final Socket clientSocket = serverSocket.accept();
			
			Runnable task = new Runnable(){
				public void run(){
					//处理客户端请求
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
	 * 处理请求 
	 * @param task
	 * @throws IOException 
	 */
	public static void handlRequest(Socket clientSocket) throws IOException{
		System.out.println(clientSocket.getRemoteSocketAddress());
		//解析客户端http请求
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
		
		//生成html输出到客户端浏览器，响应客户端请求
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
