package com.gxf.practice;

import java.util.Scanner;

/**
 * ���鼯��ʵ��
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
			//��ʼ���ڵ�
			for(int i = 1; i <= n; i++)
				bin[i] = i;
			int numsOfPath;
			numsOfPath = scanner.nextInt();
			//���ӵ�
			for(int i = 1; i <= numsOfPath; i++){
				int x;
				int y;
				x = scanner.nextInt();
				y = scanner.nextInt();
				union(x, y);
			}//for
			
			int count = -1;
			//�ҳ�û�����ӵĵ�
			for(int i = 1; i <= n; i++){
				if(bin[i] == i)
					count++;
			}//for
			
			System.out.println(count);
			
		}//while
		
		scanner.close();

	}
	
	/**
	 * ���Ҽ��ϴ���Ԫ��
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
	 * ������Ԫ����������
	 * @param i
	 * @param j
	 */
	public static void union(int i, int j){
		int pId = find(i);
		int qId= find(j);
		if(pId == qId)
			return;				//�����ڵ��Ѿ����Ӻ�
		//�������ڵ����Ӻ�
		bin[pId] = qId;
	}
	
	
	/**
	 * �ж��������Ƿ���ͨ
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
