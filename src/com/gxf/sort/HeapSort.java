package com.gxf.sort;

import com.gxf.util.Util;

/**
 * 堆排序
 * 时间复杂度O（n * logn）
 * 空间复杂度O（1）
 * @author GXF
 *
 */
public class HeapSort {

	public static void main(String[] args) {
		int array[] = {32, 1, 34, 54, 5, 6};
		HeapSort heapSort = new HeapSort();
		Util.showIntArray(array);
		heapSort.heapSort(array);
		Util.showIntArray(array);

	}
	
	/**
	 * 堆排序
	 * 升序排列
	 * 先建立一个大根堆
	 * 用数组最后一个元素和第一个元素交换，调整大根堆
	 * @param array
	 */
	public void heapSort(int array[]){
		//建堆
		for(int i = array.length / 2 - 1; i >= 0; i--){
			maxHeapFixDown(array, i, array.length);
		}
		//调整堆
		for(int i = array.length - 1; i >= 0; i--){
			swap(array, 0, i);
			maxHeapFixDown(array, 0, i);
		}
	}
	
	/**
	 * 对大根堆中，i节点进行向下调整
	 * @param array
	 * @param i
	 */
	private void maxHeapFixDown(int array[], int i, int n){
		int temp = array[i];
		int j = 2 * i + 1;
		while(j < n && i < n){
			//选出子节点中最大的
			if(j + 1 < n && array[j] < array[j + 1])
				j = j + 1;
			if(array[j] < temp)
				break;
			//子节点中最大的向上移动
			array[i] = array[j];
			i = j;
			j = 2 * i + 1;
		}//while
		array[i] = temp;
	}
	
	private void swap(int array[], int i, int j){
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}
