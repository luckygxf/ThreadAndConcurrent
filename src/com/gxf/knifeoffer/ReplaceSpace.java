package com.gxf.knifeoffer;

/**
 * ��ָoffer
 * ������4
 * ���ַ����հ״��á�%20���滻
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
