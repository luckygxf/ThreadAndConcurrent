package com.gxf.practice;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 防止反射破幻单例模式
 * @author GXF
 *
 */
public class ReflectSingleton {
	private static ReflectSingleton singleton;
	private static boolean isFirst = true;
	private ReflectSingleton() throws Exception{
		if(isFirst)
			isFirst = !isFirst;
		else{
			throw new Exception("只能初始化一次");
		}
	}
	
	public static ReflectSingleton getReflectSingleTon() throws Exception{
		if(singleton == null){
			singleton = new ReflectSingleton();
		}
		return singleton;
	}
	
	public static void main(String args[]) {
		final Thread thread1 = new Thread(new Runnable(){

			@Override
			public void run() {
				int i = 0;
				while(true){
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(i++);
				}
				
			}
			
		});
		thread1.start();
		
		new Thread(new Runnable(){

			@Override
			public void run() {
				thread1.interrupt();
				
			}
			
		}).start();
		

		
	}
	
}

enum SINGLETON{
	INSTANCE;
}
