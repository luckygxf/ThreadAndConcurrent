package com.gxf.knifeoffer;

/**
 * ��ָoffer
 * ������14
 * ����������������ż����λ��
 * ǰ����Ϊ����
 * ��벿��Ϊż��
 * @author GXF
 *
 */
public class ReverseOddEven {

	public static void main(String[] args) {
		ReverseOddEven reverseOddEven = new ReverseOddEven();
		int array[] = {9,6,5,3,6,9,4,2,4,5};
		reverseOddEven.reverseOddEven(array);

		for(int i = 0; i < array.length; i++)
			System.out.print(array[i] + " ");
		System.out.println();
	}
	
	public void reverseOddEven(int array[]){
		if(array == null || array.length == 0|| array.length == 1)
			return;
		int head = 0;
		int tail = array.length - 1;
		
		while(head < tail){
			//�ҳ�ǰ�벿�ֵ�һ��ż��
			while(array[head++] % 2 != 0);
			//�ҳ����ε�һ������
			while(array[tail--] % 2 != 1);
			int temp = array[--head];
			array[head] = array[++tail];
			array[tail] = temp;
		}//while
	}

}
