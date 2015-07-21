package com.gxf.practice;

import com.gxf.util.Util;

/**
 * 对字符数组进行排序
 * @author GXF
 * 里面的字符可能是a-z、A-Z、0-9.现在要求对数组进行排序，要求所有小写字符放在最前面，所有大写字符放在中间，所有数字放在最后。而且各部分内部分别有序
 *
 */
public class SortCharArray {

	public static void main(String[] args) {
		String string = "affasfasdf1656546sg6a5s4g6d4F4A65FD4A6F4AF65FAFfdf46f4s6f4a6fF6AD5F46E4F3";
		
		char array[] = string.toCharArray();
		Util.showCharArray(array);
		
		SortCharArray sortCharArray = new SortCharArray();
		sortCharArray.sort(array);
		
		Util.showCharArray(array);

	}
	
	private void sort(char array[]){
		if(array == null || array.length == 0)
			return;
		sort(array, 0, array.length - 1);
	}
	
	public void sort(char array[], int start, int end){
		if(start < end){
			int index = partion(array, start, end);
			sort(array, start, index - 1);
			sort(array, index + 1, end);
		}//if
	}
	
	/**
	 * 一次划分
	 * @param array
	 * @param start
	 * @param end
	 * @return
	 */
	private int partion(char array[], int start, int end){
		char key = array[start];
		while(start < end){
			while(start < end && !compare(array, key, end))
				end--;
			array[start] = array[end];
			while(start <end && compare(array, key, start))
				start++;
			array[end] = array[start];
		}//while
		array[start] = key;
		return start;
	}
	
	/**
	 * 比较char[position] 和 key大小
	 * key > char[position] true else false
	 * @param array
	 * @param key
	 * @param position
	 * @return
	 */
	private boolean compare(char array[], char key, int position){
		int keyVal = getCharIntVal(key);
		int positionVal = getCharIntVal(array[position]);
		
		return keyVal - positionVal > 0 ? true : false;
	}
	
	/**
	 * 获取字符对应的整型值
	 * @param charElement
	 * @return
	 */
	private int getCharIntVal(char charElement){
		if(charElement >= '0' && charElement <= '9')
			return charElement + 'Z';
		if(charElement >= 'a' && charElement <= 'z')
			return charElement - 'z';
		return (int)charElement;
	}
}
