package com.gxf.enumtest;

enum SingletonEnum {
	INSTANCE;
}

public class Singleton{
	public static void main(String args[]){
		System.out.println(SingletonEnum.INSTANCE.hashCode());
	}
}
