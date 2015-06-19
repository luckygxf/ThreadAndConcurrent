package com.gxf.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 模拟Clinet端
 * @author Administrator
 *
 */
public class Client {
	public String url = "http://localhost:9999/";
	private final int NUM_THREADS = 100;
	
	public static void main(String args[]){
		Client client = new Client();
		client.getConnection(client.url);
	}
	
	public void getConnection(String urlStr){
		////发送  
	    HttpURLConnection conn = null;  
	    try {  
	        URL url = new URL(urlStr);  
	        conn = (HttpURLConnection) url.openConnection();  
	        conn.setRequestMethod("POST");  
	        conn.setRequestProperty("Content-Type",  
	                "application/x-www-form-urlencoded");  
	        conn.setUseCaches(false);  
	        conn.setDoOutput(true);  
	        OutputStreamWriter osw = new OutputStreamWriter(  
	                conn.getOutputStream());  
	        StringBuffer sb = new StringBuffer();  
	        addPair(sb, "p1", "p1value");  
	        addPair(sb, "p2", "p2value");  
	        osw.write(sb.substring(0, sb.length() - 1));  
	        osw.flush();  
	        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));  
	        String line = null;  
	        sb = new StringBuffer();  
	        while ((line = reader.readLine()) != null) {  
	            sb.append(line);  
	        }  
	        line = sb.toString();  
	        // 处理返回的字符串line  
	        return;  
	        ////  
	    } catch (IOException e) {  
	        // handle e  
	    	e.printStackTrace();
	    } finally {  
	        if (conn != null)  
	            conn.disconnect();  
	    }///发送结束  
	
	}
	public  void addPair(StringBuffer sb, String name, String value) {  
	    if (value == null) {  
	        return;  
	    }  
	    sb.append(name);  
	    sb.append("=");  
	    sb.append(value);  
	    sb.append("&");  
	}  

}
