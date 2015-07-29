package com.gxf.practice;

import java.util.Date;
import java.util.Random;

import com.gxf.util.Util;

/**
 * ģ��ϴ��
 * ϴ���㷨��ʵ��
 * ���ȡ�±�
 * ���Ʒ�Ϊ�������֣�0-iΪϴ�õ���,i+1 - 53Ϊû��ϴ����
 * i+1 - 53֮�����һ�������index������i+1��index����
 * ʱ�临�Ӷ�O(N)���ռ临�Ӷ�O��1��
 * @author GXF
 *
 */
public class MixUpCards {

	public static void main(String[] args) {
		MixUpCards mixUpCard = new MixUpCards();
		int array[] = new int[54];
		for(int i = 0; i < array.length; i++)
			array[i] = i;
		Util.showIntArray(array);
		mixUpCard.mixupCards(array);
		Util.showIntArray(array);
	}
	
	/**
	 * ϴ��
	 * ʱ�临�Ӷ�O(N)���ռ临�Ӷ�O��1��
	 * @param array
	 */
	public void mixupCards(int array[]){
		Random random = new Random(new Date().getTime());
		
		for(int i = array.length - 1; i > 0; i--){
			int index = random.nextInt(i);
			swap(array, i, index);
		}
	}
	
	/**
	 * ��������Ԫ��
	 * @param array
	 * @param i
	 * @param j
	 */
	public void swap(int array[], int i, int j){
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

}
