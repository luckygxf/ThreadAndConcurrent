package com.gxf.knifeoffer;

/**
 * 剑指offer
 * 面试题42
 * 翻转单词
 * 先整体翻转，针对每个单词翻转
 * @author GXF
 *
 */
public class ReverseString {

	public static void main(String[] args) {
		ReverseString reverseString = new ReverseString();
		String string = "I am a student.";
		System.out.println("string = " + string);
		String result = reverseString.getReverseString(string);
		
		System.out.println("result = " + result);
	}
	
	public String getReverseString(String string){
		StringBuilder sb = new StringBuilder(string);
		
		reverseString(sb, 0, string.length() - 1);
		System.out.println("result = " + sb.toString());
		
		int startPoint = 0;
		int endPoint = 0;
		
		for(; endPoint < sb.length(); ){
			if(sb.charAt(startPoint) == ' '){
				startPoint++;
				endPoint++;
			}
			else if(sb.charAt(endPoint) == ' ' || sb.length() == endPoint){
				reverseString(sb, startPoint, --endPoint);
				startPoint = (++endPoint);
			}
			else
				endPoint++;
		}//for
		
		return sb.toString();
	}
	
	/**
	 * string效率太低
	 * stringbuffer有同步控制，效率不高
	 * 首选使用stringbuilder
	 * @param sb
	 * @param start
	 * @param end
	 */
	public void reverseString(StringBuilder sb, int start, int end){
		
		
		while(start < end){
			char temp = sb.charAt(start);
			sb.setCharAt(start, sb.charAt(end));
			sb.setCharAt(end, temp);
			start++;
			end--;
		}//while
	}

}
