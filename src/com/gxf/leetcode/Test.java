package com.gxf.leetcode;

import java.util.List;

import com.gxf.util.Util;

//      4
//	  /   \
//   7     2
//  / \   / \
// 9   6 3   1

public class Test {

	public static void main(String[] args) {
		Solution sol = new Solution();
		ListNode head = new ListNode(1);
		ListNode node = new ListNode(2);
		ListNode node1 = new ListNode(1);
		
		head.next = node;
		node.next = node1;
		showLinkList(head);
		System.out.println(sol.isPalindrome(head));
		showLinkList(head);
	}
	

	
	public static void showLinkList(ListNode head){
		while(head != null){
			System.out.print(head.val + " ");
			head = head.next;
		}//while
		
		System.out.println();
	}
}
