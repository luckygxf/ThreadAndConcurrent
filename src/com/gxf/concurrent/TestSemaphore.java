package com.gxf.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class TestSemaphore {
	static class Counter{
		private int counter;
		public int get(){
			return counter;
		}
		public void increament(){
			counter++;
		}
	}
	
	static class Script implements Runnable{
		private Counter counter;
		private Semaphore semaphore;
		private CountDownLatch countDownLatch;
		
		public Script(Counter counter,Semaphore semaphore, CountDownLatch countDownLatch){
			this.counter = counter;
			this.semaphore = semaphore;
			this.countDownLatch = countDownLatch;
		}
		
		@Override
		public void run() {
			try {
				countDownLatch.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			try {
				semaphore.acquire();
			} catch (InterruptedException e) {
			
				e.printStackTrace();
			}
			for(int i = 0; i < 10000; i++){
				counter.increament();
			}
			semaphore.release();
			
		}//run
		
	}//Script
	
	public static void main(String args[]) throws InterruptedException{
		Counter counter = new Counter();
		CountDownLatch countDownLatch = new CountDownLatch(1);
		Semaphore semaphore = new Semaphore(1);
		
		Script script = new Script(counter, semaphore, countDownLatch);
		Thread thread1 = new Thread(script);
		Thread thread2 = new Thread(script);
		
		thread1.start();
		thread2.start();
		
		countDownLatch.countDown();
		
		thread1.join();
		thread2.join();
		
		System.out.println("counter = " + counter.get());
	}
}
