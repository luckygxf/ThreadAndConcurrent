package com.gxf.knifeoffer;

/**
 * 剑指offer
 * 面试题4
 * 将字符串空白处用“%20”替换
 * @author GXF
 *
 */
public class ReplaceSpace {
	public String replaceSpace(String string){
		if(string == null || string.length() == 0)
			return string;
		String strings[] = string.split(" ");
		
		String result = "";
		
		for(int i = 0; i < strings.length - 1; i++){
			result += strings[i];
			result += "%20";
		}
		
		result += "%20";
		result += strings[strings.length - 1];
		
		return result;
	}
	
	public static void main(String args[]){
		ReplaceSpace replaceSpace = new ReplaceSpace();
		String string = "We are happy";
		
		String result = replaceSpace.replaceSpace(string);
		System.out.println("result = " + result);
	}
}
