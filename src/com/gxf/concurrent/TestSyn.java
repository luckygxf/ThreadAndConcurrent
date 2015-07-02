package com.gxf.concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * �̷߳���synchronized���εķ���ʱ�������߳̿��Է��ʷ�synchronized���εķ���
 * �������õ��˱������о�����ȷʵ����
 * @author GXF
 *
 */
public class TestSyn {
	public static CountDownLatch countDownLatch = new CountDownLatch(1);
	
	public synchronized void synMethod(){
		System.out.println("����ִ��syn����");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("syn�����˳�");
	}
	
	public void noSynMethod(){
		System.out.println("����ִ�з�syn����");
	}
	public synchronized void synMethod1(){
		System.out.println("����ִ��syn����1");
	}
	
	public static synchronized void staticSynMethod(){
		System.out.println("����ִ��staticSynMethod");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("�˳�staticSynMethod");
	}
	
	public void lockClassMethod(){
		synchronized(TestSyn.class){
			System.out.println("����ִ��lockClassMethod");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("�����˳�lockClassMethod");
		}
		
	}
	
	public static void main(String args[]){
		TestSyn testSyn = new TestSyn();
		TestSyn testSyn1 = new TestSyn();
		
//		Thread thread1 = new Thread(new Script1(testSyn));
//		Thread thread2 = new Thread(new Script2(testSyn));
//		Thread thread3 = new Thread(new Script3(testSyn));
//		Thread thread4 = new Thread(new Script4(testSyn));
//		Thread thread5 = new Thread(new Script5(testSyn));
		Thread thread6 = new Thread(new Script6(testSyn));
		Thread thread7 = new Thread(new Script7(testSyn1));
		
//		thread1.start();
//		thread2.start();
//		thread3.start();
//		thread4.start();
//		thread5.start();
		thread6.start();
		thread7.start();
		
		countDownLatch.countDown();
	}
}

class Script1 implements Runnable{
	TestSyn testSyn;
	
	public Script1(TestSyn testSyn){
		this.testSyn = testSyn;
	}
	@Override
	public void run() {
		try {
			TestSyn.countDownLatch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		testSyn.synMethod();		
	}	
}
class Script2 implements Runnable{
	TestSyn testSyn;
	
	public Script2(TestSyn testSyn){
		this.testSyn = testSyn;
	}
	@Override
	public void run() {
		try {
			TestSyn.countDownLatch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		testSyn.noSynMethod();	
	}	
}
class Script3 implements Runnable{
	TestSyn testSyn;
	
	public Script3(TestSyn testSyn){
		this.testSyn = testSyn;
	}
	@Override
	public void run() {
		try {
			TestSyn.countDownLatch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		testSyn.synMethod1();
	}	
}
class Script4 implements Runnable{
	TestSyn testSyn;
	
	public Script4(TestSyn testSyn){
		this.testSyn = testSyn;
	}
	@Override
	public void run() {
		try {
			TestSyn.countDownLatch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		TestSyn.staticSynMethod();
	}	
}
class Script5 implements Runnable{
	TestSyn testSyn;
	
	public Script5(TestSyn testSyn){
		this.testSyn = testSyn;
	}
	@Override
	public void run() {
		try {
			TestSyn.countDownLatch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		TestSyn.staticSynMethod();
	}	
}
class Script6 implements Runnable{
	TestSyn testSyn;
	
	public Script6(TestSyn testSyn){
		this.testSyn = testSyn;
	}
	@Override
	public void run() {
		try {
			TestSyn.countDownLatch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		testSyn.lockClassMethod();
	}	
}

class Script7 implements Runnable{
	TestSyn testSyn;
	
	public Script7(TestSyn testSyn){
		this.testSyn = testSyn;
	}
	@Override
	public void run() {
		try {
			TestSyn.countDownLatch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		testSyn.lockClassMethod();
	}	
}

