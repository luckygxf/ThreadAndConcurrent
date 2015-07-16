package com.gxf.concurrent;

/**
 * �Ծ�̬����ʹ��synchronized����
 * ����סClass���󣬶����еĶ���ʵ��ͬ������
 * @author GXF
 *
 */
public class StaticMethod {

	public static void main(String[] args) {
		MethodClass methodClass = new MethodClass();
		Thread thread1 = new Thread(new ScriptTask(methodClass));
		Thread thread2 = new Thread(new ScriptTask(new MethodClass()));
		
		thread1.start();
		thread2.start();

	}

}


class MethodClass{
	public synchronized static void showMessage() throws InterruptedException{
		System.out.println("��ʼִ��showMessage����");
		Thread.sleep(5000);
		System.out.println("����ִ��showMessage����");
	}
}

class ScriptTask implements Runnable{
	MethodClass methodClass;
	
	public ScriptTask(MethodClass methodClass){
		this.methodClass = methodClass;
		System.out.println("hashcode = " + methodClass.hashCode());
	}
	
	@Override
	public void run() {
		try {
			methodClass.showMessage();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}