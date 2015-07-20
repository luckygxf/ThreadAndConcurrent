package com.gxf.practice;

import java.util.Stack;

/**
 * ��������ķǵݹ�ʵ��
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
	 * ��������ݹ�ʵ��
	 */
	public void inorderByRecursive(TreeNode root){
		if(root != null){
			inorderByRecursive(root.left);
			System.out.print(root.val + " ");
			inorderByRecursive(root.right);
		}
	}
	
	/**
	 * ��������ǵݹ�ʵ��
	 * @param root
	 */
	public void inorderByNoRecursive(TreeNode root){
		if(root == null)
			return;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		TreeNode curPoint = root.left;
		//��ʼ�������
		while(curPoint != null || !stack.isEmpty()){
			while(curPoint != null){
				stack.push(curPoint);
				curPoint = curPoint.left;
			}//while
			
			//���ʸ����
			curPoint = stack.pop();
			System.out.print(curPoint.val + " ");
			curPoint = curPoint.right;
		}
	}

}
