package com.gxf.enumtest;

/**
 * ö�ٲʺ����ɫ
 * ���ඨ����
 * Ĭ��ʵ�� Comparable �� Serializable �ӿ�
 * Ĭ����д��toString()����
 * ����Ϊö���ṩ������ķ���������
 * ö�ٿ������Լ��Ĺ��캯������ֻ����private����Ĭ�ϰ������
 * @author GXF
 *
 */
public enum RainbowColor {
	RED,
	ORANGE,
	YELLOW,
	GREEN,
	CYAN,
	BLUE,
	PURPLE;
	
	public RainbowColor getDefaultColor(){
		return BLUE;
	}
	
	public int getNums(){
		return RainbowColor.values().length;
	}
}
