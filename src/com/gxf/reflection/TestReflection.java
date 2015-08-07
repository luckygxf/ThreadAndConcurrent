package com.gxf.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * ���Է���
 * ���䣬��Ҫ��ͨ����ȡClass���󣬵õ�Constructor����Method����ͨ��Constructor����ʵ����ͨ��Method������÷���
 * @author GXF
 *
 */
public class TestReflection {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Constructor<MyClass> myClassConstructor = MyClass.class.getConstructor(int.class);
		MyClass myClassObj = myClassConstructor.newInstance(5);
		Method myClassMethod = MyClass.class.getMethod("increase", int.class);
		myClassMethod.invoke(myClassObj, 5);
		System.out.println("myClassObj.count = " + myClassObj.count);
	}

}

class MyClass{
	int count;
	public MyClass(int start){
		count = start;
	}
	public void increase(int step){
		count += step;
	}
}
