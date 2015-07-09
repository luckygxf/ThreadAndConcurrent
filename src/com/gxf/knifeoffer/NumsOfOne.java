package com.gxf.knifeoffer;

/**
 * 剑指offer
 * 面试题10
 * 一个数二进制中1出现的次数
 * @author GXF
 *
 */
public class NumsOfOne {
	public int getNumsOfOne(int num){
		int count = 0;
		while(num != 0){
			if((num & 1) != 0)
				count++;
			num >>>= 1;
		}//while
		
		return count;
	}//getNumsOfOne
	
	public static void main(String args[]){
		NumsOfOne numsOfOne = new NumsOfOne();
		int count = numsOfOne.getNumsOfOne(8);
		
		System.out.println("count = " + count);
	}
}
