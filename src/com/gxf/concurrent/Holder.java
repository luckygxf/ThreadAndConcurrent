package com.gxf.concurrent;

public class Holder {
	private int n;
	
	public Holder(int n){
		this.n = n;
	}
	
	public void assertSanity(){
		if(n != n){
			throw new AssertionError("this statement is false");
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static class Script implements Runnable{
		public Holder holder;
		
		public void initialize(){
			holder = new Holder(40);
		}
		
		@Override
		public void run() {
			
			
		}
		
	}
}
