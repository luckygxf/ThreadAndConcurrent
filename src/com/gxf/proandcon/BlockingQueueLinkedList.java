package com.gxf.proandcon;

import java.util.concurrent.LinkedBlockingQueue;

public class BlockingQueueLinkedList {

	public static void main(String args[]){
		Storage storage = new Storage();
		ProductScript ps = new ProductScript(storage);
		ConsumerScript cs = new ConsumerScript(storage);
		
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
 * 包装容器
 * @author GXF
 *
 */
class Storage{
	private LinkedBlockingQueue<Object> list = new LinkedBlockingQueue<Object>();
	
	/**
	 * 生产者生产
	 * @param obj
	 */
	public void put(Object obj){
		try {
			list.put(obj);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 消费者消费
	 */
	public void take(){
		try {
			list.take();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

/**
 * 生产者线程
 * @author GXF
 *
 */
class ProductScript implements Runnable{
	private Storage storage;
	
	public ProductScript(Storage storage) {
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
class ConsumerScript implements Runnable{
	private Storage storage;
	
	public ConsumerScript(Storage storage) {
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