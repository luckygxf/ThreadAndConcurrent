package com.gxf.proandcon;

import java.util.ArrayList;
import java.util.List;

import com.gxf.util.Util;

/**
 * 使用wait和notify实现生产者消费者模型
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
 * 封装仓库
 * @author GXF
 *
 */
class Storage1{
	final int MAXSIZE = 20;
	
	private List<Object> list = new ArrayList<Object>();
	
	/**
	 * 生产者向list中放内容
	 * @param obj
	 */
	public void put(Object obj){
		synchronized(list){

			while(list.size() >= MAXSIZE){							//如果已经满了
				try {
					list.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}//while
			//如果没有满,放生产的东西，唤醒消费者
			System.out.println("生产者生产一个产品");
			list.add(obj);
			Util.showListContent(list);
			list.notifyAll();
		}
	}
	
	/**
	 * 消费者消费
	 */
	public void take(){
		synchronized(list){
			while(list.size() <= 0){								//没有可以消费的内容
				try {
					list.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}//while
			
			//有消费的内容
			System.out.println("消费者消费一个产品");
			list.remove(list.size() - 1);
			Util.showListContent(list);
			list.notifyAll();
		}
	}
	
}

/**
 * 生产者线程
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
 * 消费者线程
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