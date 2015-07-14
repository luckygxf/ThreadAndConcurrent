package com.gxf.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.gxf.util.Util;

//      4
//	  /   \
//   7     2
//  / \   / \
// 9   6 3   1

//BST
//	_______6______
//	/              \
//	___2__          ___8__
//	/      \        /      \
//	0      _4       7       9
//	  /  \
//	  3   5

public class Test {

	public static void main(String[] args) {
		Solution sol = new Solution();
		TreeNode root = new TreeNode(6);
		TreeNode node = new TreeNode(2);
		TreeNode node1 = new TreeNode(8);
		TreeNode node2 = new TreeNode(0); 
		TreeNode node3 = new TreeNode(4);
		TreeNode node4 = new TreeNode(7);
		TreeNode node5 = new TreeNode(9);
		TreeNode node6 = new TreeNode(3);
		TreeNode node7 = new TreeNode(5);
		
		root.left = node;
		root.right = node1;
		
		node.left = node2;		
		node.right = node3;
		
		node1.left = node4;
		node1.right = node5;
		
		node3.left = node6;
		node3.right = node7;
		
		preOrder(root);
		
		System.out.println();
		
		levelPreOrder(root);
		
		TreeNode result = sol.lowestCommonAncestor(root, node, node3);
		System.out.println("common ancestor'val = " + result.val);
	}
	

	
	public static void showLinkList(ListNode head){
		while(head != null){
			System.out.print(head.val + " ");
			head = head.next;
		}//while
		
		System.out.println();
	}
	
	public static void levelPreOrder(TreeNode root){
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		while(!queue.isEmpty()){
			TreeNode temp = queue.remove();
			System.out.print(temp.val + " ");
			if(temp.left != null)
				queue.add(temp.left);
			if(temp.right != null)
				queue.add(temp.right);
		}//while
		System.out.println();
	}
	
	public static void preOrder(TreeNode root){
		if(root != null){
			System.out.print(root.val + " ");
			preOrder(root.left);
			preOrder(root.right);
		}
	}
}
