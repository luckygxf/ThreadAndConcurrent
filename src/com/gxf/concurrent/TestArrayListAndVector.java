package com.gxf.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import com.gxf.util.Util;

/**
 * ArrayList不是线程安全的
 * Vector是线程安全的
 * ArrayList效率要高于Vector在单线程中
 * @author GXF
 *
 */
public class TestArrayListAndVector {

	public static void main(String[] args) throws InterruptedException {
		List<Integer> arrayListOfInteger = new ArrayList<Integer>();
		List<Integer> vectorListOfInteger = new Vector<Integer>();
		
		ArrayListScript arrayListScript = new ArrayListScript(arrayListOfInteger);
		VectorScript vectorScript = new VectorScript(vectorListOfInteger);
		Thread thread1 = new Thread(vectorScript);
		Thread thread2 = new Thread(vectorScript);
		
		thread1.start();
		thread2.start();
		
		
		thread2.join();
		thread1.join();
		Util.showIntegerOfList(vectorListOfInteger);
	}

}

class ArrayListScript implements Runnable{
	public List<Integer> listOfInteger;
	
	public ArrayListScript(List<Integer> listOfInteger) {
		this.listOfInteger = listOfInteger;
	}
	
	@Override
	public void run() {
		for(int i = 0; i < 10; i++){
			try {
				listOfInteger.add(i);
				Thread.sleep(20);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}//for
	}
	
}

class VectorScript implements Runnable{
	List<Integer>  listOfInteger;
	
	public VectorScript(List<Integer>  listOfInteger) {
		this.listOfInteger = listOfInteger;
		
	}
	
	@Override
	public void run() {
		for(int i = 0; i < 10; i++){
			try {
				listOfInteger.add(i);
				Thread.sleep(20);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
}
