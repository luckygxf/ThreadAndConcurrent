package com.gxf.concurrent;

import java.util.concurrent.CountDownLatch;

public class TestHarness {
	public long timeTasks(int nThread, final Runnable task) throws InterruptedException{
		final CountDownLatch startGate = new CountDownLatch(1);
		final CountDownLatch endGate = new CountDownLatch(nThread);
		
		for(int  i = 0; i < nThread; i++){
			Thread thread = new Thread(){
				public void run(){
					try {
						startGate.await(); //使当前线程在锁存器倒计数至零之前一直等待，除非线程被中断。
						task.run();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					finally{
						endGate.countDown(); //递减锁存器的计数，如果计数到达零，则释放所有等待的线程。
					}
					
				}
			};
			
			thread.start();
		}//for
		
		long start = System.nanoTime();
		startGate.countDown();
		endGate.await();
		long end = System.nanoTime();
		
		return end - start;
	}
	
	static class Task implements Runnable {
		public void run(){
			System.out.println("Execute task!");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String args[]) throws InterruptedException{
		Task task = new Task();
		TestHarness testHarness = new TestHarness();
		long time = testHarness.timeTasks(5, task);
		System.out.println("time = " + time);
	}
}
