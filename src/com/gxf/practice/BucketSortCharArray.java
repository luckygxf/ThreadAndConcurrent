package com.gxf.practice;

import com.gxf.util.CharNode;
import com.gxf.util.Util;

/**
 * ��Ͱ������ַ���������
 * ������ַ�������a-z��A-Z��0-9.����Ҫ��������������Ҫ������Сд�ַ�������ǰ�棬���д�д�ַ������м䣬�������ַ�����󡣶��Ҹ������ڲ��ֱ�����
 * @author GXF
 *
 */
public class BucketSortCharArray {

	public static void main(String[] args) {
		String string = "asdfasdfa16a5f6d6546d5f46sa5d4f4F6AS5F4A6D4FFa4fa56d4fa";
		char array[] = string.toCharArray();
		BucketSortCharArray bucketSortCharArray = new BucketSortCharArray();
		Util.showCharArray(array);
		bucketSortCharArray.bucketSortCharArray(array);
		Util.showCharArray(array);

	}
	
	/**
	 * ʹ��Ͱ������ַ������������
	 * @param array
	 */
	public void bucketSortCharArray(char array[]){
		//����ֻ��Ҫ3��Ͱ��okay��
		CharNode bucketTable[] = new CharNode[3];
		//��ʼ��Ͱ
		for(int i = 0; i < bucketTable.length; i++){
			bucketTable[i] = new CharNode(' ');
		}//for
		
		//��ʼͰ����
		for(int i = 0; i < array.length; i++){
			CharNode nodeToInsert = new CharNode(array[i]);
			int bucketIndex = getBucketIndext(array[i]);
			
			//�����Ӧ��ͰΪ��
			if(bucketTable[bucketIndex].next == null)
				bucketTable[bucketIndex].next = nodeToInsert;
			else{
				CharNode head = bucketTable[bucketIndex];
				while(head.next != null && head.next.val < array[i])
					head = head.next;
				nodeToInsert.next = head.next;
				head.next = nodeToInsert;
			}//else
		}//for
		
		//��������Ͱ�����ݣ������ݷŵ�ԭ������
		int arrayIndex = 0;
		for(int i = 0; i < bucketTable.length; i++){
			CharNode head = bucketTable[i].next;
			while(head != null){
				array[arrayIndex++] = head.val; 
				head = head.next;
			}//while
		}
	}
	
	/**
	 * a-z��A-Z��0-9
	 * @param element
	 * @return
	 */
	private int getBucketIndext(char element){
		if(element >= 'a' && element <= 'z')
			return 0;
		else if(element >= 'A' && element <= 'Z')
			return 1;
		return 2;
	}

}
