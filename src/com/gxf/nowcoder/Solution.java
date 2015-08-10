package com.gxf.nowcoder;

public class Solution {
    public int JumpFloorII(int target) {
        if(target == 1)
        	return 1;
        int result = 1;
        for(int i = target - 1; i >= 1; i--){
        	result += JumpFloorII(i);
        }
        
        return result;
    }
}