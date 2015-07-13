package com.gxf.knifeoffer;

import java.util.HashMap;
import java.util.Map;

/**
 * ��ָoffer
 * ������35
 * ��һ��ֻ����һ�ε��ַ�
 * @author GXF
 *
 */
public class FindFirstCharNotRepeat {

	public static void main(String[] args) {
		FindFirstCharNotRepeat findFirstCharNotRepeat = new FindFirstCharNotRepeat();
		String string = "abaccdeff";
		char result = findFirstCharNotRepeat.findFirstCharNotRepeat(string);
		
		System.out.println("result = " + result);
	}
	
	public char findFirstCharNotRepeat(String string){
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		char result = ' ';
		//��һ��ɨ�裬��ͳ��
		for(int i = 0; i < string.length(); i++){
			char temp = string.charAt(i);
			Integer counter = map.get(temp);
			if(counter == null)
				map.put(temp, 1);
			else
				map.put(temp, counter + 1);
		}//for
		
		for(int i = 0; i < string.length(); i++){
			char temp = string.charAt(i);
			if(map.get(temp) == 1)
			{
				result = temp;
				break;
			}
		}//for
		
		return result;
	}
}
