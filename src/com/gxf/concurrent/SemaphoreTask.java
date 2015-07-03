package com.gxf.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class SemaphoreTask {
	
	static class Task implements Runnable{
		private Semaphore semaphore;
		private String name;
		private CountDownLatch countDownLatch;						//����һֱ����ϲ���õ�
		private static Object lock = new Object();
		
		public Task(Semaphore semaphore,CountDownLatch countDownLacth){
			this.semaphore = semaphore;
			this.countDownLatch = countDownLacth;
		}

		@Override
		public void run() {
			//ʹ�ñ������ǵȴ����߳�һ��ִ��
			try {
				countDownLatch.await();
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			
			//��ȡһ����Դ,���Ｔһ������
			try {
//				synchronized(lock){
					semaphore.acquire();
					System.out.println("����һ����Դ");
//				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			//ģ��ִ������
			System.out.println(Thread.currentThread().getName() + "��ʼִ������");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "����ִ�����");
			//�ͷ���Դ
//			synchronized(lock){
				semaphore.release();
				System.out.println("�ͷ�һ����Դ");
//			}
			
		}//run
		
		public void setName(String name){
			this.name = name;
		}
		
	}//class Task
	
	public static void main(String args[]) throws InterruptedException{
		//����
		CountDownLatch countDownLatch = new CountDownLatch(1);
		//����ģ��4����Դ������
		Semaphore semaphore = new Semaphore(4);
		//����
		Task task = new Task(semaphore, countDownLatch);
	
		//20���̣߳���20����
		Thread threads[] = new Thread[20];
		for(int i = 0; i < 20; i++){
			threads[i] = new Thread(task);
			task.setName("Thread " + i + " ");
			threads[i].start();
		}
		
		//�ͷű���
		countDownLatch.countDown();
		
		//�ȴ����е��߳�ִ�����
		for(int i = 0; i < 20; i++){
			threads[i].join();
		}//for
		
		System.out.println("��������ִ�����!");
	}
}
