package com.gxf.concurrent;

/**
 * 1s������1
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
				//�����жϣ��׳��쳣interruptexception���߳��ж�״̬�����
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
}
