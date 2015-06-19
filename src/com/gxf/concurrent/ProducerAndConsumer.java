package com.gxf.concurrent;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import com.gxf.util.Util;

/**
 * 利用BlockingQueue实现生产者和消费者问题
 * @author Administrator
 *
 */
public class ProducerAndConsumer {
	
	//产品队列
	private static int queueLength = 5;
	private static BlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<Integer>(queueLength);
	
	
	/**
	 * 模拟生产者 
	 * @author Administrator
	 *
	 */
	static class ProducerScript implements Runnable{
		//生产者名字
		private String name;
		
		public ProducerScript(String name) {
			this.name = name;
		}
		
		@Override
		public void run() {
			//生产者开始生产
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
	 * 模拟消费者
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
			//消费者开始消费
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
	 * 测试程序
	 * @param args
	 */
	public static void main(String args[]){
		ProducerScript producer = new ProducerScript("生产");
		
		ConsumerScript consumer = new ConsumerScript("消费");
		
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

