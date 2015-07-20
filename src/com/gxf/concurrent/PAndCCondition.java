package com.gxf.concurrent;

import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ��Lock+condtionʵ�������ߺ�����������
 * @author GXF
 *
 */
public class PAndCCondition {
	private final Lock lock = new ReentrantLock();
	private Condition notFull = lock.newCondition();
	private Condition notEmpty = lock.newCondition();
	
	private int items[] = new int[5];
	private int putptr;
	private int takeptr;
	private int count;
	
	class ProductScript implements Runnable{

		@Override
		public void run() {
			while(true){
				System.out.println("����������");
				lock.lock();
				while(count == items.length)
				{
					try {
						notFull.await();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}//while
				Random random = new Random();
				items[putptr] = random.nextInt();
				System.out.println("����������" + items[putptr]);
				if(++putptr == items.length) 
					putptr = 0;
				++count;
				notEmpty.signal();
				System.out.println("count = " + count);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {

					e.printStackTrace();
				}finally{				
					lock.unlock();
					System.out.println("�������ͷ���");
				}
			}
		
		}	
		
	}
	
	
	class ConsumerScript implements Runnable{

		@Override
		public void run() {
			while(true){
				System.out.println("����������");
				lock.lock();
				System.out.println("count = " + count);
				while(count == 0){
					try {
						notEmpty.await();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}				
				}//while
				int x = items[takeptr];
				System.out.println("����������" + x);
				if(++takeptr == items.length)
					takeptr = 0;
				--count;
				notFull.signal();
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {

					e.printStackTrace();
				}finally{
					
					lock.unlock();
					System.out.println("�������ͷ���");
				}
			}
			
			
		}
		
	}
	
	public static void main(String args[]) throws InterruptedException{
		PAndCCondition pAndCCondition = new PAndCCondition();
		ProductScript productScript = pAndCCondition.new ProductScript();
		ConsumerScript consumerScript = pAndCCondition.new ConsumerScript();
		
		Thread pThread = new Thread(productScript);
		Thread cThread = new Thread(consumerScript);
		
		pThread.start();
		Thread.sleep(2000);
		cThread.start();
	}
	
	
}
