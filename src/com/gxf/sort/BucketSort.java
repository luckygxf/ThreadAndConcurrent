package com.gxf.sort;

import com.gxf.util.Node;
import com.gxf.util.Util;

/**
 * Ͱ����
 * @author GXF
 *
 */
public class BucketSort {

	public static void main(String[] args) {
		BucketSort bucketSort = new BucketSort();
		int nums[]={49,38,65,97,76,13,27,49};
		Util.showIntArray(nums);
		bucketSort.bucketSort(nums);
		Util.showIntArray(nums);
	}
	
	/**
	 * Ͱ����
	 * @param nums
	 */
	public void bucketSort(int nums[]){
		//���е�Ͱ
		Node bucketTable[] = new Node[10];
		for(int i = 0; i < bucketTable.length; i++){
			bucketTable[i] = new Node(0);
		}//for
		
		//����Ͱ����
		for(int i = 0; i < nums.length; i++){
			Node nodeToInsert = new Node(nums[i]);
			//����Ͱ��ţ�����
			int bucketIndex = nums[i] / 10;
			//�����Ӧ��ͰΪ�գ�ֱ�����
			if(bucketTable[bucketIndex].key == 0)
			{
				bucketTable[bucketIndex].next = nodeToInsert;
				bucketTable[bucketIndex].key++;
			}//if
			else{							
				Node head = bucketTable[bucketIndex];
				while(head.next != null && head.next.key < nums[i])
					head = head.next;
				nodeToInsert.next = head.next;
				head.next = nodeToInsert;
				bucketTable[bucketIndex].key++;
			}//else
		}//for
		
		//��Ͱ�е����ݷŵ�ԭ������
		int arrayIndex = 0;
		for(int i = 0; i < bucketTable.length; i++){
			if(bucketTable[i].key != 0){
				Node head = bucketTable[i].next;
				while(head != null){
					nums[arrayIndex++] = head.key;
					head = head.next;
				}//while
			}//if
		}//for
	}
	
	

}

