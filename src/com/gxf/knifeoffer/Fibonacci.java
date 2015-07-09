package com.gxf.knifeoffer;

/**
 * ��ָoffer
 * ������9
 * 쳲���������
 * ʹ�õݹ�Ͷ�̬�滮ʵ��쳲���������
 * @author GXF
 *
 */
public class Fibonacci {
	
	/**
	 * �õݹ�ʵ��쳲���������
	 * @param n
	 * @return
	 */
	public int getFibonacciByRecursive(int n){
		if(n == 0 || n == 1)
			return 1;
		return getFibonacciByRecursive(n - 1) + getFibonacciByRecursive(n - 2);
	}
	
	/**
	 * ʹ�ö�̬�滮�ҳ�쳲������е�n������
	 * ��̬�滮��Ҫ���ҳ����ƹ�ϵ
	 * �������ǰ��ļ������������ظ�����
	 * �������н��
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
		
		System.out.println("쳲����������е�10��Ԫ����  "  + result);
		System.out.println("쳲����������е�10��Ԫ����  "  + result1);
	}
}
