package com.gxf.concurrent;

public class TestThreadYield {

	public static void main(String[] args) {
		Thread thread1 = new Thread(new Runnable(){

			@Override
			public void run() {
				System.out.println(1);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}});
		Thread thread2 = new Thread(new Runnable(){

			@Override
			public void run() {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(2);
				
			}});

		thread1.start();
		thread2.start();
		thread2.yield();
	}

}
