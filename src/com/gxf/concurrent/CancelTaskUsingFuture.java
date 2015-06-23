package com.gxf.concurrent;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * 使用Future取消任务
 * @author Administrator
 *
 */
public class CancelTaskUsingFuture {
	//线程池
	private static ExecutorService taskExec = Executors.newFixedThreadPool(1);
	
	/**
	 * 指定执行任务时间，时间到通过future取消任务的执行
	 * @param r
	 * @param timeOut
	 * @param unit
	 */
	public static void timeRun(Runnable r, long timeOut, TimeUnit unit){
		Future<?> task = taskExec.submit(r);
		try {
			task.get(timeOut, unit);	//等待超时，等待给定的时间之后，获取其结果
		} catch (InterruptedException | ExecutionException | TimeoutException e) {
			e.printStackTrace();
		} finally{
			task.cancel(true);
			//关闭线程池
			taskExec.shutdown();
		}
		
	}
	
	/**
	 * 测试程序
	 * @param args
	 */
	public static void main(String args[]){
		Runnable scirpt = new IncrementSequence();
		
		//10s后结束任务
		timeRun(scirpt, 10, TimeUnit.SECONDS);
	}
}
