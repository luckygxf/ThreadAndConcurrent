package com.gxf.oj;

import java.util.LinkedList;
import java.util.Queue;

import com.gxf.util.TreeNode;

public class FindValInTree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(0);
		TreeNode left = new TreeNode(1);
		TreeNode right = new TreeNode(2);
		
		root.left = left;
		root.right = right;
		
		FindValInTree findValInTree = new FindValInTree();
		int ans = findValInTree.find(root, 3);
		
		System.out.println("ans = " + ans);

	}
	
	int find(TreeNode root, int val){
		int deep = 0;
		if(root == null)
			return -1;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		boolean found = false;
		while(!queue.isEmpty()){
			Queue<TreeNode> cur = new LinkedList<TreeNode>();
			while(!queue.isEmpty()){
				TreeNode temp = queue.poll();
				if(temp.val == val){
					found = true;
					break;
				}
				if(temp.left != null)
					cur.add(temp.left);
				if(temp.right != null)
					cur.add(temp.right);
			}//while
			deep++;
			while(!cur.isEmpty()){
				queue.add(cur.poll());
			}//while
			
		}//while
		
		if(!found)
			return -1;
		return deep;
		
	}
}
