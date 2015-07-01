package com.gxf.designpattern;

import java.util.concurrent.CountDownLatch;

public class TestSinglePattern {
	
	public static void main(String args[]){
		Script task = new Script();
		executeTask(100, task);
	}
	
	/**
	 * Ҫִ�еĽű�
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
		//ʵ����һ������
		final CountDownLatch startGate = new CountDownLatch(1);
		//���������߳�
		for(int i = 0; i < threadNum; i++){
			Thread thread = new Thread(){
				public void run(){
					try {
						//�����ȴ��߳�һ��ִ��,�����Ĺ���
						startGate.await();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					task.run();
				}
			};
			thread.start();
		}//for
		
		//�ͷ����еȴ��߳�,���߳��ͷ�
		startGate.countDown();
	}
}

