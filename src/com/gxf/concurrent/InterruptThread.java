package com.gxf.concurrent;

/**
 * �ж��߳�
 * @author Administrator
 *
 */
public class InterruptThread {
	/**
	 * sleep(5000),�����ڼ�����ж�
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
				//�߳��Ѿ��жϣ��׳��쳣
				System.out.println(Thread.currentThread().isInterrupted());
				Thread.currentThread().interrupt();
				System.out.println(Thread.currentThread().interrupted());
				e.printStackTrace();
			}
			
		}//run
		
	}
	
	/**
	 * �жϱ���߳�
	 * @author Administrator
	 *
	 */
	static class InterruptScript implements Runnable{
		private Thread threadToInterrupt;
		
		public InterruptScript(Thread threadToInterrupt) {
			this.threadToInterrupt = threadToInterrupt;
		}
		
		/* sleep(3000)�жϱ���߳�
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
