package com.gxf.leetcode;

import com.gxf.util.Util;

//      4
//	  /   \
//   7     2
//  / \   / \
// 9   6 3   1

public class Test {

	public static void main(String[] args) {
		MyStack stack = new MyStack();
		
		
		while(!stack.empty()){
			System.out.println(stack.top());
			stack.pop();
		}
	
	}

}
