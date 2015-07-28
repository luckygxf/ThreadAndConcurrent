package com.gxf.practice;

import java.util.HashMap;
import java.util.Map;

import com.gxf.util.Node;

/**
 * Ѹ��УУ�б��Ա����
 * ����difference()������⼯��A��B�Ĳ
 * ������A={5,10,20,15,25,30}������B={5,15,35,25}����ɼ����A={10,20,30}
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
	 * �������ϵĲ
	 * @param head1
	 * @param head2
	 */
	public Node difference(Node head1, Node head2){
		//�߽��������
		if(head1 == null || head2 == null)
			return head1;
		//��¼head2�����нڵ�
		Map<Integer, Integer> numsOfHead2 = new HashMap<Integer, Integer>();
		while(head2 != null){
			if(numsOfHead2.get(head2.key) == null){
				numsOfHead2.put(head2.key, 1);
				head2 = head2.next;
			}//if
		}//while
		
		//����һ������ͷ���
		Node dummyHead = new Node(0);
		dummyHead.next = head1;
		
		Node preNode = dummyHead;
		while(head1 != null){
			//��B�г��ֹ�
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
