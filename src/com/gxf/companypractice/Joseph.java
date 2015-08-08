package com.gxf.companypractice;

/**
 * 华为上机题约瑟夫环问题
 * @author GXF
 *
 */
public class Joseph {

	public static void main(String[] args) {
		int array[] = {3, 1, 2, 4};
		int m = 7;
		solution(array, m);
	}
	
	private static void solution(int array[], int m){
		if(array == null || array.length == 0 )
			return;
		boolean visited[] = new boolean[array.length];
		int count = 0;											//出列元素个数
		int index = 0;
		while(count < array.length){
			int tempCount = 1;
			
			while(tempCount <= m - 1){
				index = (index + 1) % array.length;
				if(visited[index] == true)
				{
					continue;
				}
				
				tempCount++;
			}//while
			System.out.print(array[index] + " ");
			visited[index] = true;
			m = array[index];
			while(visited[index] != false)
				index = (index + 1) % array.length;
			count++;
		}
	}
}
