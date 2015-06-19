package com.gxf.concurrent;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import com.gxf.util.Util;

/**
 * ����BlockingQueueʵ�������ߺ�����������
 * @author Administrator
 *
 */
public class ProducerAndConsumer {
	
	//��Ʒ����
	private static int queueLength = 5;
	private static BlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<Integer>(queueLength);
	
	
	/**
	 * ģ�������� 
	 * @author Administrator
	 *
	 */
	static class ProducerScript implements Runnable{
		//����������
		private String name;
		
		public ProducerScript(String name) {
			this.name = name;
		}
		
		@Override
		public void run() {
			//�����߿�ʼ����
			while(true){
				int product = Util.generateRandomInt();
				try {
					blockingQueue.put(product);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
//				System.out.println(name + ":" + product);
				System.out.println(blockingQueue);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		}
		
	}
	
	/**
	 * ģ��������
	 * @author Administrator
	 *
	 */
	static class ConsumerScript implements Runnable{
		private String name;
		
		public ConsumerScript(String name) {
			this.name = name;
		}

		@Override
		public void run() {
			//�����߿�ʼ����
			while(true){
				int product = -1;
				try {
					product = blockingQueue.take();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(name + ":" + product);
				System.out.println(blockingQueue);
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		}
		
	}
	
	/**
	 * ���Գ���
	 * @param args
	 */
	public static void main(String args[]){
		ProducerScript producer = new ProducerScript("����");
		
		ConsumerScript consumer = new ConsumerScript("����");
		
		Thread producerThread =  new Thread(producer);
//		Thread producerThread1 =  new Thread(producer);
		Thread consumerThread = new Thread(consumer);
//		Thread consumerThread1 = new Thread(consumer);
		
		producerThread.start();
		consumerThread.start();
//		consumerThread1.start();
//		producerThread1.start();
	}
}

