package com.gxf.knifeoffer;

/**
 * 剑指offer
 * 面试题12
 * 输出1-n位最大数之间所有数
 * 这里主要考虑数字移除问题
 * @author GXF
 *
 */
public class PrintOneToNMax {
	
	/**
	 * 对外的公共接口
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
	 * 打印完成
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
	 * 输出数字
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
		//换行
		System.out.println();
	}
	
	/**
	 * 增加数字
	 * @param array
	 */
	private void increament(int array[]){
		array[0] += 1;
		
		//有进位产生
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
