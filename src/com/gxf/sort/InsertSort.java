package com.gxf.sort;

import com.gxf.util.Util;

/**
 * ÷±Ω”≤Â»Î≈≈–Ú
 * @author GXF
 *
 */
public class InsertSort {

	public static void main(String[] args) {
		int array[] = {32, 1, 34, 54, 5, 6};
		
		Util.showIntArray(array);
		
		InsertSort insertSort = new InsertSort();
		insertSort.insertSort(array);
		
		Util.showIntArray(array);
	}
	
	public void insertSort(int array[]){
		if(array == null || array.length == 0)
			return;
		
		for(int i = 1; i < array.length; i++){
			int temp = array[i];
			int j = i;
			while(j >= 1 && array[j - 1] > temp)
			{
				array[j] = array[j - 1];
				j--;
			}//while
			array[j] = temp;
		}//for
	}
	
	
}
