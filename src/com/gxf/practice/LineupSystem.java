package com.gxf.practice;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * �Ŷ�ϵͳʵ��
 * ��Ѷ2014������
 * ��ÿ�����������û����ܿ����Լ��� ��������λ�úͱ仯�����������ʱ���˼�����˳����������˳�Ӱ�쵽�û���λ������ʱ��Ҫ��ʱ�������û�
 * ʹ�ù۲���ģʽʵ��
 * @author GXF
 *
 */
public class LineupSystem {
	//�ŶӶ���
	private List<People> queue = new LinkedList<People>();
	
	public static void main(String[] args) {
		LineupSystem lineupSystem = new LineupSystem();
		People peoples[] = new People[10];
		for(int i = 1; i < peoples.length; i++){
			peoples[i] = new People(lineupSystem, "zhangsan" + i);
			peoples[i].add();
		}

	}
	
	//���
	public void add(People people){
		queue.add(people);
		notifyAllPeople();
	}
	//����
	public void exit(People people){
		queue.remove(people);
		notifyAllPeople();
	}
	//֪ͨ�����������˵�λ��
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
 * �Ŷӵ���
 * @author GXF
 *
 */
class People{
	//�ŶӶ���
	private LineupSystem queue;
	//�ڶ�����λ��
	private int position;
	private String name;
	
	public People(LineupSystem queue, String name){
		this.queue = queue;
		this.name = name;
	}
	
	//�Ŷ�
	public void add(){
		queue.add(this);
	}
	//����
	public void exit(){
		queue.equals(this);
	}
	//�����ڶ�����λ��
	public void setPosition(int position){
		this.position = position;
	}
	//��ʾ�ڶ����е�λ��
	public void showPosition(){
		System.out.println(name + " �ڶ����е�λ��Ϊ: " + position);
	}
}
