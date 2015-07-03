package com.gxf.observe;

/**
 * 测试观察者模式
 * 来自大话西游
 * @author GXF
 *
 */
public class Test {

	public static void main(String[] args) {
		//搞个秘书，监听
		Subject xiaoFang = new Secretary();
		//搞两个同事
		Observer xiaoZou = new StockObserver();
		Observer xiaoLiu = new NBAObserver();
		
		//注册到秘书那里
		xiaoFang.attach(xiaoLiu);
		xiaoFang.attach(xiaoZou);
		
		//老板回来了,秘书赶紧通知他们，粗事了
		xiaoFang.notifyObserver();

	}

}
