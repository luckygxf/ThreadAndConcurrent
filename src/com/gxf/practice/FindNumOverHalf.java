package com.gxf.practice;

/**
 * 还需要检测是否超过一半，可设置全局变量
 * @author GXF
 *
 */
public class FindNumOverHalf {

	public static void main(String[] args) {
		FindNumOverHalf findNumOverHalf = new FindNumOverHalf();
		
		int nums[] = {6,2,3,6,2,6,2,6,2,6,6,6,6,6,6,6,6};
		int result = findNumOverHalf.findNumOverHalf(nums);
		System.out.println("result = " + result);

	}
	
	public int findNumOverHalf(int nums[]){
		int result = nums[0];
		int times = 1;
		
		for(int i = 1; i < nums.length; i++){
			if(nums[i] == result)
				times++;
			else{
				if(times == 0){
					result = nums[i];
					times = 1;
				}
				else
					times--;
			}//else
		}//for
		
		return result;
	}
}
