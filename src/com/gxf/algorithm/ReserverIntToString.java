package com.gxf.algorithm;

/**
 * 将整数逆序后返回字符串
 * @author GXF
 *
 */
public class ReserverIntToString {
	
	public String reserveIntToString(int num){
		if(num / 10 == 0)
			return "" + num;
		int lowest = num % 10;
		return lowest + reserveIntToString(num / 10);
	}
	
	public static void main(String args[]){
		ReserverIntToString reserverIntToString = new ReserverIntToString();
		int num = 123;
		String result = reserverIntToString.reserveIntToString(num);
		
		System.out.println("result = " + result);
	}
}
