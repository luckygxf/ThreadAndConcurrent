package com.gxf.knifeoffer;

import java.util.HashMap;
import java.util.Map;

/**
 * 剑指offer
 * 面试题35
 * 第一次只出现一次的字符
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
		//第一遍扫描，做统计
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
