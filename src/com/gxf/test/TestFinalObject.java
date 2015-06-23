package com.gxf.test;

public class TestFinalObject {
	public final Object object = new Object();
	
	public static void main(String[] args) {
		TestFinalObject testFinalObject1 = new TestFinalObject();
		TestFinalObject testFinalObject2 = new TestFinalObject();
		
		System.out.println(testFinalObject1.object.hashCode());
		System.out.println(testFinalObject2.object.hashCode());
	}

}
