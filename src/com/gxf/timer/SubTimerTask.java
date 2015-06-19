package com.gxf.timer;

import java.util.Timer;
import java.util.TimerTask;

public class SubTimerTask extends TimerTask{
	private static int sequence = 0;
	
	public SubTimerTask(){
		sequence++;
	}
	
	@Override
	public void run() {
		System.out.println("timerTask " + sequence +  " is runing");
		
	}
	
	public static void main(String args[]) throws InterruptedException{
		Timer timer = new Timer();
		timer.schedule(new SubTimerTask(), 1);
		Thread.sleep(1000);
		timer.schedule(new SubTimerTask(), 1);
		Thread.sleep(5000);
	}
	
}
