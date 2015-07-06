package com.gxf.knifeoffer;

import java.util.Stack;

/**
 * 剑指offer
 * 面试题7
 * 用两个栈实现队列功能
 * @author GXF
 *
 */
public class QueueWithTwoStack {
	private Stack<Integer> stack1 = new Stack<Integer>();
	private Stack<Integer> stack2 = new Stack<Integer>();
	
	/**
	 * 入队
	 * @param element
	 */
	public void addToTail(Integer element){
		stack1.push(element);
	}
	
	/**
	 * 出队
	 * @return
	 * @throws Exception 
	 */
	public int deleteHead() throws Exception{
		//栈2负责出栈
		if(stack2.isEmpty()){
			while(!stack1.isEmpty()){
				stack2.push(stack1.pop());
			}//while
		}//if
		
		if(stack2.isEmpty())
			throw new Exception("队列为空");
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
