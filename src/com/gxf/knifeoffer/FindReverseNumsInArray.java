package com.gxf.knifeoffer;

/**
 * 剑指offer
 * 面试题36
 * 数组中的逆序对
 * @author GXF
 *
 */
public class FindReverseNumsInArray {

	public static void main(String[] args) {
		int array[] = {7,5,6,4};
		FindReverseNumsInArray findReverseNumsInArray = new FindReverseNumsInArray();
		int result =findReverseNumsInArray.getReverseNums(array);
		System.out.println("result = " + result);
	}
	
	public int getReverseNums(int array[]){
		int result = 0;
		for(int i = 0; i < array.length; i++){
			for(int j = i + 1; j < array.length; j++){
				if(array[j] < array[i])
					result++;
			}//for
		}//for
		
		return result;
	}

}
