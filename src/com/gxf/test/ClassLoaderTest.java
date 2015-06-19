package com.gxf.test;

import java.io.IOException;
import java.io.InputStream;

public class ClassLoaderTest {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		ClassLoader myLoader = new ClassLoader(){

			@Override
			public Class<?> loadClass(String name)	throws ClassNotFoundException {				
				try {
					String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
					
					InputStream is = getClass().getResourceAsStream(fileName);
					if(is == null){					
						return super.loadClass(name);
					}
					byte[] b = new byte[is.available()];
					is.read(b);
					return defineClass(name, b, 0,b.length);
				} catch (IOException e) {
					throw new ClassNotFoundException();
				}
			}
			
		};//myLoader
		
		Object obj = myLoader.loadClass("com.gxf.test.ClassLoaderTest").newInstance();
		
		System.out.println(obj.getClass());
		System.out.println(obj instanceof com.gxf.test.ClassLoaderTest);

	}

}
