package com.gxf.practice;

import java.util.LinkedList;
import java.util.Queue;

/**
 * ¶þ²æÊ÷²ãÐò±éÀú
 * @author GXF
 *
 */
public class LevelTravel {

	public static void main(String[] args) {
		TreeNode root = TreeNode.createTree();
		
		LevelTravel levelTravel = new LevelTravel();
		levelTravel.levelTravel(root);
	}
	
	/**
	 * ¶þ²æÊ÷²ãÐò±éÀú11
	 * @param root
	 */
	public void levelTravel(TreeNode root){
		if(root == null)
			return;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		while(!queue.isEmpty()){
			root = queue.poll();
			System.out.print(root.val + " ");
			if(root.left != null)
				queue.add(root.left);
			if(root.right != null)
				queue.add(root.right);
		}
	}
}
