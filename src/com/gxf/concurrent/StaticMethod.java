package com.gxf.concurrent;

/**
 * 对静态方法使用synchronized修饰
 * 会锁住Class对象，对所有的对象实现同步访问
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
		System.out.println("开始执行showMessage方法");
		Thread.sleep(5000);
		System.out.println("结束执行showMessage方法");
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