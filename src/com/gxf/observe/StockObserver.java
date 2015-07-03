package com.gxf.observe;

public class StockObserver extends Observer {

	@Override
	public void update() {
		System.out.println("老板回来了，关闭股票");
	}

}
