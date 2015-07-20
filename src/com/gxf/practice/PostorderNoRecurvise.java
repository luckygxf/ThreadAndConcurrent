package com.gxf.practice;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class PostorderNoRecurvise {

	public static void main(String[] args) {
		TreeNode root = TreeNode.createTree();
		
		PostorderNoRecurvise postorderNoRecurvise = new PostorderNoRecurvise();
		postorderNoRecurvise.postorderByRecursive(root);
		System.out.println();
		postorderNoRecurvise.postorderByNoRecurvise(root);
	}
	
	/**
	 * �ݹ���к������
	 * @param root
	 */
	public void postorderByRecursive(TreeNode root){
		if(root != null){
			postorderByRecursive(root.left);
			postorderByRecursive(root.right);
			System.out.print(root.val + " ");
		}
	}
	
	/**
	 * ��������ǵݹ�ʵ��
	 * @param root
	 */
	public void postorderByNoRecurvise(TreeNode root){
		if(root == null)
			return;
		//��¼����Ƿ񱻷��ʹ�
		Map<TreeNode, Boolean> visited = new HashMap<TreeNode, Boolean>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		TreeNode curPoint = root.left;
		while(curPoint != null)
		{
			stack.push(curPoint);
			curPoint = curPoint.left;
		}
		while(!stack.isEmpty()){
			curPoint = stack.peek();
			if(curPoint.right == null || visited.get(curPoint.right) != null){
				curPoint = stack.pop();
				System.out.print(curPoint.val + " ");
				visited.put(curPoint, true);
			}
			else{
				curPoint = curPoint.right;
				while(curPoint != null){
					stack.push(curPoint);
					curPoint = curPoint.left;
				}
			}
		}
	}

}
