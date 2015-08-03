package com.gxf.test;

/**
 * 运行时异常时可以catch的
 * @author GXF
 *
 */
public class CatchRuntimeException {

	public static void main(String[] args) {
		int array[] = {1,2,3,4,5};
		
		try{
			for(int i = 0; i< array.length; i++)
				System.out.println(array[i]);
			Error error = new Error("this is a error!");
			throw error;
		}
		catch(Throwable e){
			System.out.println("run time exception catched!");
		}
	}

}
