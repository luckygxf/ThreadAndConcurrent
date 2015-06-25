package com.gxf.concurrent;

public class NoVisibility {
	public static boolean ready;
	public static int number;
	
	static class ReaderThread extends Thread{
		public void run(){
			while(!ready){
				Thread.yield();
			}
			System.out.println("number = " + number);
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		new ReaderThread().start();
		number = 5;
		Thread.sleep(1000);
		ready = true;

	}

}
