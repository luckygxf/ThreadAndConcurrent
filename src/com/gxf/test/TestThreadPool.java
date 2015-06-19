package com.gxf.test;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestThreadPool {
	//自定义线程
	static class MyThread extends Thread{
		@Override
		public void run(){
			System.out.println(Thread.currentThread().getName() + "is running");
			System.out.println("Thread.activeCount()" + Thread.activeCount());
			System.out.println("Thread.currentThread() hashcode" + Thread.currentThread().hashCode());
		}
	}
	
	public static void main(String args[]){
		ExecutorService threadPool = Executors.newFixedThreadPool(5);
		
		MyThread a = new MyThread();
		MyThread b = new MyThread();
		MyThread c = new MyThread();
		MyThread d = new MyThread();
		MyThread e = new MyThread();
		MyThread f = new MyThread();
		MyThread g = new MyThread();
		MyThread h = new MyThread();
		MyThread i = new MyThread();
		
		threadPool.execute(a);
		threadPool.execute(b);
		threadPool.execute(c);
		threadPool.execute(d);
		threadPool.execute(e);
		threadPool.execute(f);
		threadPool.execute(h);
		threadPool.execute(i);
		threadPool.execute(g);
		
		threadPool.shutdown();
	}
}
