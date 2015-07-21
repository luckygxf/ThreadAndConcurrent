package com.gxf.practice;

/**
 * 用二分法求数的平方根
 * @author GXF
 *
 */
public class Squart {

	public static void main(String[] args) {
		int num = 2;
		System.out.println(Math.sqrt(num));
		System.out.println(Double.NaN);
		Squart squart = new Squart();
		System.out.println(squart.squart(num));
	}
	
	/**
	 * 求一个数的平方根
	 * @param num
	 * @return
	 */
	public double squart(int num){
		if(num < 0)
			return Double.NaN;
		if(num == 0)
			return 0;
		double low = 0;
		double high = num;
		double middle = (low + high) / 2;
		double precision = 0.00000000001;
		while(low <= high){
			double product = middle * middle;
			if(Math.abs(product - num) <= precision)
				return middle;
			if(product > num)
				high = middle;
			if(product < num)
				low = middle;
			middle = (high + low) / 2;
		}
		
		return middle;
	}
}
