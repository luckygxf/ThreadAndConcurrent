package com.gxf.concurrent;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * ʹ��Futureȡ������
 * @author Administrator
 *
 */
public class CancelTaskUsingFuture {
	//�̳߳�
	private static ExecutorService taskExec = Executors.newFixedThreadPool(1);
	
	/**
	 * ָ��ִ������ʱ�䣬ʱ�䵽ͨ��futureȡ�������ִ��
	 * @param r
	 * @param timeOut
	 * @param unit
	 */
	public static void timeRun(Runnable r, long timeOut, TimeUnit unit){
		Future<?> task = taskExec.submit(r);
		try {
			task.get(timeOut, unit);	//�ȴ���ʱ���ȴ�������ʱ��֮�󣬻�ȡ����
		} catch (InterruptedException | ExecutionException | TimeoutException e) {
			e.printStackTrace();
		} finally{
			task.cancel(true);
			//�ر��̳߳�
			taskExec.shutdown();
		}
		
	}
	
	/**
	 * ���Գ���
	 * @param args
	 */
	public static void main(String args[]){
		Runnable scirpt = new IncrementSequence();
		
		//10s���������
		timeRun(scirpt, 10, TimeUnit.SECONDS);
	}
}
