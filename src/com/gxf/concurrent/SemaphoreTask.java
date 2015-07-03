package com.gxf.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class SemaphoreTask {
	
	static class Task implements Runnable{
		private Semaphore semaphore;
		private String name;
		private CountDownLatch countDownLatch;						//闭锁一直是我喜欢用的
		private static Object lock = new Object();
		
		public Task(Semaphore semaphore,CountDownLatch countDownLacth){
			this.semaphore = semaphore;
			this.countDownLatch = countDownLacth;
		}

		@Override
		public void run() {
			//使用闭锁，是等待的线程一起执行
			try {
				countDownLatch.await();
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			
			//获取一个资源,这里即一个窗口
			try {
//				synchronized(lock){
					semaphore.acquire();
					System.out.println("申请一个资源");
//				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			//模拟执行任务
			System.out.println(Thread.currentThread().getName() + "开始执行任务");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "任务执行完成");
			//释放资源
//			synchronized(lock){
				semaphore.release();
				System.out.println("释放一个资源");
//			}
			
		}//run
		
		public void setName(String name){
			this.name = name;
		}
		
	}//class Task
	
	public static void main(String args[]) throws InterruptedException{
		//闭锁
		CountDownLatch countDownLatch = new CountDownLatch(1);
		//这里模拟4个资源及窗口
		Semaphore semaphore = new Semaphore(4);
		//任务
		Task task = new Task(semaphore, countDownLatch);
	
		//20个线程，即20个人
		Thread threads[] = new Thread[20];
		for(int i = 0; i < 20; i++){
			threads[i] = new Thread(task);
			task.setName("Thread " + i + " ");
			threads[i].start();
		}
		
		//释放闭锁
		countDownLatch.countDown();
		
		//等待所有的线程执行完成
		for(int i = 0; i < 20; i++){
			threads[i].join();
		}//for
		
		System.out.println("所有任务执行完成!");
	}
}
