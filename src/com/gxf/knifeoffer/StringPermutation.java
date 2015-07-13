package com.gxf.knifeoffer;

/**
 * 剑指offer
 * 面试题28
 * 字符串的排列
 * 主要用到了回溯算法
 * @author GXF
 *
 */
public class StringPermutation {

	public static void main(String[] args) {
		String string = "abc";
		StringPermutation stringPermutation = new StringPermutation();
		stringPermutation.permutation(string,  "");
	}
	
	public void permutation(String string,  String cur){
		
		if(string.length() == 0)
		{			
			System.out.println(cur);
			return;
		}//if
		for(int i = 0; i < string.length(); i++){
			String leftString = string.substring(0, i) + string.substring(i + 1, string.length());
			permutation(leftString,  cur + string.charAt(i));
		}//for
		
	}

}
