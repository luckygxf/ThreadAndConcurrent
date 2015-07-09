package com.gxf.knifeoffer;

/**
 * 剑指offer
 * 面试题13
 * @author GXF
 *
 */
public class DeleteListNode {

	public static void main(String[] args) {		
		ListNode head = new ListNode(1);
		ListNode node = new ListNode(2);
		ListNode node1 = new ListNode(3);
		ListNode node2 = new ListNode(4);
		ListNode node3 = new ListNode(5);
		
//		head.next = node;
//		node.next = node1;
//		node1.next = node2;
//		node2.next = node3;
		
		
		//DeleteListNode
		DeleteListNode deleteListNode = new DeleteListNode();
		deleteListNode.showList(head);
		deleteListNode.deleteNode(head, head);
		deleteListNode.showList(head);		
		
	}
	
	public ListNode deleteNode(ListNode head, ListNode node){
		//只有一个节点
		if(head == node && node.next == null)
			return null;
		//删除尾节点
		if(node.next == null){
			ListNode tempHead = head;
			while(tempHead.next != node)
				tempHead = tempHead.next;
			tempHead.next = null;
		}
		else{
			node.data = node.next.data;
			node.next = node.next.next;
		}
		
		
		return head;
	}
	
	public void showList(ListNode head){
		while(head != null){
			System.out.print(head.data + " ");
			head = head.next;
		}//while
		System.out.println();
	}
		
}
class ListNode{
	int data;
	ListNode next;
	
	public ListNode(int val){
		data = val;
	} 
}//class	
