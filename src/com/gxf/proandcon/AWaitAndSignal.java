package com.gxf.proandcon;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import com.gxf.util.Util;

public class AWaitAndSignal {

	public static void main(String args[]){
		Storage2 storage = new Storage2();
		ProductScript2 ps = new ProductScript2(storage);
		ConsumerScript2 cs = new ConsumerScript2(storage);
		
		for(int i = 0; i < 1; i++){
			Thread thread = new Thread(ps);
			thread.start();
		}
		
		for(int i = 0; i < 1; i++){
			Thread thread = new Thread(cs);
			thread.start();
		}
	}

}
/**
 * ��װ�ֿ�
 * @author GXF
 *
 */
class Storage2{
	final int MAXSIZE = 20;
	
	private List<Object> list = new ArrayList<Object>();
	private Lock lock = new ReentrantLock();
	private Condition empty = lock.newCondition();
	private Condition full = lock.newCondition();	
	
	
	/**
	 * ����������
	 * @param obj
	 */
	public void put(Object obj){
		lock.lock();
		while(list.size() >= MAXSIZE){					//�������������
			try {
				full.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}//while
		
		System.out.println("����������һ����Ʒ");
		list.add(obj);
		Util.showListContent(list);
		//�ͷ���
		//�������������ߺ������� 
		full.signalAll();
		empty.signalAll();
		lock.unlock();
	}
	
	/**
	 * ����������
	 */
	public void take(){
		lock.lock();
		while(list.size() <= 0){						//û�п������ѵĲ�Ʒ
			try {
				empty.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}//while
		System.out.println("����������һ����Ʒ");
		list.remove(list.size() - 1);
		Util.showListContent(list);
		empty.signalAll();
		full.signalAll();
		lock.unlock();
	}
}

/**
 * �������߳�
 * @author GXF
 *
 */
class ProductScript2 implements Runnable{
	private Storage2 storage;
	
	public ProductScript2(Storage2 storage) {
		this.storage = storage;
	}
	
	@Override
	public void run() {
		while(true){			
			Object obj = new Object();
			storage.put(obj);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}	
}

/**
 * �������߳�
 * @author GXF
 *
 */
class ConsumerScript2 implements Runnable{
	private Storage2 storage;
	
	public ConsumerScript2(Storage2 storage) {
		this.storage = storage;
	}
	@Override
	public void run() {
		while(true){			
			storage.take();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
