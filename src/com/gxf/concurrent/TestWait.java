package com.gxf.concurrent;

public class TestWait {
	
	static class WaitScript implements Runnable{
		private Car object;
		
		public WaitScript(Car testWait){
			object = testWait;
		}
		
		@Override
		public void run() {
			System.out.println("开始wait等待notify操作");
			
			try {
				synchronized(object){
					
					object.wait();
				}
				System.out.println("获取notify结束wait操作");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}//waitScript
	
	static class NotifyScript implements Runnable{
		private Car object;
		
		public NotifyScript(Car testWait){
			object = testWait;
		}
		@Override
		public void run() {
			System.out.println("开始执行notify操作");
			synchronized(object){
				object.notify();
			}
			
		}
		
	}//NotifyScript
	
	public static void main(String args[]) throws InterruptedException{
		Car testWait = new Car();
		Thread waitThread = new Thread(new WaitScript(testWait));
		Thread notifyThread = new Thread(new NotifyScript(testWait));
		
		waitThread.start();
		Thread.sleep(5000);
		notifyThread.start();
	}
}

class Car{
	
}
