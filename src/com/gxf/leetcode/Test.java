package com.gxf.leetcode;

import java.util.List;

import com.gxf.util.Util;

//      4
//	  /   \
//   7     2
//  / \   / \
// 9   6 3   1

public class Test {

	public static void main(String[] args) {
		Solution sol = new Solution();
		int nums[] = {0,1};
		
		List<String> result = sol.summaryRanges(nums);
		System.out.println(result);
	}
	
	public static void showList(List<String> listOfString){
		
	}
}
