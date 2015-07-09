package com.gxf.knifeoffer;

/**
 * 剑指offer
 * 面试题9
 * 斐波那契数列
 * 使用递归和动态规划实现斐波那契数列
 * @author GXF
 *
 */
public class Fibonacci {
	
	/**
	 * 用递归实现斐波那契数列
	 * @param n
	 * @return
	 */
	public int getFibonacciByRecursive(int n){
		if(n == 0 || n == 1)
			return 1;
		return getFibonacciByRecursive(n - 1) + getFibonacciByRecursive(n - 2);
	}
	
	/**
	 * 使用动态规划找出斐波那契中第n个数字
	 * 动态规划主要是找出递推关系
	 * 并保存好前面的计算结果，以免重复计算
	 * 计算最有解等
	 * @param n
	 * @return
	 */
	public int getFibonacciByDP(int n){
		if(n == 0 || n == 1)
			return 1;
		int result[] = new int[n + 1];
		result[0] = result[1] = 1;
		for(int i = 2; i <= n; i++){
			result[i] = result[i - 1] + result[i - 2];
		}
		
		return result[n];
	}
	
	public static void main(String args[]){
		Fibonacci fibonacci = new Fibonacci();
		int result = fibonacci.getFibonacciByRecursive(10);
		int result1 = fibonacci.getFibonacciByDP(10);
		
		System.out.println("斐波那契数列中第10个元素是  "  + result);
		System.out.println("斐波那契数列中第10个元素是  "  + result1);
	}
}
