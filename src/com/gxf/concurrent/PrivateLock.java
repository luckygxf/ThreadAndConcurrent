package com.gxf.concurrent;

/**
 * java私有锁
 * @author Administrator
 *
 */
public class PrivateLock {
	private final Object myLock = new Object();
	
	Object widget;
	
	void someMethod(){
		synchronized(myLock){
			//访问或修改widget的状态
		}
	}
}
