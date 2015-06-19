package com.gxf.test;

public class InitClass {
	static{
		if(true){
			System.out.println(Thread.currentThread() + "init Class");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		Runnable script = new Runnable(){
			public void run(){
				System.out.println(Thread.currentThread() + "run start");
				InitClass initClass = new InitClass();
				System.out.println(Thread.currentThread() + "run over");
			}
		};
		
		Thread thread1 = new Thread(script);
		Thread thread2 = new Thread(script);
		
		thread1.start();
		thread2.start();

	}

}
