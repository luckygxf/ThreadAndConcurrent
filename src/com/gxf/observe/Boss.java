package com.gxf.observe;

import java.util.ArrayList;
import java.util.List;

public class Boss implements Subject {
	private List<Observer> observers = new ArrayList<Observer>();
	
	@Override
	public void attach(Observer observer) {
		observers.add(observer);

	}

	@Override
	public void detach(Observer observer) {
		observers.remove(observer);

	}

	@Override
	public void notifyObserver() {
		for(int i = 0; i < observers.size(); i++)
		{
			Observer observer = observers.get(i);
			observer.update();
		}

	}

}
