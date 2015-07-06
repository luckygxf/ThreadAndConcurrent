package com.gxf.knifeoffer;

import java.util.Stack;

/**
 * ��ָoffer
 * ������7
 * ������ջʵ�ֶ��й���
 * @author GXF
 *
 */
public class QueueWithTwoStack {
	private Stack<Integer> stack1 = new Stack<Integer>();
	private Stack<Integer> stack2 = new Stack<Integer>();
	
	/**
	 * ���
	 * @param element
	 */
	public void addToTail(Integer element){
		stack1.push(element);
	}
	
	/**
	 * ����
	 * @return
	 * @throws Exception 
	 */
	public int deleteHead() throws Exception{
		//ջ2�����ջ
		if(stack2.isEmpty()){
			while(!stack1.isEmpty()){
				stack2.push(stack1.pop());
			}//while
		}//if
		
		if(stack2.isEmpty())
			throw new Exception("����Ϊ��");
		return stack2.pop();
	}
	
	public boolean isEmpty(){
		return stack1.isEmpty() && stack2.isEmpty();
	}
	
	public static void main(String args[]) throws Exception{
		QueueWithTwoStack queue = new QueueWithTwoStack();
		
		for(int i = 0; i < 10; i++)
			queue.addToTail(i);
		
		while(!queue.isEmpty())
			System.out.print(queue.deleteHead() + " ");
		
	}
}
