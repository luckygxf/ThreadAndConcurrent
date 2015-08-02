package com.gxf.practice;

public class GoUpstairs {
    public int countWays(int n) {        
        int f1 = 1;
        int f2 = 1;
        if(n == 0 || n == 1)
        	return 1;
        int result = 0;
        for(int i = 2; i < n; i++)
        {
        	result = ((f1 + f2) % 1000000007);
        	f1 = f2;
        	f2 = result;
        }
        return result;
    }
}
