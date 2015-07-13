package com.gxf.knifeoffer;

/**
 * 剑指offer
 * 面试题34
 * 丑数
 * @author GXF
 *
 */
public class UglyNumber {

	public static void main(String[] args) {
		UglyNumber uglyNumber = new UglyNumber();
		int result = uglyNumber.getNthUglyNumber(1500);
		
		System.out.println("result = " + result);

	}
	
	public boolean isUglyNumber(int num){
		while(num % 2 == 0)
			num /= 2;
		while(num % 5 == 0)
			num /= 5;
		while(num % 3 == 0)
			num /= 3;
		if(num == 1)
			return true;
		return false;
	}

	public int getNthUglyNumber(int n){
		int uglyNumber = 0;
		int number = 1;
		
		while(uglyNumber < n){
			if(isUglyNumber(number))
				uglyNumber++;
			number++;
		}//while
		
		return number;
	}
}
