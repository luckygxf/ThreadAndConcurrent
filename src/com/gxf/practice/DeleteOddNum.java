package com.gxf.practice;

import com.gxf.util.Util;

/**
 * ɾ�������е�����
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
	 * ɾ�������е�����
	 * @param nums
	 */
	public void deleteOddNum(int nums[]){
		if(nums == null || nums.length == 0)
			return;
		int front = 0;
		int rear = nums.length - 1;
		
		while(front < rear){
			//�ҳ�ǰ�������
			while(front < rear && (nums[front] & 1) == 0)
				front++;
			//�ҳ������ż��
			while(front < rear && (nums[rear] & 1) != 0)
				rear--;
			if(front < rear)
				swap(nums, front, rear);
		}//while
	}
	
	/**
	 * ������iԪ�غ͵�j��Ԫ��
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
