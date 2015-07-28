package com.gxf.practice;

/**
 * 华为校招机试题
 * 字符串压缩
 * 边界条件的考虑
 * 这里需要注意字符个数大于10
 * @author GXF
 *
 */
public class StringZip {

	public static void main(String[] args) {
		String string = "xxxyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyz";
		char output[] = new char[string.length()];
		StringZip stringZip = new StringZip();
		stringZip.stringZip(string.toCharArray(), output);
		
		String result = new String(output);
		System.out.println("result = " + result);
	}
	
	/**
	 * 字符串压缩
	 * @param input
	 * @param output
	 */
	public void stringZip(char input[], char output[]){
		if(input == null || output == null || input.length == 0)
			return;
		int dstIndex = 0;
		char pre = input[0];
		int srcPtr = 1;
		int repeatCount = 1;
		
		while(srcPtr < input.length){
			if(pre == input[srcPtr]){
				repeatCount++;
				srcPtr++;
				continue;
			}//if
			//如果repeatCount > 10
			while(repeatCount > 1){
				int temp = repeatCount % 10;
				output[dstIndex++] = (char)(temp + '0');
				repeatCount /= 10;
			}
		
			output[dstIndex++] = pre;
			pre = input[srcPtr];
			repeatCount = 1;
			srcPtr++;			
		}//while
		//处理最后一个字符
		while(repeatCount > 1){
			int temp = repeatCount % 10;
			output[dstIndex++] = (char)(temp + '0');
			repeatCount /= 10;
		}
		output[dstIndex++] = pre;
		
	}
}
