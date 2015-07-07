package com.gxf.algorithm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 查找在两个数组中公共值
 * @author GXF
 *
 */
public class FindSameNum {
	
	public List<Integer> findSameNumInTwoArray(int nums1[], int nums2[]){
		List<Integer> result = new ArrayList<Integer>();
		Set<Integer> numsInArray = new HashSet<Integer>();
		
		if(nums1 == null || nums2 == null)
			return result;
		
		for(int i = 0; i < nums1.length; i++){
			numsInArray.add(nums1[i]);
		}
		for(int i = 0; i < nums2.length; i++){
			if(numsInArray.contains(nums2[i]) && !result.contains(nums2[i])){
				result.add(nums2[i]);
			}
		}//for
		
		return result;
	}
	
	public static void main(String args[]){
		FindSameNum findNum = new FindSameNum();
		int nums1[] = {1,5,9,3,6,8,6,6};
		int nums2[] = {9,6,8,7,6,2,3};
	
		List<Integer> result = findNum.findSameNumInTwoArray(nums1, nums2);
		
		System.out.println(result);
		
	}
	
	
}
