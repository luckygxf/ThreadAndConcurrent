package com.gxf.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class TestAnnotation {
	public static void main(String args[]){
		System.out.println("Test");
	}
}

class Father{
	public void method(){
		
	}
	@Test(value = "test")
	public void method1(){
		
	}
	
	
}

class Son extends Father{
	@Override
	public void method(){
		
	}
}

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface Test{
	public String value();
}