package com.gxf.util;

/**
 * 链表节点
 * @author GXF
 *
 */
public class Node{
	public int key;
	public Node next;
	
	public Node(int key){
		this.key = key;
	}
	
	/**
	 * 数组转换成链表
	 * @param array
	 * @return
	 */
	public static Node arrayToLinkedList(int array[]){
		Node head = new Node(array[0]);
		if(array.length == 1)
			return head;
		Node nodePtr = head;
		for(int i = 1; i < array.length; i++){
			Node temp = new Node(array[i]);
			nodePtr.next = temp;
			nodePtr = temp;
		}//for
		
		return head;
	}
	
	/**
	 * 输出链表内容
	 * @param head
	 */
	public static void showLinkList(Node head){
		while(head != null){
			System.out.print(head.key + " ");
			head = head.next;
		}
	}
}
