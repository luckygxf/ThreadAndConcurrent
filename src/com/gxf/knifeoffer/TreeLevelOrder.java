package com.gxf.knifeoffer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 剑指offer
 * 面试题23
 * 二叉树的层序遍历
 * @author GXF
 *
 */
public class TreeLevelOrder {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode node1 = new TreeNode(2);
		TreeNode node2 = new TreeNode(3);
		TreeNode node3 = new TreeNode(4);
		TreeNode node4 = new TreeNode(5);
		
		root.left = node1;
		root.right = node2;
		node1.left = node3;
		node1.right = node4;
		
		TreeLevelOrder treeLevelOrder = new TreeLevelOrder();
		treeLevelOrder.LevelOrderTree(root);
		
		treeLevelOrder.preOrder(root);

	}
	
	public void LevelOrderTree(TreeNode root){
		if(root == null)
			return;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		while(!queue.isEmpty()){
			TreeNode tempRoot = queue.remove();
			System.out.print(tempRoot.val + " ");
			if(tempRoot.left != null)
				queue.add(tempRoot.left);
			if(tempRoot.right != null)
				queue.add(tempRoot.right);
		}//while
		System.out.println();
	}
	
	/**
	 * 前序遍历
	 * @param root
	 */
	public void preOrder(TreeNode root){
		if(root != null){
			System.out.print(root.val + " ");
			preOrder(root.left);
			preOrder(root.right);
		}

	}
}
class TreeNode{
	int val;
	TreeNode(int val){
		this.val = val;
	}
	
	TreeNode left;
	TreeNode right;
}
