package com.gxf.jvm;

import java.util.List;

/**
 * java���Ͳ���
 * @author GXF
 *
 */
public class GenericTypes {

    public static String method(List<String> list) {
        System.out.println("invoke method(List<String> list)");
        return "";
    }

    public static int method1(List<Integer> list) {
        System.out.println("invoke method(List<Integer> list)");
        
        return 1;
    }
}
