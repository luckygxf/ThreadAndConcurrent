package com.gxf.sort;

import com.gxf.util.Util;

/**
 * �鲢����
 * �鲢���ݹ� + �ϲ�
 * ʱ�临�Ӷ�O��n * logn��
 * �ռ临�Ӷ�O(N)
 * @author GXF
 *
 */
public class MergeSort {


	public static void main(String[] args) {
		int array[] = {32, 1, 34, 54, 5, 6};
		MergeSort mergeSort = new MergeSort();
		Util.showIntArray(array);
		mergeSort.mergeSort(array);
		Util.showIntArray(array);

	}
	
	
	public void mergeSort(int array[]){
		if(array == null || array.length == 0)
			return;
		mergeSort(array, 0, array.length - 1, new int[array.length]);
	}
	
	/**
	 * �鲢����
	 * ��������
	 * @param array
	 * @param start
	 * @param last
	 * @param temp
	 */
	private void mergeSort(int array[], int start, int last, int temp[]){
		if(start < last){
			int middle = (start + last) / 2;
			mergeSort(array, start, middle, temp);
			mergeSort(array, middle + 1, last, temp);
			merge(array, start, middle, last, temp);
		}
	}
	
	/**
	 * �ϲ���������
	 * @param array
	 * @param start
	 * @param middle
	 * @param last
	 * @param temp
	 */
	public void merge(int array[], int start, int middle, int last, int temp[]){
		int first = start;
		int second = middle + 1;
		int k = 0;
		
		while(first <= middle && second <= last){
			if(array[first] < array[second])
				temp[k++] = array[first++];
			else
				temp[k++] = array[second++];
		}//while
		
		while(first <= middle)
			temp[k++] = array[first++];
		while(second <= last)
			temp[k++] = array[second++];
		for(int i = 0; i < k; i++)
			array[start + i] = temp[i];
	}

}
