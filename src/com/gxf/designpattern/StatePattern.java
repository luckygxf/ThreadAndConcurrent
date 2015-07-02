package com.gxf.designpattern;

/**
 * 状态模式
 * 将内部条件状态转移到外部类
 * 使得程序更易维护
 * 添加状态修改量更小
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
	//搬砖
	public abstract void writeProgram(Work work);
}

/**
 * 早上
 * @author GXF
 *
 */
class ForenoonState extends State{

	@Override
	public void writeProgram(Work work) {
		if(work.getHour() < 12){
			System.out.println("当前时间：" + work.getHour() + "点，上午工作，精神百倍");

		}
		else
		{
			work.setCurrentState(new NoonState());
			work.writeProgram();
		}
		
	}	
}

/**
 * 中午工作状态
 * @author GXF
 *
 */
class NoonState extends State{

	@Override
	public void writeProgram(Work work) {
		if(work.getHour() < 13){
			System.out.println("当前时间：" + work.getHour() + "点，午饭：犯困，午休。");
			
		}
		else{
			work.setCurrentState(new AfterNoonState());
			work.writeProgram();
		}
		
	}
	
}

/**
 * 下午工作状态
 * @author GXF
 *
 */
class AfterNoonState extends State{

	@Override
	public void writeProgram(Work work) {
		if(work.getHour() < 17){
			System.out.println("当前时间：" + work.getHour() + "点，下午状态还不错，继续努力");

		}
		else{
			work.setCurrentState(new EveningState());
			work.writeProgram();
		}
	}
	
}

/**
 * 晚间工作状态
 * @author GXF
 *
 */
class EveningState extends State{

	@Override
	public void writeProgram(Work work) {
		if(work.getHour() < 20){
			System.out.println("当前时间：" + work.getHour() + "点，加班哦，疲劳至极");

		}else{
			work.setCurrentState(new ForceRestState());
			work.writeProgram();
		}
		
	}
	
}

/**
 * 下班休息状态
 * @author GXF
 *
 */
class RestState extends State{

	@Override
	public void writeProgram(Work work) {
		System.out.println("当前时间：" + work.getHour() + "点，下班回家了");
		
	}
	
}

/**
 * 超过20点强制下班
 * @author GXF
 *
 */
class ForceRestState extends State{

	@Override
	public void writeProgram(Work work) {
		System.out.println("当前时间：" + work.getHour() + "强制下班!");
		
	}
	
}









