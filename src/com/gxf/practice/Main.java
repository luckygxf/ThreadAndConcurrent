package com.gxf.practice;

import java.util.Scanner;

/**
 * 并查集的实现
 * @author GXF
 *
 */
public class Main {
	private static final int SIZE = 1010;
	private static int bin[] = new int[SIZE];

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = 0;
		while(scanner.hasNextInt()){
			n = scanner.nextInt();
			if(n == 0)
				break;
			//初始化节点
			for(int i = 1; i <= n; i++)
				bin[i] = i;
			int numsOfPath;
			numsOfPath = scanner.nextInt();
			//连接点
			for(int i = 1; i <= numsOfPath; i++){
				int x;
				int y;
				x = scanner.nextInt();
				y = scanner.nextInt();
				union(x, y);
			}//for
			
			int count = -1;
			//找出没有连接的点
			for(int i = 1; i <= n; i++){
				if(bin[i] == i)
					count++;
			}//for
			
			System.out.println(count);
			
		}//while
		
		scanner.close();

	}
	
	/**
	 * 查找集合代表元素
	 * @param i
	 * @return
	 */
	public static int find(int i){
		int r = i;
		while(bin[r] != r){
			r = bin[r];
		}//while
		
		return r;
	}
	
	/**
	 * 将两个元素连接起来
	 * @param i
	 * @param j
	 */
	public static void union(int i, int j){
		int pId = find(i);
		int qId= find(j);
		if(pId == qId)
			return;				//两个节点已经连接好
		//将两个节点连接好
		bin[pId] = qId;
	}
	
	
	/**
	 * 判断两个点是否联通
	 * @param i
	 * @param j
	 * @return
	 */
	public boolean connect(int i, int j){
		int pId = find(i);
		int qId = find(j);
		
		if(pId == qId)
			return true;
		return false;
	}
}
