package com.gxf.concurrent;

public class DeadLock {
	public static void main(String args[]) throws InterruptedException{
		final Object o1 = new Object();
		final Object o2 = new Object();
		
		Thread thread1 = new Thread(new Runnable(){

			@Override
			public void run() {
				synchronized(o1){
					System.out.println(Thread.currentThread().getName() + "获取o1对象");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
					synchronized(o2){
						
					}
				}
				
			}
			
		});//thread1
		
		Thread thread2 = new Thread(new Runnable(){

			@Override
			public void run() {
				synchronized(o2){
					System.out.println(Thread.currentThread().getName() + "获取o2对象");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
					synchronized(o1){
						
					}
				}
				
			}
			
		});//thread2
		
		thread1.start();
		thread2.start();
		
		Thread.sleep(2000);
		
		thread1.interrupt();
		thread2.interrupt();
		
		thread1.join();
		thread2.join();
	}
}
