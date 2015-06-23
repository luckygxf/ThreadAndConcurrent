package com.gxf.concurrent;

import java.io.PrintWriter;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 日志服务
 * @author Administrator
 *
 */
public class LogWriter {
	private BlockingQueue<String> blockingQueue;
	private LoggerThread logger;
	
	public LogWriter(PrintWriter writer){
		logger = new LoggerThread(writer);
		this.blockingQueue = new LinkedBlockingQueue<String>(5);
		
	}
	
	public void log(String message) throws InterruptedException{
		blockingQueue.put(message);
	}
	
	public void start(){
		logger.start();
	}
	
	/**
	 * 中断请求
	 */
	public void interrupt(){
		logger.interrupt();
	}
	
	
	/**
	 * 消费者
	 * @author Administrator
	 *
	 */
	private class LoggerThread extends Thread{
		private PrintWriter writer;
		
		public LoggerThread(PrintWriter writer){
			this.writer = writer;
		}
		
		@Override
		public void run(){
			try {
				while(true){
					String message = blockingQueue.take();
					writer.flush();
					writer.println(message);
//					Thread.sleep(1000);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			finally{
				writer.close();
			}
		}
	}
	
	/**
	 * 测试程序
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String args[]) throws InterruptedException{
		PrintWriter printWriter = new PrintWriter(System.out);
		LogWriter logWriter = new LogWriter(printWriter);
			
		logWriter.start();
		
		for(int i = 0; i < 10; i++){
			String message = String.valueOf(i);
			System.out.println("message = " + message);
			logWriter.log(message);
		}
		
		
//		logWriter.interrupt();
		
	}
	
}
