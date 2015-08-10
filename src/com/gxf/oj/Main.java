package com.gxf.oj;

import java.util.Scanner;

/**
 * º¼µçOJ
 * @author GXF
 *
 */
public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int count;
		count = scanner.nextInt();
		while(count > 0){
			String line = scanner.next();
			int numCount = 0;
			for(int i = 0; i < line.length(); i++){
				char tempChar = line.charAt(i);
				if(tempChar >= '0' && tempChar <= '9')
					numCount++;				
			}//for
			
			System.out.println(numCount);
			count--;
		}//while
		
		scanner.close();
	}

}
