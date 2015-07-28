package com.gxf.practice;

public class CatchDivideByZero {

	public static void main(String[] args) {
		try{
			int num = 5 / 0;
		}catch(Exception e){
			System.out.println("catched exception!");
			e.printStackTrace();
		}finally{
			System.out.println("this is finally");
		}

	}

}
