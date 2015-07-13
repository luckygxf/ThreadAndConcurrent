package com.gxf.knifeoffer;

/**
 * ��ָoffer
 * ������41
 * �����������в����������ĺ�Ϊһָ����
 * ���ź���������п����ý�ָoffer����ķ���
 * û���ĺ���Ŀ�����mapʵ�֣�ʱ�临�Ӷ�O(1)�ռ临�Ӷ�O��n��
 * @author GXF
 *
 */
public class FindTwoSum {

	public static void main(String[] args) {
		int array[] = {1,2,4,7,11,15};
		FindTwoSum findTwoSum = new FindTwoSum();
		int sum = 15;
		
		boolean result = findTwoSum.findTwoSum(array, sum);
		System.out.println("result = " + result);

	}
	/**
	 * ��������ĺ��������
	 * @param array
	 * @param sum
	 * @return
	 */
	public boolean findTwoSum(int array[], int sum){
		boolean found = false;
		int startPoint = 0;
		int endPoint = array.length - 1;
		if(array == null || array.length < 2)
			return false;
		
		while(startPoint < endPoint){
			if(sum == array[startPoint] + array[endPoint]){
				found = true;
				System.out.println("num1 = " + array[startPoint] + " num2 = " + array[endPoint]);
				break;
			}//if
			if(sum > array[startPoint] + array[endPoint])
				startPoint++;
			else
				endPoint--;
		}//while
		
		return found;
	}

}
