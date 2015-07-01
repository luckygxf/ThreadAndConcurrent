package com.gxf.designpattern;

/**
 * ����ģʽ
 * @author GXF
 *
 */
public class SingleObject {
	private static SingleObject singleton;
	
	private SingleObject(){
		
	}
	
	public synchronized static SingleObject getSingletonObject(){
		if(singleton == null){
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			singleton = new SingleObject();
		}
		return singleton;		
	}
}
