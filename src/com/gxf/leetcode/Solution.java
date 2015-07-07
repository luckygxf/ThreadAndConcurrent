package com.gxf.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 用堆栈实现队列
 * 昨天刚好在剑指offer上面看到了
 * @author GXF
 *
 */
class MyQueue {
	private Stack<Integer> stack1 = new Stack<Integer>();
	private Stack<Integer> stack2 = new Stack<Integer>();
	
    // Push element x to the back of queue.
    public void push(int x) {
        stack1.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        if(stack2.isEmpty()){
        	while(!stack1.isEmpty()){
        		stack2.push(stack1.pop());
        	}//while
        }//if
        
        stack2.pop();
    }

    // Get the front element.
    public int peek() {
    	if(stack2.isEmpty()){
        	while(!stack1.isEmpty()){
        		stack2.push(stack1.pop());
        	}//while
        }//if
        
        return stack2.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}

class Solution {
    /**
     * 使用折半查找
     * @param n
     * @return
     */
    public boolean isPowerOfTwo(int n) {
    	if(n == 0 )
    		return false;
    	long num = n;
    	long result = 1;
    	
    	while(result <= num){
    		if(result == num)
    			return true;
    		result *= 2;
    	}//while
    	
    	return false;
    }
}



class SolutionSummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<String>();
        if(nums == null || nums.length == 0)
        	return result;
        if(nums.length == 1)
        {
        	result.add(String.valueOf(nums[0]));
        	return result;
        }
        
        int point = 1;
        int start = 0;
        int end = 0;
        
        while(point < nums.length){
        	if(nums[point] - nums[point - 1] != 1){
        		addStringToList(result, nums, start, end);
        		start = point;
        		end = point;
        	}
        	else{
        		end++;
        	}
        	
        	point++;
        }//while
        
        addStringToList(result, nums, start, end);
        
        return result;
    }
    
    private void addStringToList(List<String> result,int nums[], int start, int end){
    	if(start == end){
    		result.add("\"" + nums[start] + "\"");
    	}
    	else{
    		String element = "\"" + nums[start] + "->" + nums[end] + "\"";
    		result.add(element);    		
    	}
    }
    
}