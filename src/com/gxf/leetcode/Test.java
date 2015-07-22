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
		int nums[] = {1,2,3,4};
		int result[] = sol.productExceptSelf(nums);
		Util.showIntArray(result);
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
