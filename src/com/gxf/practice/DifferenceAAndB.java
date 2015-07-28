package com.gxf.practice;

import java.util.HashMap;
import java.util.Map;

import com.gxf.util.Node;

/**
 * 迅雷校校招笔试编程题
 * 函数difference()用于求解集合A与B的差集
 * 若集合A={5,10,20,15,25,30}，集合B={5,15,35,25}，完成计算后A={10,20,30}
 * @author GXF
 *
 */
public class DifferenceAAndB {

	public static void main(String[] args) {
		DifferenceAAndB differenceAAndB = new DifferenceAAndB();
		int array1[] = {5,10,20,15,25,30};
		int array2[] = {5,15,35,25};
		
		Node head1 = Node.arrayToLinkedList(array1);
		Node head2 = Node.arrayToLinkedList(array2);
		
		Node.showLinkList(head1);
		System.out.println();
		Node.showLinkList(head2);
		System.out.println();
		
		Node result = differenceAAndB.difference(head1, head2);
		
		Node.showLinkList(result);
	}
	
	/**
	 * 两个集合的差集
	 * @param head1
	 * @param head2
	 */
	public Node difference(Node head1, Node head2){
		//边界条件检查
		if(head1 == null || head2 == null)
			return head1;
		//记录head2中所有节点
		Map<Integer, Integer> numsOfHead2 = new HashMap<Integer, Integer>();
		while(head2 != null){
			if(numsOfHead2.get(head2.key) == null){
				numsOfHead2.put(head2.key, 1);
				head2 = head2.next;
			}//if
		}//while
		
		//构造一个虚拟头结点
		Node dummyHead = new Node(0);
		dummyHead.next = head1;
		
		Node preNode = dummyHead;
		while(head1 != null){
			//在B中出现过
			if(numsOfHead2.get(head1.key) != null){
				preNode.next = head1.next;
				head1 = preNode.next;
				continue;
			}//if
			head1 = head1.next;
			preNode = preNode.next;
		}//while
		
		return dummyHead.next;
	}

}
