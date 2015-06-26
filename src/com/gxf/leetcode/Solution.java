package com.gxf.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
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