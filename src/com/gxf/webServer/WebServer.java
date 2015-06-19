package com.gxf.webServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * web服务器
 * 监听9999端口号
 * @author Administrator
 *
 */
public class WebServer {
	//服务器监听端口号
	private final int PORT_LISTENING = 9999;
	
	public static void main(String args[]){
		WebServer webServer = new WebServer();
		
		//启动服务器
		webServer.startService();
	}
	
	
	//启动web服务器
	public void startService(){
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(PORT_LISTENING);
		} catch (IOException e) {
			e.printStackTrace();
		}
		while(serverSocket != null){
			try {
				Socket clientSocket = serverSocket.accept();
				//new 一个线程处理客户端请求
				new HandleRequest(clientSocket).start();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}

/**
 * 解析客户端的http请求
 * 生成html响应客户端请求
 * @author Administrator
 *
 */
class HandleRequest extends Thread{
	//客户端socket
	private Socket clientSocket;
	private OutputStream os;
	private InputStream is;
	
	public HandleRequest(Socket clientSocket){
		this.clientSocket = clientSocket;
		try {
			os = this.clientSocket.getOutputStream();
			is = this.clientSocket.getInputStream();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void run(){
		//解析客户端http请求
		BufferedReader bfr = new BufferedReader(new InputStreamReader(is));
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
		PrintStream ps = new PrintStream(os);
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
	
	public void handleRequest(){
		
	}
}
