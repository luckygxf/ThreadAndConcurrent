package com.gxf.knifeoffer;

/**
 * 剑指offer
 * 面试题41
 * 在整数序列中查找两个数的和为一指定数
 * 在排好序的数组中可以用剑指offer上面的方法
 * 没有拍好序的可以用map实现，时间复杂度O(1)空间复杂度O（n）
 * @author GXF
 *
 */
public class FindTwoSum {

	public static void main(String[] args) {
		int array[] = {1,2,4,7,11,15};
		FindTwoSum findTwoSum = new FindTwoSum();
		int sum = 15;
		
		boolean result = findTwoSum.findTwoSum(array, sum);
		System.out.println("result = " + result);

	}
	/**
	 * 这里针对拍好序的数组
	 * @param array
	 * @param sum
	 * @return
	 */
	public boolean findTwoSum(int array[], int sum){
		boolean found = false;
		int startPoint = 0;
		int endPoint = array.length - 1;
		if(array == null || array.length < 2)
			return false;
		
		while(startPoint < endPoint){
			if(sum == array[startPoint] + array[endPoint]){
				found = true;
				System.out.println("num1 = " + array[startPoint] + " num2 = " + array[endPoint]);
				break;
			}//if
			if(sum > array[startPoint] + array[endPoint])
				startPoint++;
			else
				endPoint--;
		}//while
		
		return found;
	}

}
