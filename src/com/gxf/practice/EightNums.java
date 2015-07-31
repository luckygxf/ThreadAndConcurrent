package com.gxf.practice;

import java.util.HashSet;
import java.util.Set;

import com.gxf.util.Util;

/**
 * 八数码问题
 * @author GXF
 *
 */
public class EightNums {
	private boolean isFinished = false;
	private Set<String> statusSet = new HashSet<String>();
	private int endStatus[][] = {{1,2,3},{4,5,6},{7,8,0}};
	
	public static void main(String[] args) {
		int array[][] = {{2,4,3},{5,6,8},{7,1,0}};
		
		Util.showTwoDimensionArray(array);
		
		EightNums eightNums = new EightNums();
		eightNums.adustEightNums(array, 2, 2);
		
		Util.showTwoDimensionArray(array);
	}
	
	/**
	 * 判断是否结束
	 * @param array
	 * @return
	 */
	private boolean validIsFinished(int array[][]){
		int item = 1;
		for(int i = 0; i < array.length; i++){
			for(int j = 0; j < array[0].length; j++){
				if(i != array.length - 1 && j != array[0].length - 1 && array[i][j] != item)
					return false;
				item++;
			}//if
		}//for
		if(array[array.length - 1][array[0].length - 1] != 0)
			return false;
		return true;
	}
	
	/**
	 * 调整八数码
	 * @param array
	 */
	public void adustEightNums(int array[][], int i, int j){		
		//当前正确的数字个数
		int startCorrectCount = countCorrectNum(array);
		//左
		if(j - 1 >= 0 && !isFinished){
			swap(array, i, j, i, j - 1);
			int countAfterSwap = countCorrectNum(array);
			
			if(countAfterSwap <= startCorrectCount)
				swap(array, i, j, i, j - 1);
			else{
				if(validIsFinished(array))
				{
					isFinished = true;
					return;
				}
				//前面是否已经遍历过
				if(isStatusExist(array))
					return;
				adustEightNums(array, i, j);
			}
			
		}
		//上
		if(i - 1 >= 0 && !isFinished){
			swap(array, i, j, i - 1, j);
			int countAfterSwap = countCorrectNum(array);
			if(countAfterSwap <= startCorrectCount)
				swap(array, i, j, i - 1, j);
			else{
				if(validIsFinished(array))
				{
					isFinished = true;
					return;
				}
				//前面是否已经遍历过
				if(isStatusExist(array))
					return;
				adustEightNums(array, i, j);
			}
			
		}
		//下
		if(i + 1 <= array.length - 1 && !isFinished){
			swap(array, i, j, i + 1, j);
			int countAfterSwap = countCorrectNum(array);
			if(countAfterSwap <= startCorrectCount)
				swap(array, i, j, i + 1, j);
			else{
				if(validIsFinished(array))
				{
					isFinished = true;
					return;
				}
				//前面是否已经遍历过
				if(isStatusExist(array))
					return;
				adustEightNums(array, i, j);
			}
			
		}
		//右
		if(j + 1 <= array[0].length - 1  && !isFinished){			
			swap(array, i, j, i, j + 1);
			int countAfterSwap = countCorrectNum(array);
			if(countAfterSwap <= startCorrectCount)
				swap(array, i, j, i, j + 1);
			else{
				if(validIsFinished(array))
				{
					isFinished = true;
					return;
				}
				//前面是否已经遍历过
				if(isStatusExist(array))
					return;
				adustEightNums(array, i, j);
			}
			
		}
		
		//存放当前状态
		putStatus(array);

	}
	
	/**
	 * 交换数组元素
	 * @param array
	 * @param src_x
	 * @param src_y
	 * @param dst_x
	 * @param dst_y
	 */
	private void swap(int array[][], int src_x, int src_y, int dst_x, int dst_y){
		int temp = array[src_x][src_y];
		array[src_x][src_y] = array[dst_x][dst_y];
		array[dst_x][dst_y] = temp;
	}
	
	/**
	 * 判断搜索结果是否出现过
	 * @param array
	 * @return
	 */
	public boolean  isStatusExist(int array[][])
	{
		String result = "";
		for(int i = 0; i < array.length; i++){
			for(int j = 0; j < array[0].length; j++)
				result += array[i][j];
		}
//		System.out.println("result = " + result);

		if(statusSet.contains(result))
			return true;
		return false;
	}
	
	/**
	 * 存放已经遍历的状态
	 * @param array
	 */
	private void putStatus(int array[][]){
		String result = "";
		for(int i = 0; i < array.length; i++){
			for(int j = 0; j < array[0].length; j++)
				result += array[i][j];
		}
//		System.out.println("status = " + result);
		statusSet.add(result);
	}
	
	/**
	 * 计算当前已经放正确的数字
	 * @param curStatus
	 * @return
	 */
	private int countCorrectNum(int curStatus[][]){
		int count = 0;
		for(int i = 0; i < curStatus.length; i++)
			for(int j = 0; j < curStatus[0].length; j++){
				if(i != curStatus.length - 1 && j != curStatus.length - 1 && curStatus[i][j] == endStatus[i][j])
					count++;
			}
		
		return count;
	}

}
