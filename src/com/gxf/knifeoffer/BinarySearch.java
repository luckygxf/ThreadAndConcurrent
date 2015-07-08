package com.gxf.knifeoffer;

public class BinarySearch {

	public static void main(String[] args) {
		int nums[] = new int[10];
		for(int i = 1; i < nums.length; i++){
			nums[i] = i + 5;
		}
		
		BinarySearch bs = new BinarySearch();
		int num = 9;
		
		int index = bs.binarySearch(nums, num);
		
		System.out.println("index = " + index);

	}
	
	/**
	 * 在一个排好序的数组中查找一个数
	 * 这里使用二分查找实现
	 * @param nums
	 * @param num
	 * @return
	 */
	public int binarySearch(int nums[], int num){
		if(nums == null || nums.length == 0)
			return -1;
		int low = 0;
		int high = nums.length - 1;
		int middle = (low + high) / 2;
		
		while(low <= high){
			if(nums[middle] == num)
				return middle;
			if(nums[middle] > num)
				high = middle - 1;
			else
				low = middle + 1;
			middle = (low + high) / 2;
		}//while
		
		return -1;
	}

}
