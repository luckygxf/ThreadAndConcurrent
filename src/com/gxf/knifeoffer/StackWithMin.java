package com.gxf.knifeoffer;

import java.util.Stack;

/**
 * 剑指offer
 * 面试题21
 * 带有min函数的栈
 * @author GXF
 *
 */
public class StackWithMin {
	private Stack<Integer> contentOfStack = new Stack<Integer>();
	private Stack<Integer> minOfStack = new Stack<Integer>();

	public static void main(String[] args) {
		StackWithMin stackWithMin = new StackWithMin();
		for(int i = 0; i < 10; i++){
			stackWithMin.push(i);
		}
		
		while(!stackWithMin.isEmpty()){
			System.out.println(stackWithMin.getMin() + " ");
			System.out.println(stackWithMin.pop() + " ");
		}

	}
	
	public int pop() {
		minOfStack.pop();
		return contentOfStack.pop();
	}
	public void push(int val){
		contentOfStack.push(val);
		if(minOfStack.size() == 0 || val < minOfStack.peek())
			minOfStack.push(val);
		else
			minOfStack.push(minOfStack.peek());
	}
	public boolean isEmpty(){
		return contentOfStack.isEmpty();
	}
	
	public int getMin(){
		return minOfStack.peek();
	}
}
