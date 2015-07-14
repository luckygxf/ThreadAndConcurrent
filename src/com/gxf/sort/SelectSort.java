package com.gxf.sort;

import com.gxf.util.Util;

/**
 * 直接选择排序
 * @author GXF
 *
 */
public class SelectSort {

	public static void main(String[] args) {
		SelectSort selectSort = new SelectSort();
		int array[] = {32, 1, 34, 54, 5, 6};
		Util.showInArray(array);
		selectSort.selectSort(array);
		Util.showInArray(array);

	}
	
	/**
	 * 直接选择排序
	 * @param array
	 */
	public void selectSort(int array[]){
		for(int i = 0; i < array.length; i++){
			int min = i;
			for(int j = i + 1; j < array.length; j++){
				if(array[j] < array[min])
					min = j;
			}//for
			if(min != i){
				int temp = array[i];
				array[i] = array[min];
				array[min] = temp;
			}//if
		}//for
	}
}
