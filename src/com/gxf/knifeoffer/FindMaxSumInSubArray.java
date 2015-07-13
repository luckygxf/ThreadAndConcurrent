package com.gxf.knifeoffer;

/**
 * ����һ������������Ԫ�ص�����
 * ��ָoffer
 * ������31
 * @author GXF
 *
 */
public class FindMaxSumInSubArray {

	public static void main(String[] args) {
		int array[] = {1,-2,3,10,-4,7,2,-5};
		FindMaxSumInSubArray findMaxSumInSubArray = new FindMaxSumInSubArray();
		int result = findMaxSumInSubArray.findMaxSumInSubArray(array);
		System.out.println("result = " + result);

	}
	
	/**
	 * ��̬�滮f(i)��ʾiǰ�������������ĺ�
	 * ���max[f(i)]
	 * f(i) = f(i - 1) + array[i] (f(i) > 0) ���� f(i) = array[i] (f(i) <= 0) 
	 * @param array
	 * @return
	 */
	public int findMaxSumInSubArray(int array[]){
		int max_result = Integer.MIN_VALUE;
		int max_cur = 0;
		
		for(int i = 0; i < array.length ; i++){
			if(max_cur <= 0)
				max_cur = array[i];
			else
				max_cur += array[i];
			if(max_cur > max_result)
				max_result = max_cur;
		}//for
		
		return max_result;
	}
}
