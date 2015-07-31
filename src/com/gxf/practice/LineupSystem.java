package com.gxf.practice;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * 排队系统实现
 * 腾讯2014笔试题
 * 让每个进入队伍的用户都能看到自己在 中所处的位置和变化。队伍可能随时有人加入和退出，当有人退出影响到用户的位置排名时需要即时反馈到用户
 * 使用观察者模式实现
 * @author GXF
 *
 */
public class LineupSystem {
	//排队队列
	private List<People> queue = new LinkedList<People>();
	
	public static void main(String[] args) {
		LineupSystem lineupSystem = new LineupSystem();
		People peoples[] = new People[10];
		for(int i = 1; i < peoples.length; i++){
			peoples[i] = new People(lineupSystem, "zhangsan" + i);
			peoples[i].add();
		}

	}
	
	//入队
	public void add(People people){
		queue.add(people);
		notifyAllPeople();
	}
	//出队
	public void exit(People people){
		queue.remove(people);
		notifyAllPeople();
	}
	//通知队列里所有人的位置
	public void notifyAllPeople(){
		Iterator<People> it_people = queue.iterator();
		while(it_people.hasNext()){
			People temp = it_people.next();
			int index = queue.indexOf(temp);
			temp.setPosition(index + 1);
			temp.showPosition();
		}
	}

}

/**
 * 排队的人
 * @author GXF
 *
 */
class People{
	//排队队列
	private LineupSystem queue;
	//在队列中位置
	private int position;
	private String name;
	
	public People(LineupSystem queue, String name){
		this.queue = queue;
		this.name = name;
	}
	
	//排队
	public void add(){
		queue.add(this);
	}
	//出队
	public void exit(){
		queue.equals(this);
	}
	//设置在队列中位置
	public void setPosition(int position){
		this.position = position;
	}
	//显示在队列中的位置
	public void showPosition(){
		System.out.println(name + " 在队列中的位置为: " + position);
	}
}
