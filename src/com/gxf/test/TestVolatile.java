package com.gxf.test;

public class TestVolatile {
	public volatile static int num = 0;
	public static final int NUM_THREADS = 2000;
	
	public  static void increase(){
		synchronized (TestVolatile.class) {
			num++;
			System.out.println("num = " + num);
		}
	}
	
	public static void main(String args[]) throws InterruptedException{
		Thread threads[] = new Thread[NUM_THREADS];
		for(int i = 0; i < threads.length; i++){
			threads[i] = new Thread(new Runnable() {
				
				@Override
				public void run() {
					increase();
					
				}
			});
			threads[i].start();
		}
//		if(Thread.activeCount() > 0 )
//			Thread.yield();						//暂停正在执行的线程对象，并执行其他线程
		Thread.sleep(2000);
		
		System.out.println("Last num = " + num);
		
	}
	
	static class RunnableTarget implements Runnable{

		@Override
		public void run() {
			TestVolatile.increase();
			
		}
		
	}
}
