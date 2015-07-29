package com.gxf.practice;

import com.gxf.util.Util;

/**���Ͼ��������
 * ���Ͼ��󣺴����ҵ��������ϵ��µ���
 * ����һ�����Ƿ��ھ�����
 * �ڷ���true,���򷵻�false
 * @author GXF
 *
 */
public class YongRec {

	public static void main(String[] args) {
		int  array[][] = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
		Util.showTwoDimensionArray(array);
		YongRec yongRec = new YongRec();
		
		boolean result = yongRec.findNumInArray(array, 5);
		System.out.println("result = " + result);
	} 
	
	/**
	 * �����õĶ�λ��
	 * ʱ�临�Ӷ�ΪO(m + n)
	 * @param array
	 * @param num
	 * @return
	 */
	public boolean findNumInArray(int array[][], int num){
		if(array == null || array.length == 0)
			return false;
		int i = 0;
		int j = array[0].length - 1;
		while(true){
			if(array[i][j] == num)
				return true;
			else if(j > 0 && array[i][j] > num)
				j--;
			else if(i < array.length - 1 && array[i][j] < num)
				i++;
			else 
				return false;
		}//while
	}	

}
