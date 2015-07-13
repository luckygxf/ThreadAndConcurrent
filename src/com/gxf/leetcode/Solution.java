package com.gxf.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        
//    }
}

class SolutionIsPalindrome {
	//这里的时间复杂度为O（n）空间复杂度也是o(n)
	//题目要求时间复杂度为o(n) 空间复杂度为o(1)
    public boolean isPalindrome(ListNode head) {
        if(head == null)
        	return true;
        Stack<Integer> stackOfNode = new Stack<Integer>();
        
        ListNode tempHead = head;
        while(tempHead != null){
        	stackOfNode.push(tempHead.val);
        	tempHead = tempHead.next;
        }//while
        
        tempHead = head;
        while(tempHead != null){
        	if(tempHead.val != stackOfNode.pop())
        		return false;
        	tempHead = tempHead.next;
        }//while
        
        return true;
    }
}

class SolutionCountDigitOne {
    /**
     * 计算小于等于n的数字里面1的个数，总和
     * 超时了，还需要优化 
     * @param n
     * @return
     */
    public int countDigitOne(int n) {
    	int count = 0;
        for(int i = 1; i <= n; i++){
        	count += getNumsOfOne(i);
        }//for

        
        return count;
    }
    
    /**
     * 计算一个数字中1的个数
     * @param num
     * @return
     */
    private int getNumsOfOne(int num){
    	int count = 0;
    	String stringOfNum = String.valueOf(num);
    	for(int i = 0; i < stringOfNum.length(); i++){
    		if(stringOfNum.charAt(i) == '1')
    			count++;
    	}
    	
    	return count;
    }
    
}

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

class SolutionIsPowerOfTwo {
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
