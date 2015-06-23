package com.gxf.concurrent;

import java.util.Timer;
import java.util.TimerTask;

public class OutOfTime {
	public static void main(String args[]) throws InterruptedException{
		Timer timer = new Timer();
		timer.schedule(new ThrowTask(), 1);
		Thread.sleep(1000);
		timer.schedule(new ThrowTask(), 1);
		Thread.sleep(5000);
	}
	
	static class ThrowTask extends TimerTask{
		public void run(){
			throw new RuntimeException();
		}
	}
}
