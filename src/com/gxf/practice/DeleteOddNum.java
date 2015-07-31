package com.gxf.practice;

import com.gxf.util.Util;

/**
 * 删除数组中的奇数
 * @author GXF
 *
 */
public class DeleteOddNum {

	public static void main(String[] args) {
		int nums[] = {9,6,4,5,3,2,1,5,6,9,4,5,6,3,1};
		DeleteOddNum deleteOddNum = new DeleteOddNum();
		Util.showIntArray(nums);
		deleteOddNum.deleteOddNum(nums);
		Util.showIntArray(nums);
	}
	
	/**
	 * 删除数组中的奇数
	 * @param nums
	 */
	public void deleteOddNum(int nums[]){
		if(nums == null || nums.length == 0)
			return;
		int front = 0;
		int rear = nums.length - 1;
		
		while(front < rear){
			//找出前面的奇数
			while(front < rear && (nums[front] & 1) == 0)
				front++;
			//找出后面的偶数
			while(front < rear && (nums[rear] & 1) != 0)
				rear--;
			if(front < rear)
				swap(nums, front, rear);
		}//while
	}
	
	/**
	 * 交换第i元素和第j个元素
	 * @param nums
	 * @param i
	 * @param j
	 */
	private void swap(int nums[], int i, int j){
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}
