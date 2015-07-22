package com.gxf.sort;

import com.gxf.util.Util;

/**
 * 希尔排序
 * 时间复杂度O（n * logn）
 * 空间复杂度O（1）
 * @author GXF
 *
 */
public class ShellSort {


	public static void main(String[] args) {
		int array[] = {32, 1, 34, 54, 5, 6};
		ShellSort shellSort = new ShellSort();
		Util.showIntArray(array);
		shellSort.shellSort(array);
		Util.showIntArray(array);

	}
	
	/**
	 * 这段代码整理的确实漂亮
	 * @param array
	 */
	public void shellSort(int array[]){
		if(array == null || array.length == 0)
			return;
		for(int gap = array.length / 2; gap > 0; gap /= 2){
			for(int i = gap; i < array.length; i++){
				for(int j = i; j >= gap && array[j] < array[j - gap]; j -= gap)
					swap(array, j, j - gap);
			}
		}
	}
	
	private void swap(int array[], int i, int j){
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

}
