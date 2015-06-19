package com.gxf.leetcode;

import java.util.LinkedList;
import java.util.Queue;

class MyStack {
	private Queue<Integer> queue1 = new LinkedList<Integer>();
	private Queue<Integer> queue2 = new LinkedList<Integer>();
	
    public void push(int x) {
        if(queue1.isEmpty())
        	queue2.add(x);
        else
        	queue1.add(x);
    }


    public void pop() {
        if(empty())
        	return;
        if(!queue1.isEmpty()){
        	int temp = queue1.poll();
        	while(!queue1.isEmpty()){
        		queue2.add(temp);
        		temp = queue1.poll();
        	}
        }
        else{
        	int temp = queue2.poll();
        	while(!queue2.isEmpty()){
        		queue1.add(temp);
        		temp = queue2.poll();
        	}
        }
    }


    public int top() {
        if(empty())
        	return queue1.poll();
        if(!queue1.isEmpty()){
        	int temp = queue1.poll();
        	while(!queue1.isEmpty()){
        		queue2.add(temp);
        		temp = queue1.poll();
        	}
        	queue2.add(temp);
        	return temp;
        }
        if(!queue2.isEmpty()){
        	int temp = queue2.poll();
        	while(!queue2.isEmpty()){
        		queue1.add(temp);
        		temp = queue2.poll();
        	}
        	queue1.add(temp);
        	return temp;
        }
        return -1;
    }


    public boolean empty() {
        return queue1.isEmpty() && queue2.isEmpty();
    }
}