package com.gxf.concurrent;

public class TestRunTimeException {

	public static void main(String args[]){
		try {
			throwException();
		} catch (Exception e) {
			System.out.println("catch exception!");
			e.printStackTrace();
		}
	}
	
	public static void throwException() throws Exception{
		throw new RuntimeException("Test F");
	}
}

