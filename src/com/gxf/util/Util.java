package com.gxf.util;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

import com.gxf.leetcode.TreeNode;


public class Util {
	
	/**
	 * 层序遍历
	 * @param root
	 */
	public static void levelViewTree(TreeNode root){
		Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
		if(root == null)
			return;
		nodeQueue.add(root);
		
		//队列不空
		while(!nodeQueue.isEmpty()){
			//元素出列
			TreeNode temp = nodeQueue.poll();
			System.out.print(temp.val + " ");
			if(temp.left != null)
				nodeQueue.add(temp.left);
			if(temp.right != null)
				nodeQueue.add(temp.right);
		}//while
		
		
	}
	
	/**
	 * 随机产生[0,100]
	 * @return
	 */
	public static int generateRandomInt(){
		Date date = new Date();
		long randomSeed = date.getTime();
		Random random = new Random(randomSeed);
		
		return random.nextInt(6);
	}
	
	/**
	 * 输出整型数组
	 * @param array
	 */
	public static void showInArray(int array[]){
		for(int i = 0; i < array.length; i++){
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
	
	/**
	 * 显示整型列表中内容
	 * @param listOfInteger
	 */
	public static void showIntegerOfList(List<Integer> listOfInteger){
		for(int i = 0; i < listOfInteger.size(); i++)
			System.out.print(listOfInteger.get(i) + " ");
		System.out.println();
	}
	
	/**
	 * 测试代码
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String args[]) throws InterruptedException{
		while(true){
			generateRandomInt();
			Thread.sleep(1000);
		}
	}
}


