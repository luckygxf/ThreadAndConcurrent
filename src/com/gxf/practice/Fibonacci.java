package com.gxf.practice;

import java.util.*;

public class Fibonacci {
    public int getNthNumber(int n) {
        List<Integer> result = new ArrayList<Integer>();
        int mod = 1000000007;
        result.add(1);
        result.add(1);
        for(int i = 2; i < n; i++){
        	int f1 = result.get(i - 2);
        	int f2 = result.get(i - 1);
        	int fi = ((f1 + f2) % mod);
        	result.add(fi);
        	System.out.print(fi + " ");
        }
        
        return result.get(n - 1);
    }
    
    public static void main(String args[]){
    	Fibonacci fibonacci = new Fibonacci();
    	int result = fibonacci.getNthNumber(12);
    	System.out.println("result = " + result);
    }
}
