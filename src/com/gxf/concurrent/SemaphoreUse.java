package com.gxf.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * ǰ��ʹ�õ����߳��飬����ʹ���̳߳ز���
 * @author GXF
 *
 */
public class SemaphoreUse {
	public static void main(String args[]){
		ExecutorService pool = Executors.newCachedThreadPool();
		//����ʹ���ź�����ģ��
		final Semaphore semaphore = new Semaphore(4);
		
		class Task implements Runnable{

			@Override
			public void run() {
				try {
					// ������Դ
					semaphore.acquire();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				try {
					System.out.println(Thread.currentThread().getName() + "��ʼִ������");
					Thread.sleep(1000);
					System.out.println(Thread.currentThread().getName() + "��������");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				//�ͷ���Դ
				semaphore.release();
			}//run
		}//Task
		
		for(int i = 0; i < 20; i++){
			pool.execute(new Task());
		}
		
		//�ر��̳߳�
		pool.shutdown();
	}
}
