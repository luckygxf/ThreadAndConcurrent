package com.gxf.practice;

/**
 * 查找一个数字在数组中的位置
 * @author GXF
 *
 */
public class FindNumInArray {

	public static void main(String[] args) {
		int array[] = {1,2,3,4,5,6,4,3,2,1,0,1,2,3,4};
		FindNumInArray findNumInArray = new FindNumInArray();
		int num = 0;
		int index = findNumInArray.findNumInSpecialArray(array, num);
		int index1 = findNumInArray.findNumByOrderQuery(array, num);
		
		System.out.println("index1 = " + index1);
		System.out.println("index = " + index);

	}
	
	/**
	 * 在一个每两个相邻的数之间的差值不是1就是-1数组中查找一个数的位置
	 * @param nums
	 * @param num
	 * @return
	 */
	public int findNumInSpecialArray(int nums[], int num){
		if(nums == null || nums.length == 0)
			return -1;
		for(int i = 0; i < nums.length;){
			if(num == nums[i])
				return i;
			int distance = Math.abs(nums[i] - num);
			i += distance;
		}//for
		
		return -1;
	}
	
	/**
	 * 顺序查找
	 * @param nums
	 * @param num
	 * @return
	 */
	public int findNumByOrderQuery(int nums[], int num){
		for(int i = 0; i < nums.length; i++){
			if(nums[i] == num)
				return i;
		}//for
		
		return -1;
	}

}
