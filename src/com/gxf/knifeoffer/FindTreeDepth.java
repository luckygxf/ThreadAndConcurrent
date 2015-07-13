package com.gxf.knifeoffer;

/**
 * ��ָoffer
 * ������39
 * ����һ�ö����������
 * @author GXF
 *
 */
public class FindTreeDepth {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode node = new TreeNode(2);
		TreeNode node1 = new TreeNode(3);
		TreeNode node2 = new TreeNode(4);
		TreeNode node3 = new TreeNode(5);
		
		root.left = node;
		root.right = node1;
		node.left = node2;
		node1.left = node3;
		
		FindTreeDepth findTreeDepth = new FindTreeDepth();
		int depth = findTreeDepth.getBinaryTreeDepth(root);
		
		System.out.println("depth = " + depth);

	}
	
	/**
	 * �����õݹ�ʵ��
	 * @param root
	 * @return
	 */
	public int getBinaryTreeDepth(TreeNode root){
		if(root == null)
			return 0;
		int leftSubTreeDepth = getBinaryTreeDepth(root.left);
		int rightSubTreeDepth = getBinaryTreeDepth(root.right);
		
		return leftSubTreeDepth > rightSubTreeDepth ? leftSubTreeDepth + 1 : rightSubTreeDepth + 1;
	}

}
