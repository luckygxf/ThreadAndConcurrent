package com.gxf.practice;

import com.gxf.util.Util;

/**杨氏矩阵查找数
 * 杨氏矩阵：从左到右递增，从上到下递增
 * 查找一个数是否在矩阵中
 * 在返回true,否则返回false
 * @author GXF
 *
 */
public class YongRec {

	public static void main(String[] args) {
		int  array[][] = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
		Util.showTwoDimensionArray(array);
		YongRec yongRec = new YongRec();
		
		boolean result = yongRec.findNumInArray(array, 5);
		System.out.println("result = " + result);
	} 
	
	/**
	 * 这里用的定位法
	 * 时间复杂度为O(m + n)
	 * @param array
	 * @param num
	 * @return
	 */
	public boolean findNumInArray(int array[][], int num){
		if(array == null || array.length == 0)
			return false;
		int i = 0;
		int j = array[0].length - 1;
		while(true){
			if(array[i][j] == num)
				return true;
			else if(j > 0 && array[i][j] > num)
				j--;
			else if(i < array.length - 1 && array[i][j] < num)
				i++;
			else 
				return false;
		}//while
	}	

}
