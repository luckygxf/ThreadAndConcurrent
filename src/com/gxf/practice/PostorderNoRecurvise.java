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
	 * 递归进行后序遍历
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
	 * 后序遍历非递归实现
	 * @param root
	 */
	public void postorderByNoRecurvise(TreeNode root){
		if(root == null)
			return;
		//记录结点是否被访问过
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
