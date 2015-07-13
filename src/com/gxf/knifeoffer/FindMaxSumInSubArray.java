package com.gxf.knifeoffer;

/**
 * 查找一个数组中连续元素的最大和
 * 剑指offer
 * 面试题31
 * @author GXF
 *
 */
public class FindMaxSumInSubArray {

	public static void main(String[] args) {
		int array[] = {1,-2,3,10,-4,7,2,-5};
		FindMaxSumInSubArray findMaxSumInSubArray = new FindMaxSumInSubArray();
		int result = findMaxSumInSubArray.findMaxSumInSubArray(array);
		System.out.println("result = " + result);

	}
	
	/**
	 * 动态规划f(i)表示i前面连续数组最大的和
	 * 求出max[f(i)]
	 * f(i) = f(i - 1) + array[i] (f(i) > 0) 或者 f(i) = array[i] (f(i) <= 0) 
	 * @param array
	 * @return
	 */
	public int findMaxSumInSubArray(int array[]){
		int max_result = Integer.MIN_VALUE;
		int max_cur = 0;
		
		for(int i = 0; i < array.length ; i++){
			if(max_cur <= 0)
				max_cur = array[i];
			else
				max_cur += array[i];
			if(max_cur > max_result)
				max_result = max_cur;
		}//for
		
		return max_result;
	}
}
