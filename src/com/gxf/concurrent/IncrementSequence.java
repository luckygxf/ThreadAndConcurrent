package com.gxf.concurrent;

/**
 * 1s中增长1
 * @author Administrator
 *
 */
public class IncrementSequence implements Runnable{
	public int sequence = 0;
	
	@Override
	public void run() {
		try {
			while(true){
				sequence ++;
				System.out.println("sequence = " + sequence);
				//出现中断，抛出异常interruptexception，线程中断状态被清除
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
}
