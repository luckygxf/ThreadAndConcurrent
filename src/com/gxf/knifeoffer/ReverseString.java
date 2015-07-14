package com.gxf.knifeoffer;

/**
 * ��ָoffer
 * ������42
 * ��ת����
 * �����巭ת�����ÿ�����ʷ�ת
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
	 * stringЧ��̫��
	 * stringbuffer��ͬ�����ƣ�Ч�ʲ���
	 * ��ѡʹ��stringbuilder
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
