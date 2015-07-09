package com.gxf.knifeoffer;

/**
 * 剑指offer
 * 面试题14
 * 调整数组中奇数和偶数的位置
 * 前部分为奇数
 * 后半部分为偶数
 * @author GXF
 *
 */
public class ReverseOddEven {

	public static void main(String[] args) {
		ReverseOddEven reverseOddEven = new ReverseOddEven();
		int array[] = {9,6,5,3,6,9,4,2,4,5};
		reverseOddEven.reverseOddEven(array);

		for(int i = 0; i < array.length; i++)
			System.out.print(array[i] + " ");
		System.out.println();
	}
	
	public void reverseOddEven(int array[]){
		if(array == null || array.length == 0|| array.length == 1)
			return;
		int head = 0;
		int tail = array.length - 1;
		
		while(head < tail){
			//找出前半部分第一个偶数
			while(array[head++] % 2 != 0);
			//找出后半段第一个奇数
			while(array[tail--] % 2 != 1);
			int temp = array[--head];
			array[head] = array[++tail];
			array[tail] = temp;
		}//while
	}

}
