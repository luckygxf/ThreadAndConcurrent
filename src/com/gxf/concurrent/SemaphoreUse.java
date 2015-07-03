package com.gxf.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * 前面使用的是线程组，这里使用线程池测试
 * @author GXF
 *
 */
public class SemaphoreUse {
	public static void main(String args[]){
		ExecutorService pool = Executors.newCachedThreadPool();
		//这里使用信号量，模拟
		final Semaphore semaphore = new Semaphore(4);
		
		class Task implements Runnable{

			@Override
			public void run() {
				try {
					// 申请资源
					semaphore.acquire();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				try {
					System.out.println(Thread.currentThread().getName() + "开始执行任务");
					Thread.sleep(1000);
					System.out.println(Thread.currentThread().getName() + "结束任务");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				//释放资源
				semaphore.release();
			}//run
		}//Task
		
		for(int i = 0; i < 20; i++){
			pool.execute(new Task());
		}
		
		//关闭线程池
		pool.shutdown();
	}
}
