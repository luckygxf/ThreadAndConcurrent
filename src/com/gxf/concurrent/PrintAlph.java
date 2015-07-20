package com.gxf.concurrent;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;

public class PrintAlph {
	public final Lock lock = new ReentrantLock();
	public final Condition a = lock.newCondition();
	public final Condition b = lock.newCondition();
	public final Condition c = lock.newCondition();
	public int flag = 0;

	public void print() {
		new Thread(new A()).start();
		new Thread(new B()).start();
		new Thread(new C()).start();
	}

	class A implements Runnable {
		public void run() {
			lock.lock();
			try {
				for (int i = 0; i < 10; i++) {
					if (flag != 0){
						a.await();
					}
					flag = 1;
					System.out.print("A");
					System.out.print(flag);
					b.signal();
				}
			} catch (Exception e) {
				System.out.println(e);
			} finally {
				lock.unlock();
			}

		}
	}

	class B implements Runnable {
		public void run() {
			lock.lock();
			try {
				for (int i = 0; i < 10; i++) {
					if (flag != 1)
						b.await();
					flag = 2;
					System.out.print("B");
					System.out.print(flag);
					c.signal();
				}
			} catch (Exception e) {
				System.out.println(e);
			} finally {
				lock.unlock();
			}
		}
	}

	class C implements Runnable {
		public void run() {
			lock.lock();
			try {
				for (int i = 0; i < 10; i++) {
					if (flag != 2)
						c.await();
					flag = 0;
					System.out.print("C");
					System.out.print(flag);
					a.signal();
				}
			} catch (Exception e) {
				System.out.println(e);
			} finally {
				lock.unlock();
			}
		}
	}

	public static void main(String[] args) {
		PrintAlph pa = new PrintAlph();
		pa.print();
	}
}
