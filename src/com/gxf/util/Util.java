package com.gxf.util;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

import com.gxf.leetcode.TreeNode;


public class Util {
	
	/**
	 * �������
	 * @param root
	 */
	public static void levelViewTree(TreeNode root){
		Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
		if(root == null)
			return;
		nodeQueue.add(root);
		
		//���в���
		while(!nodeQueue.isEmpty()){
			//Ԫ�س���
			TreeNode temp = nodeQueue.poll();
			System.out.print(temp.val + " ");
			if(temp.left != null)
				nodeQueue.add(temp.left);
			if(temp.right != null)
				nodeQueue.add(temp.right);
		}//while
		
		
	}
	
	/**
	 * �������[0,100]
	 * @return
	 */
	public static int generateRandomInt(){
		Date date = new Date();
		long randomSeed = date.getTime();
		Random random = new Random(randomSeed);
		
		return random.nextInt(6);
	}
	
	/**
	 * �����������
	 * @param array
	 */
	public static void showIntArray(int array[]){
		for(int i = 0; i < array.length; i++){
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
	
	/**
	 * ��ʾ�����б�������
	 * @param listOfInteger
	 */
	public static void showIntegerOfList(List<Integer> listOfInteger){
		for(int i = 0; i < listOfInteger.size(); i++)
			System.out.print(listOfInteger.get(i) + " ");
		System.out.println();
	}
	
	/**
	 * ���Դ���
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String args[]) throws InterruptedException{
		while(true){
			generateRandomInt();
			Thread.sleep(1000);
		}
	}
	
	/**
	 * ����ַ���������
	 * @param array
	 */
	public static void showCharArray(char array[]){
		for(int i = 0; i < array.length; i++)	
			System.out.print(array[i] + " ");
		System.out.println();
	}
	
	/**
	 * �ַ���ת���ɶ�ά����
	 * @param string
	 * @return
	 */
	public static int[][] stringToArray(String string, int m, int n){
		int stringIndex = 0;
		int result[][] = new int[m][n];
		
		for(int i = 0; i < m; i++){
			for(int j = 0; j < n; j++){
				result[i][j] = string.charAt(stringIndex++) - '0';
			}//for
		}//for
		
		return result;
	}
	
	/**
	 * ��ʾ��ά�����е�����
	 * @param array
	 */
	public static void showTwoDimensionArray(int array[][]){
		for(int i = 0; i < array.length; i++){
			for(int j = 0; j < array[0].length; j++)
				System.out.print(array[i][j] + " ");
			System.out.println();
		}//for
		System.out.println();
	}
}




