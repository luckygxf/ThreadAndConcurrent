package com.gxf.proandcon;

import java.util.ArrayList;
import java.util.List;

import com.gxf.util.Util;

/**
 * ʹ��wait��notifyʵ��������������ģ��
 * @author GXF
 *
 */
public class WaitAndNotify {
	public static void main(String args[]){
		Storage1 storage = new Storage1();
		ProductScript1 ps = new ProductScript1(storage);
		ConsumerScript1 cs = new ConsumerScript1(storage);
		
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
class Storage1{
	final int MAXSIZE = 20;
	
	private List<Object> list = new ArrayList<Object>();
	
	/**
	 * ��������list�з�����
	 * @param obj
	 */
	public void put(Object obj){
		synchronized(list){

			while(list.size() >= MAXSIZE){							//����Ѿ�����
				try {
					list.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}//while
			//���û����,�������Ķ���������������
			System.out.println("����������һ����Ʒ");
			list.add(obj);
			Util.showListContent(list);
			list.notifyAll();
		}
	}
	
	/**
	 * ����������
	 */
	public void take(){
		synchronized(list){
			while(list.size() <= 0){								//û�п������ѵ�����
				try {
					list.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}//while
			
			//�����ѵ�����
			System.out.println("����������һ����Ʒ");
			list.remove(list.size() - 1);
			Util.showListContent(list);
			list.notifyAll();
		}
	}
	
}

/**
 * �������߳�
 * @author GXF
 *
 */
class ProductScript1 implements Runnable{
	private Storage1 storage;
	
	public ProductScript1(Storage1 storage) {
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
class ConsumerScript1 implements Runnable{
	private Storage1 storage;
	
	public ConsumerScript1(Storage1 storage) {
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