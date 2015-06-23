package com.gxf.concurrent;

/**
 * 中断线程
 * @author Administrator
 *
 */
public class InterruptThread {
	/**
	 * sleep(5000),在这期间接受中断
	 * @author Administrator
	 *
	 */
	static class ThreadScript implements Runnable{

		@Override
		public void run() {
			try {
			
				Thread.sleep(5000);
				System.out.println("Afer sleep");
			} catch (InterruptedException e) {
				//线程已经中断，抛出异常
				System.out.println(Thread.currentThread().isInterrupted());
				Thread.currentThread().interrupt();
				System.out.println(Thread.currentThread().interrupted());
				e.printStackTrace();
			}
			
		}//run
		
	}
	
	/**
	 * 中断别的线程
	 * @author Administrator
	 *
	 */
	static class InterruptScript implements Runnable{
		private Thread threadToInterrupt;
		
		public InterruptScript(Thread threadToInterrupt) {
			this.threadToInterrupt = threadToInterrupt;
		}
		
		/* sleep(3000)中断别的线程
		 */
		@Override
		public void run() {
			try {
				Thread.sleep(3000);
				threadToInterrupt.interrupt();
				System.out.println("After interrupt");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}//while
		
	}
	
	public static void main(String args[]){
		Thread thread1 = new Thread(new ThreadScript());
		Thread thread2 = new Thread(new InterruptScript(thread1));
		
		thread1.start();
		thread2.start();
	}
}
