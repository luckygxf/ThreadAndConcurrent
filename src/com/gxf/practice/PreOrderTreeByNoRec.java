package com.gxf.practice;

import java.util.Stack;

/**
 * ǰ������ǵݹ�ʵ��
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
	 * ǰ�����������,�ǵݹ�ʵ��
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
	 * ǰ������ݹ�ʵ��
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
