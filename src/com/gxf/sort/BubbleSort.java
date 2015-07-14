package com.gxf.sort;

import com.gxf.util.Util;

/**
 * Ã°ÅÝÅÅÐò
 * @author GXF
 *
 */
public class BubbleSort {

	public static void main(String[] args) {
		BubbleSort bubbleSort = new BubbleSort();
		int array[] = {32, 1, 34, 54, 5, 6};
		Util.showInArray(array);
		bubbleSort.bubbleSort(array);
		Util.showInArray(array);

	}
	
	/**
	 * ÊµÏÖÃ°ÅÝÅÅÐò
	 * ÉýÐòÅÅÁÐ
	 * @param array
	 */
	public void bubbleSort(int array[]){
		if(array == null || array.length == 0)
			return;
		boolean exchanged = true;
		for(int i = array.length - 1; i > 0 && exchanged; i--){
			exchanged = false;
			for(int j = 1; j <= i; j++){
				if(array[j - 1] > array[j]){
					int temp = array[j - 1];
					array[j - 1] = array[j];
					array[j] = temp;
					exchanged = true;
				}//if
			}//for
			
		}//for
	}
}
