package com.gxf.concurrent;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 使用读写锁包装Map类
 * @author GXF
 *
 */
public class ReadWriteMap<K, V> {
	private Map<K, V> map;
	private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
	private final Lock readLock = readWriteLock.readLock();
	private final Lock writeLock = readWriteLock.writeLock();
	
	public ReadWriteMap(Map<K, V> map){
		this.map = map;
	}
	
	/**
	 * 用写锁控制同步
	 * @param key
	 * @param value
	 */
	public void put(K key, V value){
		writeLock.lock();
		map.put(key, value);
		writeLock.unlock();
	}
	
	/**
	 * 使用读锁控制同步
	 * @param key
	 * @return
	 */
	public V get(K key){
		readLock.lock();
		V result = map.get(key);
		readLock.unlock();
		
		return result;
	}
	
	/**
	 * 获取map大小 
	 * @return
	 */
	public int getSize(){
		readLock.lock();
		int size = map.size();
		readLock.unlock();
		
		return size;
	}
	
	
	public Set<K> keySet(){
		readLock.lock();
		Set<K> result = map.keySet();
		readLock.unlock();
		
		return result;
	}
	
	/**
	 * 写线程要执行的脚本
	 * @author GXF
	 *
	 */
	static class ReadScript implements Runnable{
		private ReadWriteMap<Integer, Integer> map;
		
		public ReadScript(ReadWriteMap<Integer, Integer> map){
			this.map = map;
		}
		
		@Override
		public void run() {
			Iterator<Integer> iterator = map.keySet().iterator();
			//读取map中所有的内容
			while(iterator.hasNext()){
				System.out.println(Thread.currentThread().getName() + "正在读取" + map.get(iterator.next()));
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		}
		
	}//ReadScript
	
	/**
	 * 写线程要执行的脚本
	 * @author GXF
	 *
	 */
	static class WriteScript implements Runnable{
		private ReadWriteMap<Integer, Integer> map;
		private int numStart;
		
		public WriteScript(ReadWriteMap<Integer, Integer> map, int numStart){
			this.map = map;
			this.numStart = numStart;
		}
		
		@Override
		public void run() {
			for(int i = numStart; i < numStart + 10; i++){
				System.out.println(Thread.currentThread().getName() + "正在写入数据" + i);
				map.put(i, i);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		}
		
	}//WriteScript
	
	/**
	 * 测试程序
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String args[]) throws InterruptedException{
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		ReadWriteMap<Integer, Integer> readWriteMap = new ReadWriteMap<Integer, Integer>(map);
		
		ReadScript readScript = new ReadScript(readWriteMap);
		WriteScript writeScript = new WriteScript(readWriteMap, 0);
		
		
		
		for(int i = 0; i < 5; i++){
			Thread thread = new Thread(readScript);
			thread.start();
		}
		
		Thread writeThread = new Thread(writeScript);
		writeThread.start();
		
		Thread.sleep(1000);
	
		for(int i = 0; i < 5; i++){
			Thread thread = new Thread(readScript);
			thread.start();
		}
		
	}
}
