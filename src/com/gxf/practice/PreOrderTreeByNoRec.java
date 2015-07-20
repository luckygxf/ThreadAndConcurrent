package com.gxf.practice;

import java.util.Stack;

/**
 * 前序遍历非递归实现
 * @author GXF
 *
 */
public class PreOrderTreeByNoRec {

	public static void main(String[] args) {
		PreOrderTreeByNoRec preOrderTreeByNoRec = new PreOrderTreeByNoRec();
		TreeNode root = TreeNode.createTree();
		preOrderTreeByNoRec.preOrderByRecursive(root);
		System.out.println();
		preOrderTreeByNoRec.preOrderByNoRec(root);

	}
	
	/**
	 * 前序遍历二叉树,非递归实现
	 * @param root
	 */
	public void preOrderByNoRec(TreeNode root){
		if(root == null)
			return;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		System.out.print(root.val + " ");
		stack.push(root);
		
		TreeNode curPoint = root.left;
		
		while(!stack.isEmpty() || curPoint != null){
			if(curPoint != null){
				System.out.print(curPoint.val + " ");
				stack.push(curPoint);
				curPoint = curPoint.left;
			}//if
			
			curPoint = stack.pop().right;
		}
		
		System.out.println();
		
	}
	
	/**
	 * 前序遍历递归实现
	 * @param root
	 */
	public void preOrderByRecursive(TreeNode root){
		if(root != null){
			System.out.print(root.val + " ");
			preOrderByRecursive(root.left);
			preOrderByRecursive(root.right);
		}
		
	
	}
	
	

}
