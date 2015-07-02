package com.gxf.designpattern;

/**
 * ״̬ģʽ
 * ���ڲ�����״̬ת�Ƶ��ⲿ��
 * ʹ�ó������ά��
 * ���״̬�޸�����С
 * @author GXF
 *
 */
public class StatePattern {
	public static void main(String args[]){
		Work emergencyProjects = new Work();
		emergencyProjects.setHour(9);
		emergencyProjects.writeProgram();		
		emergencyProjects.setHour(10);
		emergencyProjects.writeProgram();		
		emergencyProjects.setHour(12);
		emergencyProjects.writeProgram();	
		emergencyProjects.setHour(14);
		emergencyProjects.writeProgram();		
		emergencyProjects.setHour(17);
		emergencyProjects.writeProgram();		
		emergencyProjects.setHour(19);
		emergencyProjects.writeProgram();		
		emergencyProjects.setHour(22);
		emergencyProjects.writeProgram();		
	}
}

class Work{
	private int hour;
	private State currentState;
	
	public Work(){
		currentState = new ForenoonState();
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public State getCurrentState() {
		return currentState;
	}

	public void setCurrentState(State currentState) {
		this.currentState = currentState;
	}
	
	public void writeProgram(){
		currentState.writeProgram(this);
	}
	
}
abstract class State{
	//��ש
	public abstract void writeProgram(Work work);
}

/**
 * ����
 * @author GXF
 *
 */
class ForenoonState extends State{

	@Override
	public void writeProgram(Work work) {
		if(work.getHour() < 12){
			System.out.println("��ǰʱ�䣺" + work.getHour() + "�㣬���繤��������ٱ�");

		}
		else
		{
			work.setCurrentState(new NoonState());
			work.writeProgram();
		}
		
	}	
}

/**
 * ���繤��״̬
 * @author GXF
 *
 */
class NoonState extends State{

	@Override
	public void writeProgram(Work work) {
		if(work.getHour() < 13){
			System.out.println("��ǰʱ�䣺" + work.getHour() + "�㣬�緹�����������ݡ�");
			
		}
		else{
			work.setCurrentState(new AfterNoonState());
			work.writeProgram();
		}
		
	}
	
}

/**
 * ���繤��״̬
 * @author GXF
 *
 */
class AfterNoonState extends State{

	@Override
	public void writeProgram(Work work) {
		if(work.getHour() < 17){
			System.out.println("��ǰʱ�䣺" + work.getHour() + "�㣬����״̬����������Ŭ��");

		}
		else{
			work.setCurrentState(new EveningState());
			work.writeProgram();
		}
	}
	
}

/**
 * ��乤��״̬
 * @author GXF
 *
 */
class EveningState extends State{

	@Override
	public void writeProgram(Work work) {
		if(work.getHour() < 20){
			System.out.println("��ǰʱ�䣺" + work.getHour() + "�㣬�Ӱ�Ŷ��ƣ������");

		}else{
			work.setCurrentState(new ForceRestState());
			work.writeProgram();
		}
		
	}
	
}

/**
 * �°���Ϣ״̬
 * @author GXF
 *
 */
class RestState extends State{

	@Override
	public void writeProgram(Work work) {
		System.out.println("��ǰʱ�䣺" + work.getHour() + "�㣬�°�ؼ���");
		
	}
	
}

/**
 * ����20��ǿ���°�
 * @author GXF
 *
 */
class ForceRestState extends State{

	@Override
	public void writeProgram(Work work) {
		System.out.println("��ǰʱ�䣺" + work.getHour() + "ǿ���°�!");
		
	}
	
}









