package com.gxf.designpattern;

import java.util.concurrent.CountDownLatch;

public class TestSinglePattern {
	
	public static void main(String args[]){
		Script task = new Script();
		executeTask(100, task);
	}
	
	/**
	 * 要执行的脚本
	 * @author GXF
	 *
	 */
	static class Script implements Runnable{

		@Override
		public void run() {
			System.out.println(SingleObject.getSingletonObject());
			
		}
		
	}
	
	public static void executeTask(int threadNum, final Runnable task){
		//实例化一个闭锁
		final CountDownLatch startGate = new CountDownLatch(1);
		//创建几个线程
		for(int i = 0; i < threadNum; i++){
			Thread thread = new Thread(){
				public void run(){
					try {
						//阻塞等待线程一起执行,闭锁的功能
						startGate.await();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					task.run();
				}
			};
			thread.start();
		}//for
		
		//释放所有等待线程,主线程释放
		startGate.countDown();
	}
}

