package com.gxf.enumtest;

/**
 * 枚举彩虹的颜色
 * 和类定义差不多
 * 默认实现 Comparable 和 Serializable 接口
 * 默认重写了toString()方法
 * 可以为枚举提供类似类的方法和属性
 * 枚举可以有自己的构造函数，但只能是private或者默认包级别的
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
