package com.gxf.sort;

import com.gxf.util.Util;

/**
 * ������
 * ʱ�临�Ӷ�O��n * logn��
 * �ռ临�Ӷ�O��1��
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
	 * ������
	 * ��������
	 * �Ƚ���һ�������
	 * ���������һ��Ԫ�غ͵�һ��Ԫ�ؽ��������������
	 * @param array
	 */
	public void heapSort(int array[]){
		//����
		for(int i = array.length / 2 - 1; i >= 0; i--){
			maxHeapFixDown(array, i, array.length);
		}
		//������
		for(int i = array.length - 1; i >= 0; i--){
			swap(array, 0, i);
			maxHeapFixDown(array, 0, i);
		}
	}
	
	/**
	 * �Դ�����У�i�ڵ�������µ���
	 * @param array
	 * @param i
	 */
	private void maxHeapFixDown(int array[], int i, int n){
		int temp = array[i];
		int j = 2 * i + 1;
		while(j < n && i < n){
			//ѡ���ӽڵ�������
			if(j + 1 < n && array[j] < array[j + 1])
				j = j + 1;
			if(array[j] < temp)
				break;
			//�ӽڵ������������ƶ�
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
