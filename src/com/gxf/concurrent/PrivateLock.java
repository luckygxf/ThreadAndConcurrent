package com.gxf.concurrent;

/**
 * java˽����
 * @author Administrator
 *
 */
public class PrivateLock {
	private final Object myLock = new Object();
	
	Object widget;
	
	void someMethod(){
		synchronized(myLock){
			//���ʻ��޸�widget��״̬
		}
	}
}
