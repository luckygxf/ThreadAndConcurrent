package com.gxf.knifeoffer;

/**
 * ��ָoffer
 * ������12
 * ���1-nλ�����֮��������
 * ������Ҫ���������Ƴ�����
 * @author GXF
 *
 */
public class PrintOneToNMax {
	
	/**
	 * ����Ĺ����ӿ�
	 * @param n
	 */
	public void printOneToNMax(int n){
		int array[] = new int[n];
		
		while(!isFinished(array)){
			increament(array);
			print(array);
		}
	}
	
	/**
	 * ��ӡ���
	 * @param array
	 * @return
	 */
	private boolean isFinished(int array[]){
		for(int i = 0; i < array.length; i++){
			if(array[i] != 9){
				return false;
			}
		}//for
		return true;
	}
	
	/**
	 * �������
	 * @param array
	 */
	private void print(int array[]){
		int printStart = 0;
		for(int i = array.length - 1; i >= 0; i--){
			if(array[i] != 0)
			{
				printStart = i;
				break;
			}//if
		}//for
		
		for(int i = printStart; i >= 0; i--){
			System.out.print(array[i]);
		}//for
		//����
		System.out.println();
	}
	
	/**
	 * ��������
	 * @param array
	 */
	private void increament(int array[]){
		array[0] += 1;
		
		//�н�λ����
		if(array[0] >= 10){
			int carry = 0;
			for(int i = 0; i < array.length; i++){
				array[i] += carry;
				carry = array[i] / 10;
				array[i] %= 10;
			}//for
		}//if
	}
	
	public static void main(String args[]){
		PrintOneToNMax printOneToNMax = new PrintOneToNMax();
		int n = 3;
		printOneToNMax.printOneToNMax(n);
	}
}
