package com.gxf.practice;

import com.gxf.util.CharNode;
import com.gxf.util.Util;

/**
 * 用桶排序对字符数组排序
 * 里面的字符可能是a-z、A-Z、0-9.现在要求对数组进行排序，要求所有小写字符放在最前面，所有大写字符放在中间，所有数字放在最后。而且各部分内部分别有序
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
	 * 使用桶排序对字符数组进行排序
	 * @param array
	 */
	public void bucketSortCharArray(char array[]){
		//这里只需要3个桶就okay了
		CharNode bucketTable[] = new CharNode[3];
		//初始化桶
		for(int i = 0; i < bucketTable.length; i++){
			bucketTable[i] = new CharNode(' ');
		}//for
		
		//开始桶排序
		for(int i = 0; i < array.length; i++){
			CharNode nodeToInsert = new CharNode(array[i]);
			int bucketIndex = getBucketIndext(array[i]);
			
			//如果对应的桶为空
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
		
		//遍历所有桶的数据，将数据放到原数组中
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
	 * a-z、A-Z、0-9
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
