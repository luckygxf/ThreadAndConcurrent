package com.gxf.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 测试concurrent包下面的Lock
 * 测试显示锁，或者可重入锁
 * @author GXF
 *
 */
public class TestConcurLock {
	static class Script implements Runnable{
		private ConterValue counter;
		private CountDownLatch countDownLatch;
		
		public Script(ConterValue counter, CountDownLatch countDownLatch){
			this.counter = counter;
			this.countDownLatch = countDownLatch;
		}
		
		@Override
		public void run() {
			try {
				countDownLatch.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			for(int i = 0; i < 10000; i++)
			{
				counter.increament();
			}
		}
		
	}//Script
	
	public static void main(String args[]) throws InterruptedException{
		ConterValue counter = new ConterValue();
		CountDownLatch countDownLatch = new CountDownLatch(1);
		
		Thread thread1 = new Thread(new Script(counter, countDownLatch));
		Thread thread2 = new Thread(new Script(counter, countDownLatch));
		
		thread1.start();
		thread2.start();
		
		countDownLatch.countDown();
		
		thread1.join();
		thread2.join();
		
		System.out.println("counter = " + counter.getCounter());
		
	}
}

class ConterValue{
	private int counter;
	private Lock lock = new ReentrantLock();
	
	public int getCounter(){
		return counter;
	}
	
	public void increament(){
		lock.lock();
		counter++;
		lock.unlock();
	}
}

