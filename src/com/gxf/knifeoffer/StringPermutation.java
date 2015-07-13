package com.gxf.knifeoffer;

/**
 * ��ָoffer
 * ������28
 * �ַ���������
 * ��Ҫ�õ��˻����㷨
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
