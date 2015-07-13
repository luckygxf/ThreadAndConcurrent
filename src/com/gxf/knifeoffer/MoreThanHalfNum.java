package com.gxf.knifeoffer;

/**
 * 剑指offer
 * 面试题29
 * 数组中出现超过一半的数字
 * @author GXF
 *
 */
public class MoreThanHalfNum {
	
	public static void main(String[] args) {
		int array[] = {1,2,3,2,2,2,5,4,2};
		MoreThanHalfNum moreThanHalfNum = new MoreThanHalfNum();
		System.out.println("result = " + moreThanHalfNum.mareThanHafNum(array));
	}
	
	/**
	 * 这里时间复杂度O(N)
	 * 空间复杂度O(1)
	 * @param array
	 * @return
	 */
	public int mareThanHafNum(int array[]){
		int result = array[0];
		int times = 1;
		
		for(int i = 1; i < array.length; i++){
			if(times == 0){
				result = array[i];
				times = 1;
			}
			else if(result == array[i])
				times++;
			else
				times--;
		}//for
		
		return result;
	}
}
