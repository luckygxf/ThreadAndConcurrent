package com.gxf.practice;

import java.util.ArrayList;
import java.util.List;

/**
 * 数组的全排列
 * 回溯算法的应用
 * 需要对前面的状态进行记录，所以用了一个list记录
 * @author GXF
 *
 */
public class Permutations {
	private boolean visited[] = new boolean[6];	
	
	public void dfs(int nums[], int depth, List<Integer> cur){
		if(nums == null)
			return;
		if(depth == nums.length)
		{			
			System.out.println(cur);
			return;
		}
		for(int i = 0; i < nums.length; i++){
			if(visited[i] == false){
				visited[i] = true;
				cur.add(nums[i]);
				dfs(nums, depth + 1, cur);
				cur.remove(cur.size() - 1);
				visited[i] = false;
			}
		}
	}
	
	public static void main(String args[]){
		Permutations permutations = new Permutations();
		List<Integer> cur = new ArrayList<Integer>();
		int nums[] = {1,2,3,4,5,6};
		permutations.dfs(nums, 0, cur);
	}
}
