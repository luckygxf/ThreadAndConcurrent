package com.gxf.test;

public class TestFinalize {

	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
		System.out.println("finalize()方法被调用");
		
	}
	
	
	public static void main(String args[]) throws InterruptedException{
		TestFinalize test = new TestFinalize();
		Thread.sleep(5000);
	}
}
