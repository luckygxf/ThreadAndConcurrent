package com.gxf.concurrent;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * ËØÊýÉú³ÉÆ÷
 * @author Administrator
 *
 */
public class PrimeGenerator implements Runnable{
	private List<BigInteger> primes = new ArrayList<BigInteger>();
	private volatile boolean cancle = false;
	

	@Override
	public void run() {
		BigInteger p = BigInteger.ONE;
		while(!cancle){
			primes.add(p);
			p = p.nextProbablePrime();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}//while
		
	}
	
	public void cancel(){
		cancle = true;
	}
	
	public List<BigInteger> getPrimes(){
		return new ArrayList<BigInteger>(primes);
	}
	
	public static void main(String args[]) throws InterruptedException{
		PrimeGenerator primeGenerator = new PrimeGenerator();
		Thread thread = new Thread(primeGenerator);
		thread.start();
		
		Thread.sleep(5000);
		primeGenerator.cancel();
		
		primeGenerator.showPrimes(primeGenerator.getPrimes());
	}
	
	public void showPrimes(List<BigInteger> listOfPrimes){
		for(int i = 0; i < listOfPrimes.size(); i++){
			System.out.println(listOfPrimes.get(i));
		}
	}
}
