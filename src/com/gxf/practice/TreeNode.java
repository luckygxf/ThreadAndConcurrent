package com.gxf.practice;

public class TreeNode {
	public TreeNode left;
	public TreeNode right;
	public int val;
	
	public TreeNode(int val) {
		this.val = val;
	}
	
	/**
	 * 搞一棵二叉树出来
	 * 					1
	 * 				   /  \
	 * 				  2    3
	 *                 \  / \
	 *                  4 5  6
	 * @return
	 */
	public static TreeNode createTree(){
		TreeNode root = new TreeNode(1);
		TreeNode node1 = new TreeNode(2);
		TreeNode node2 = new TreeNode(3);
		TreeNode node3 = new TreeNode(4);
		TreeNode node4 = new TreeNode(5);
		TreeNode node5 = new TreeNode(6);
		
		root.left = node1;
		root.right = node2;
		
		node1.right = node3;
		node2.left = node4;
		node2.right = node5;
		
		return root;
	}
}
