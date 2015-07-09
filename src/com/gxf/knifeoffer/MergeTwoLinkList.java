package com.gxf.knifeoffer;

/**
 * 剑指offer
 * 面试题17
 * 合并两个有序的链表
 * 这里用递归实现
 * 很漂亮 
 * @author GXF
 *
 */
public class MergeTwoLinkList {

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode node = new ListNode(2);
		ListNode node1 = new ListNode(3);
		
		head.next = node;
		node.next = node1;
		
		ListNode head1 = new ListNode(4);
		ListNode node2 = new ListNode(5);
		ListNode node3 = new ListNode(6);
		
		head1.next = node2;
		node2.next = node3;
		
		
		MergeTwoLinkList mergeTwoLinkList = new MergeTwoLinkList();
		mergeTwoLinkList.showList(head);
		mergeTwoLinkList.showList(head1);
		
		ListNode newHead = mergeTwoLinkList.mergeTwoLinkList(head, head1);
		mergeTwoLinkList.showList(newHead);
		
	}
	
	public ListNode mergeTwoLinkList(ListNode head1, ListNode head2){
		if(head1 == null)
			return head2;
		if(head2 == null)
			return head1;
		ListNode newHead = null;
		
		if(head1.data < head2.data){
			newHead = mergeTwoLinkList(head1.next, head2);
			head1.next = newHead;
			return head1;
		}
		else
		{
			newHead = mergeTwoLinkList(head1, head2.next);
			head2.next = newHead;
			return head2;
		}
	}
	
	public void showList(ListNode head){
		while(head != null){
			System.out.print(head.data + " ");
			head = head.next;
		}//while
		System.out.println();
	}
}
