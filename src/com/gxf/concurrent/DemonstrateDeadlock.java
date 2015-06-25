package com.gxf.concurrent;

import java.util.Random;

/**
 * 验证死锁
 * @author Administrator
 *
 */
public class DemonstrateDeadlock {
	/**
	 * 账户类
	 * @author Administrator
	 *
	 */
	static class Account{
		public int amount;
		public Account(int amount){
			this.amount = amount;
		}
		
		public Account(){
			this.amount = 10000;
		}
		
		/**
		 * 取钱
		 * @param amount
		 * @return
		 */
		public void debit(int amount){
			this.amount -= amount;
		}
		
		/**
		 * 存钱
		 * @param amount
		 */
		public void credit(int amount){
			this.amount += amount;
		}
	}//Account
	
	//容易发生死锁
	/**
	 * 转账
	 * @param fromAccount
	 * @param toAccount
	 * @param amount
	 */
	public static void transferMoney(Account fromAccount, Account toAccount, int amount){
		synchronized(fromAccount){
			synchronized(toAccount){
				fromAccount.debit(amount);
				toAccount.credit(amount);
				try {
					Thread.sleep(20);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	private static final int NUM_TRHEADS = 20;
	private static final int NUM_ACCOUNTS = 5;
	private static final int NUM_ITERATIONS = 1000000;
	
	
	public static void main(String args[]){
		final Random rnd = new Random();
		final Account accounts[] = new Account[NUM_ACCOUNTS];
		
		for(int i = 0; i < NUM_ACCOUNTS; i++)
			accounts[i] = new Account();
		
		/**
		 * 转账线程
		 * @author Administrator
		 *
		 */
		class TransferThread extends Thread{
			public void run(){
				int fromAccount = rnd.nextInt(NUM_ACCOUNTS);
				int toAccount = rnd.nextInt(NUM_ACCOUNTS);
				
				int amount = rnd.nextInt(100);
				DemonstrateDeadlock.transferMoney(accounts[fromAccount], accounts[toAccount], amount);
			}
		}
		
		//启动转账线程
		for(int i = 0; i < NUM_TRHEADS; i++)
			new TransferThread().start();
	}
	
}
