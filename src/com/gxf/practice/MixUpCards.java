package com.gxf.practice;

import java.util.Date;
import java.util.Random;

import com.gxf.util.Util;

/**
 * 模拟洗牌
 * 洗牌算法的实现
 * 随机取下标
 * 将牌分为两个部分，0-i为洗好的牌,i+1 - 53为没有洗的牌
 * i+1 - 53之间产生一个随机数index，交换i+1和index的牌
 * 时间复杂度O(N)，空间复杂度O（1）
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
	 * 洗牌
	 * 时间复杂度O(N)，空间复杂度O（1）
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
	 * 交换数组元素
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
