package com.gxf.knifeoffer;

/**
 * 剑指offer
 * 面试题37
 * 两个链表第一个公共节点
 * @author GXF
 *
 */
public class FindFirstCommonNode {

	public static void main(String[] args) {
		ListNode head1 = new ListNode(1);
		ListNode node = new ListNode(2);
		ListNode node1 = new ListNode(3);
		ListNode node2 = new ListNode(4);
		ListNode node3 = new ListNode(5);
		
		head1.next = node;
		node.next = node1;
		node1.next = node2;
		node2.next = node3;
		
		ListNode head2 = new ListNode(6);
		ListNode node4 = new ListNode(7);
		head2.next = node4;
		node4.next = node2;
		
		FindFirstCommonNode findFirstCommonNode = new FindFirstCommonNode();
		findFirstCommonNode.showList(head1);
		findFirstCommonNode.showList(head2);
		
		ListNode commonNode = findFirstCommonNode.findFirstCommonNode(head1, head2);
		System.out.println("commonNode.data = " + commonNode.data);

	}
	
	public ListNode findFirstCommonNode(ListNode one, ListNode two){
		int lengthOfListOne = getLinkListLength(one);
		int lengthOfListTwo = getLinkListLength(two);
		
		int distance = lengthOfListOne - lengthOfListTwo;
		
		ListNode firstStartNode = distance > 0 ? one : two;
		ListNode secondeStartNode = firstStartNode == one ? two : one;
		
		for(int i = 0; i < distance; i++){
			firstStartNode = firstStartNode.next;
		}//for
		
		while(firstStartNode != null && secondeStartNode != null && firstStartNode != secondeStartNode){
			firstStartNode = firstStartNode.next;
			secondeStartNode = secondeStartNode.next;
		}
		
		return firstStartNode;
		
	}
	
	private int getLinkListLength(ListNode head){
		int length = 0;
		while(head != null){
			length++;
			head = head.next;
		}//while
		
		return length;
	}
	
	private void showList(ListNode head){
		while(head != null){
			System.out.print(head.data + " ");
			head = head.next;
		}//while
		
		System.out.println();
	}

}
