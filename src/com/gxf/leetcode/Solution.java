package com.gxf.leetcode;

import java.util.Stack;

public class Solution {
	Stack<Integer> nums = new Stack<Integer>();
	Stack<Character> operations = new Stack<Character>();
	
    public int calculate(String s) {
//        int result = 0;
    	for(int i = 0; i < s.length(); i++){        	
    		char temp = s.charAt(i);
    		if(s.charAt(i) == ' ')										//¿Õ¸ñ
    			continue;			
    		else if(s.charAt(i) == '(')									//×óÀ¨ºÅ
    			nums.push(-1);
    		else if(s.charAt(i) == '+' || s.charAt(i) == '-')			//ÔËËã·û
    			operations.push(s.charAt(i));
    		else if(s.charAt(i) >= '0' && s.charAt(i) <= '9'){			//Êý×Ö
    			int tempNum = s.charAt(i++) - '0';
    			while(i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9'){
    				tempNum = tempNum * 10 + s.charAt(i) - '0';
    				i++;
    			}
    			i--;
    			nums.push(tempNum);
    		}
    		else{														//ÓÒÀ¨ºÅ
    			do{
    				int num1 = nums.pop();
    				int num2 = nums.pop();
    				char operator = operations.pop();
    				if(operator == '+')
    					nums.push(num1 + num2);
    				else
    					nums.push(num2 - num1);
    			}while(nums.peek() != -1);
    			nums.pop();
    		}
        }//for
        
    	while(!operations.isEmpty()){
    		int num1 = nums.pop();
			int num2 = nums.pop();
			char operator = operations.pop();
			if(operator == '+')
				nums.push(num1 + num2);
			else
				nums.push(num2 - num1);
    	}//while
    	
    	
        return nums.peek();
    }
}