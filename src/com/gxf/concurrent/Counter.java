package com.gxf.concurrent;

public class Counter {
	private  long value = 0;
	
	public synchronized  long  getValue(){
		return value;
	}
	
	public synchronized void increament(){
		value++;
	}
	
	static class Script implements Runnable{
		private Counter counter;
		
		public Script(Counter counter){
			this.counter = counter;
		}
		
		@Override
		public void run() {
			counter.increament();
			
		}		
	}
	
	/**
	 * ≤‚ ‘≥Ã–Ú
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String args[]) throws InterruptedException{
		Counter counter = new Counter();
		Script script = new Script(counter);
		
		for(int i = 0; i < 1000; i++){
			Thread thread =  new Thread(script);
			thread.start();
		}
		while(Thread.activeCount() > 1)
			Thread.yield();
//		Thread.sleep(100);
		System.out.println(counter.getValue());
		
	}
}
