package com.gxf.util;

/**
 * ����ڵ�
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
	 * ����ת��������
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
	 * �����������
	 * @param head
	 */
	public static void showLinkList(Node head){
		while(head != null){
			System.out.print(head.key + " ");
			head = head.next;
		}
	}
}
