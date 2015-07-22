package com.gxf.sort;

import com.gxf.util.Util;

/**
 * ��������
 * ����һ�λ���
 * @author GXF
 *
 */
public class QuickSort {


	public static void main(String[] args) {
		QuickSort quickSort = new QuickSort();
		int array[] = {32, 1, 34, 54, 5, 6};
		Util.showIntArray(array);
		quickSort.quickSort(array, 0, array.length - 1);
		Util.showIntArray(array);

	}
	
	/**
	 * ��������
	 * @param array
	 * @param start
	 * @param end
	 */
	public void quickSort(int array[], int start, int end){
		if(start < end){
			int index = partion(array, start, end);
			quickSort(array, start, index - 1);
			quickSort(array, index + 1, end);
		}
	}
	
	/**
	 * һ�λ���
	 * @param array
	 * @param start
	 * @param end
	 * @return
	 */
	public int partion(int array[], int start, int end){
		int key = array[start];
		while(start < end){
			while(start < end && array[end] > key)			//�Ӻ��濪ʼɨ��
				end--;
			array[start] = array[end];
			while(start < end && array[start] < key)
				start++;
			array[end] = array[start];
		}//while
		array[start] = key;
		
		return start;
	}

}
