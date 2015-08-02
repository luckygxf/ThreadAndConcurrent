package com.gxf.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Solution {
    public boolean isAnagram(String s, String t) {
        if(s == null || t == null)
        	return false;
        if(s.length() != t.length())
        	return false;
        Map<Character, Integer> counter = new HashMap<Character, Integer>();
        for(int i = 0; i < s.length(); i++)
        {
        	Integer tempCounter = counter.get(s.charAt(i));
        	if(tempCounter == null)
        		counter.put(s.charAt(i), 1);
        	else
        		counter.put(s.charAt(i), ++tempCounter);
        }
        for(int i = 0; i < t.length(); i++){
        	Integer tempCounter = counter.get(t.charAt(i));
        	if(tempCounter == null)
        		return false;
        	else
        		counter.put(t.charAt(i), --tempCounter);
        }
        //遍历map集合
        Iterator<Character> it = counter.keySet().iterator();
        while(it.hasNext()){
        	char tempChar = it.next();
        	if(counter.get(tempChar) != 0)
        		return false;
        }
        
        return true;
    }
}

class ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
    	if(nums == null || nums.length == 0)
    		return null;
    	long allProduct = 1;
    	for(int i = 0; i < nums.length && allProduct != 0; i++)
    		allProduct *= nums[i];
    	int result[] = new int[nums.length];
    	
    	for(int i = 0; i < result.length; i++)
    	{
    		if(nums[i] == 0){
    			result[i] = getProductExceptSelf(nums, i);
    		}
    		else
    			result[i] = (int) (allProduct / (long)nums[i]);
    	}
    	
    	return result;
    }
    
    private int getProductExceptSelf(int nums[], int position){
    	int result = 1;
    	for(int i = 0; i < nums.length && result != 0; i++){
    		if(i == position)
    			continue;
    		result *= nums[i];
    	}//for
    	
    	return result;
    }
}



/**
 * 删除给定的单链表中的节点
 * 剑指offer上面的一道题
 * @author GXF
 *
 */
class SolutionDeleteNode {
    public void deleteNode(ListNode node) {
        if(node == null)
        	return;
        node.val = node.next.val;
        node.next = node.next.next;
    }
}

/**
 * 计算一个二叉排序树，两个节点的最低公共父节点
 * @author GXF
 *
 */
class SolutionLowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)
        	return root;
        if(root.val == p.val)
        	return p;
        if(root.val == q.val)
        	return q;
        if((root.val > p.val && root.val < q.val) || (root.val < p.val && root.val > q.val))
        	return root;
        else if(root.val > p.val && root.val > p.val)
        	return lowestCommonAncestor(root.left, p, q);
        else
        	return lowestCommonAncestor(root.right, p, q);
    }
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
