package com.gxf.practice;

import java.util.Stack;

/**
 * 中序遍历的非递归实现
 * @author GXF
 *
 */
public class InorderTreeByNoRecursive {

	public static void main(String[] args) {
		InorderTreeByNoRecursive inorderTreeByNoRecursive = new InorderTreeByNoRecursive();
		TreeNode root = TreeNode.createTree();
		
		inorderTreeByNoRecursive.inorderByRecursive(root);
		System.out.println();
		inorderTreeByNoRecursive.inorderByNoRecursive(root);
	}
	
	/**
	 * 中序遍历递归实现
	 */
	public void inorderByRecursive(TreeNode root){
		if(root != null){
			inorderByRecursive(root.left);
			System.out.print(root.val + " ");
			inorderByRecursive(root.right);
		}
	}
	
	/**
	 * 中序遍历非递归实现
	 * @param root
	 */
	public void inorderByNoRecursive(TreeNode root){
		if(root == null)
			return;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		TreeNode curPoint = root.left;
		//开始中序遍历
		while(curPoint != null || !stack.isEmpty()){
			while(curPoint != null){
				stack.push(curPoint);
				curPoint = curPoint.left;
			}//while
			
			//访问根结点
			curPoint = stack.pop();
			System.out.print(curPoint.val + " ");
			curPoint = curPoint.right;
		}
	}

}
