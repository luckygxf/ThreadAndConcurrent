package com.gxf.concurrent;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;

public class PrintAlph2 {
	public final Lock lock = new ReentrantLock();
	public final Condition[] a = new Condition[] { lock.newCondition(), lock.newCondition(), lock.newCondition() };
	public volatile int index = 0;
	String[] str = new String[] { "A", "B", "C" };

	public void print() {
		PrintThread pt = new PrintThread();
		new Thread(pt, "A").start();
		new Thread(pt, "B").start();
		new Thread(pt, "C").start();
	}

	class PrintThread implements Runnable {
		public void run() {
			String name = Thread.currentThread().getName();
			lock.lock();
			try {
				for (int i = 0; i < 10; i++) {
					boolean flag = name.equals(str[index]);
					if (!flag)
						a[index].await();
					System.out.print(str[index]);
					index = (index + 1) % 3;
					a[index].signal();
				}
			} catch (Exception e) {
				System.out.println(e);
			} finally {
				lock.unlock();
			}
		}
	}

	public static void main(String[] args) {
		new PrintAlph2().print();
	}
}
