package com.gxf.concurrent;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 测试concurrent包下面的AtomicInteger
 * @author GXF
 *
 */
public class TestConAtomic {
	public static void main(String args[]) throws InterruptedException{
		AtomicInteger counter = new AtomicInteger();
		
		Thread thread1 = new Thread(new Script(counter));
		Thread thread2 = new Thread(new Script(counter));
		
		thread1.start();
		thread2.start();
		
		thread1.join();
		thread2.join();
		
		System.out.println("counter = " + counter.get());
	}
}

class Script implements Runnable{
	private AtomicInteger counter;
	
	public Script(AtomicInteger counter){
		this.counter = counter;
	}
	
	@Override
	public void run() {
		for(int i = 0; i < 10000; i++){
			counter.incrementAndGet();
		}
		
	}
	
}
