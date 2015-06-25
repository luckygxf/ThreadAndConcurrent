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
						startGate.await(); //ʹ��ǰ�߳�������������������֮ǰһֱ�ȴ��������̱߳��жϡ�
						task.run();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					finally{
						endGate.countDown(); //�ݼ��������ļ�����������������㣬���ͷ����еȴ����̡߳�
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
